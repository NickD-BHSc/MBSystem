package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieViewingTime implements Parcelable {
    private String theatreName;
    private String movieName;
    private String showTime;
    private String showDate;

    /**
     * Constructor
     * @param theatreName is the name of the theatre.
     * @param movieName is the movie name.
     * @param showTime is the show time of the movie.
     * @param showDate is the show date of the movie.
     */
    public MovieViewingTime(String theatreName,String movieName, String showTime, String showDate) {
        this.theatreName = theatreName;
        this.movieName = movieName;
        this.showTime = showTime;
        this.showDate = showDate;
    }//end constructor

    //================================================================
    //Parcelable methods
    protected MovieViewingTime(Parcel in) {
        theatreName = in.readString();
        movieName = in.readString();
        showTime = in.readString();
        showDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(theatreName);
        dest.writeString(movieName);
        dest.writeString(showTime);
        dest.writeString(showDate);
    }

    @Override
    public int describeContents() {
        return 0;
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
