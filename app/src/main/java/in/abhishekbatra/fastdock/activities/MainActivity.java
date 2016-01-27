package in.abhishekbatra.fastdock.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import in.abhishekbatra.fastdock.R;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private final OkHttpClient client = new OkHttpClient();

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> mStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.list_main);
        mStrings = new ArrayList<>();
        mStrings.add("Source: Abhishek Batra");
        mAdapter = new ArrayAdapter<>(this, R.layout.item_main, R.id.list_text_main, mStrings);
        mListView.setAdapter(mAdapter);


        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url("http://beta.json-generator.com/api/json/get/V1VUbmGYg")
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {

                        String responseData = response.body().string();
                        Log.d(TAG, responseData);
                        try {
                            final JSONObject data = new JSONObject(responseData);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mStrings.clear();
                                    try {
                                        String source = data.getString("source");
                                        mStrings.add("Source: " + source);

                                        JSONArray jsonArray = data.getJSONArray("drops");

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            mStrings.add(jsonArray.getString(i));
                                        }
                                        mAdapter.notifyDataSetChanged();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                });
            }
        }).start();
    }

    public void calculate(View v) {

        Intent intent = new Intent(this, RouteActivity.class);
        intent.putStringArrayListExtra("data", mStrings);
        startActivity(intent);

    }

}
