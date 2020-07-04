package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Hashtable;
import java.util.List;


public class Trailer implements Parcelable{
    private String movieTitle;
    private Hashtable videos;

    protected Trailer(Parcel in) {
        movieTitle = in.readString();
    }

    public static final Creator<Trailer> CREATOR = new Creator<Trailer>() {
        @Override
        public Trailer createFromParcel(Parcel in) {
            return new Trailer(in);
        }

        @Override
        public Trailer[] newArray(int size) {
            return new Trailer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movieTitle);
    }
}
