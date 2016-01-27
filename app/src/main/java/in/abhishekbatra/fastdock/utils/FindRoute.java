package in.abhishekbatra.fastdock.utils;

import android.util.Log;

import java.util.ArrayList;

import in.abhishekbatra.fastdock.fragments.MapFragment;
import in.abhishekbatra.fastdock.fragments.StopFragment;
import in.abhishekbatra.fastdock.models.WayPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by abhishek on 27/01/16 at 9:02 PM.
 */
public class FindRoute {

    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/";
    public static final String API_KEY = "AIzaSyAWvRtY3YHKAnrjDDNmaMiIwmm1HM3TQJs";
    private static final String TAG = "FindRoute";


    public static void getResponse(String source, String destination, ArrayList<String> wayPoints, final MapFragment mapFragment) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WayPointService wayPointService = retrofit.create(WayPointService.class);

        String wayPointsString = "optimize:true";
        for (String wayPoint : wayPoints) {
            wayPointsString += "|" + urlEncode(wayPoint);
        }

        Log.d(TAG, wayPointsString);


        Call<WayPoint> call = null;
        call = wayPointService.getWayPoints(urlEncode(source), urlEncode(destination), wayPointsString, API_KEY);
        call.enqueue(new Callback<WayPoint>() {
            @Override
            public void onResponse(Response<WayPoint> response) {
                WayPoint wayPoint = response.body();
                Log.d(TAG, wayPoint.getStatus());
                mapFragment.plotPoints(wayPoint);
                ((StopFragment) StopFragment.newInstance()).updateList(wayPoint);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, "Failure");
            }
        });


    }

    public static String urlEncode(String data) {
        return data.replaceAll(" ", "+");
    }

    public interface WayPointService {
        @GET("directions/json")
        Call<WayPoint> getWayPoints(@Query("origin") String origin, @Query("destination") String destination, @Query("waypoints") String wayPoints, @Query("key") String key);
    }
}
