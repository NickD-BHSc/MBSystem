package comp3350.mbs.presentation;

import android.os.Parcel;
import android.os.Parcelable;
import comp3350.mbs.objects.ViewingTime;

public class ParcelableViewingTime extends ViewingTime implements Parcelable {

    /**
     * Constructor of ParcelableViewingTime
     * @param theatreName is the name of the theatre.
     * @param movieName is the name of the movie.
     * @param showTime is the show time of the movie.
     * @param showDate is the show date of the movie.
     */
    public ParcelableViewingTime(String theatreName, String movieName, String showTime, String showDate) {
        super(theatreName, movieName, showTime, showDate);
    }//end constructor

    protected ParcelableViewingTime(Parcel in) {
        super.setTheatreName(in.readString());
        super.setMovieName(in.readString());
        super.setShowTime(in.readString());
        super.setShowDate(in.readString());
    }

    public static final Creator<ParcelableViewingTime> CREATOR = new Creator<ParcelableViewingTime>() {
        @Override
        public ParcelableViewingTime createFromParcel(Parcel in) {
            return new ParcelableViewingTime(in);
        }

        @Override
        public ParcelableViewingTime[] newArray(int size) {
            return new ParcelableViewingTime[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.getTheatreName());
        parcel.writeString(super.getMovieName());
        parcel.writeString(super.getShowTime());
        parcel.writeString(super.getShowDate());
    }

}