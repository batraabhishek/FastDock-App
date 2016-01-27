package in.abhishekbatra.fastdock.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Bounds {

    @SerializedName("northeast")
    @Expose
    private Northeast northeast;
    @SerializedName("southwest")
    @Expose
    private Southwest southwest;

    /**
     * No args constructor for use in serialization
     */
    public Bounds() {
    }

    /**
     * @param southwest
     * @param northeast
     */
    public Bounds(Northeast northeast, Southwest southwest) {
        this.northeast = northeast;
        this.southwest = southwest;
    }

    /**
     * @return The northeast
     */
    public Northeast getNortheast() {
        return northeast;
    }

    /**
     * @param northeast The northeast
     */
    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    /**
     * @return The southwest
     */
    public Southwest getSouthwest() {
        return southwest;
    }

    /**
     * @param southwest The southwest
     */
    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

}
