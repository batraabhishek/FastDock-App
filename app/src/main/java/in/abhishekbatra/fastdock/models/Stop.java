package in.abhishekbatra.fastdock.models;

/**
 * Created by abhishek on 28/01/16 at 1:50 AM.
 */
public class Stop {

    private int mStopNo;
    private String mPlace;
    private String mDistance;


    public Stop(int stopNo, String place, String distance) {
        mStopNo = stopNo;
        mPlace = place;
        mDistance = distance;
    }

    public int getStopNo() {
        return mStopNo;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getDistance() {
        return mDistance;
    }
}
