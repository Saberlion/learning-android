package info.saberlion.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shirley on 15/10/20.
 */
public class V2exMemberModel implements Parcelable {
    public String iid;
    public String username;
    public String tagline;
    public String avatar_mini;
    public String avatar_normal;
    public String avatar_large;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.iid);
        dest.writeString(this.username);
        dest.writeString(this.tagline);
        dest.writeString(this.avatar_mini);
        dest.writeString(this.avatar_normal);
        dest.writeString(this.avatar_large);
    }

    public V2exMemberModel() {
    }

    protected V2exMemberModel(Parcel in) {
        this.iid = in.readString();
        this.username = in.readString();
        this.tagline = in.readString();
        this.avatar_mini = in.readString();
        this.avatar_normal = in.readString();
        this.avatar_large = in.readString();
    }

    public static final Parcelable.Creator<V2exMemberModel> CREATOR = new Parcelable.Creator<V2exMemberModel>() {
        public V2exMemberModel createFromParcel(Parcel source) {
            return new V2exMemberModel(source);
        }

        public V2exMemberModel[] newArray(int size) {
            return new V2exMemberModel[size];
        }
    };
}
