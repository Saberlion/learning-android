package info.saberlion.zhihudaily.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arthur on 2015/11/1.
 */
public class DailyList {
    @SerializedName("date")
    public String date;
    @SerializedName("stories")
    public java.util.List<ListItem> stories;
}
