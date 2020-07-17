package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieViewingTime implements Parcelable {
    private String movieName;
    private String showTime;
    private String showDate;

    /**
     * Constructor
     * @param movieName is the movie name.
     * @param showTime is the show time of the movie.
     * @param showDate is the show date of the movie.
     */
    public MovieViewingTime(String movieName, String showTime, String showDate) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.showDate = showDate;
    }//end constructor

    //================================================================
    //Parcelable methods
    protected MovieViewingTime(Parcel in) {
        movieName = in.readString();
        showTime = in.readString();
        showDate = in.readString();
    }

    public static final Creator<MovieViewingTime> CREATOR = new Creator<MovieViewingTime>() {
        @Override
        public MovieViewingTime createFromParcel(Parcel in) {
            return new MovieViewingTime(in);
        }

        @Override
        public MovieViewingTime[] newArray(int size) {
            return new MovieViewingTime[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movieName);
        parcel.writeString(showTime);
        parcel.writeString(showDate);
    }

    //================================================================
    //Getter methods
    public String getMovieName() {
        return movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public String getShowDate() {
        return showDate;
    }

}
