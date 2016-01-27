package in.abhishekbatra.fastdock.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;

import java.util.ArrayList;

import in.abhishekbatra.fastdock.adapters.StopAdapter;
import in.abhishekbatra.fastdock.models.Leg;
import in.abhishekbatra.fastdock.models.Route;
import in.abhishekbatra.fastdock.models.Stop;
import in.abhishekbatra.fastdock.models.WayPoint;

/**
 * Created by abhishek on 28/01/16 at 2:01 AM.
 */
public class StopFragment extends ListFragment {

    private static Fragment instance;

    public static Fragment newInstance() {

        if(instance == null) {
            instance =  new StopFragment();
        }

        return instance;
    }


    private ArrayList<Stop> mStops;
    private StopAdapter mStopAdapter;

    /**
     * Attach to list view once the view hierarchy has been created.
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mStops = new ArrayList<>();
        mStopAdapter = new StopAdapter(getContext(), mStops);

        setListAdapter(mStopAdapter);
        setEmptyText("No Route Found");
        getListView().setDividerHeight(0);


    }

    public void updateList(WayPoint wayPoint) {


        if (wayPoint.getRoutes() != null && wayPoint.getRoutes().size() > 0) {
            Route route = wayPoint.getRoutes().get(0);
            int count = 1;
            for (Leg leg : route.getLegs()) {
                Stop stop = new Stop(count++, leg.getStartAddress().substring(0, leg.getStartAddress().indexOf(',')), leg.getDistance().getText());
                mStops.add(stop);

            }

            mStopAdapter.notifyDataSetChanged();
        }
    }
}
