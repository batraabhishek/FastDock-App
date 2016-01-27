package in.abhishekbatra.fastdock.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Duration {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("value")
    @Expose
    private int value;

    /**
     * No args constructor for use in serialization
     */
    public Duration() {
    }

    /**
     * @param text
     * @param value
     */
    public Duration(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return The value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    public void setValue(int value) {
        this.value = value;
    }

}
