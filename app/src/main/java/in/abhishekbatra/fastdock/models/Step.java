package in.abhishekbatra.fastdock.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Step {

    @SerializedName("distance")
    @Expose
    private Distance distance;
    @SerializedName("duration")
    @Expose
    private Duration duration;
    @SerializedName("end_location")
    @Expose
    private EndLocation endLocation;
    @SerializedName("html_instructions")
    @Expose
    private String htmlInstructions;
    @SerializedName("maneuver")
    @Expose
    private String maneuver;
    @SerializedName("polyline")
    @Expose
    private Polyline polyline;
    @SerializedName("start_location")
    @Expose
    private StartLocation startLocation;
    @SerializedName("travel_mode")
    @Expose
    private String travelMode;

    /**
     * No args constructor for use in serialization
     */
    public Step() {
    }

    /**
     * @param duration
     * @param distance
     * @param polyline
     * @param endLocation
     * @param htmlInstructions
     * @param startLocation
     * @param maneuver
     * @param travelMode
     */
    public Step(Distance distance, Duration duration, EndLocation endLocation, String htmlInstructions, String maneuver, Polyline polyline, StartLocation startLocation, String travelMode) {
        this.distance = distance;
        this.duration = duration;
        this.endLocation = endLocation;
        this.htmlInstructions = htmlInstructions;
        this.maneuver = maneuver;
        this.polyline = polyline;
        this.startLocation = startLocation;
        this.travelMode = travelMode;
    }

    /**
     * @return The distance
     */
    public Distance getDistance() {
        return distance;
    }

    /**
     * @param distance The distance
     */
    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    /**
     * @return The duration
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * @param duration The duration
     */
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    /**
     * @return The endLocation
     */
    public EndLocation getEndLocation() {
        return endLocation;
    }

    /**
     * @param endLocation The end_location
     */
    public void setEndLocation(EndLocation endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * @return The htmlInstructions
     */
    public String getHtmlInstructions() {
        return htmlInstructions;
    }

    /**
     * @param htmlInstructions The html_instructions
     */
    public void setHtmlInstructions(String htmlInstructions) {
        this.htmlInstructions = htmlInstructions;
    }

    /**
     * @return The maneuver
     */
    public String getManeuver() {
        return maneuver;
    }

    /**
     * @param maneuver The maneuver
     */
    public void setManeuver(String maneuver) {
        this.maneuver = maneuver;
    }

    /**
     * @return The polyline
     */
    public Polyline getPolyline() {
        return polyline;
    }

    /**
     * @param polyline The polyline
     */
    public void setPolyline(Polyline polyline) {
        this.polyline = polyline;
    }

    /**
     * @return The startLocation
     */
    public StartLocation getStartLocation() {
        return startLocation;
    }

    /**
     * @param startLocation The start_location
     */
    public void setStartLocation(StartLocation startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * @return The travelMode
     */
    public String getTravelMode() {
        return travelMode;
    }

    /**
     * @param travelMode The travel_mode
     */
    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

}
