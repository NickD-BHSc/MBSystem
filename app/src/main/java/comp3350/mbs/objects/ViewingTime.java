package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ViewingTime implements Parcelable {
    private String showTime;
    private String showDate;
    private List<Integer> seats;

    /**
     * Constructor of ViewingTime class
     * @param showTime is the showing time of the movie.
     * @param showDate is the date of viewing the movie.
     * @param seats is the list of seats available for the movie.
     */
    public ViewingTime(String showTime, String showDate, List<Integer> seats) {
        this.showTime = showTime;
        this.showDate = showDate;
        this.seats = seats;
    }//end constructor

    protected ViewingTime(Parcel in) {
        showTime = in.readString();
        showDate = in.readString();
    }

    public static final Creator<ViewingTime> CREATOR = new Creator<ViewingTime>() {
        @Override
        public ViewingTime createFromParcel(Parcel in) {
            return new ViewingTime(in);
        }

        @Override
        public ViewingTime[] newArray(int size) {
            return new ViewingTime[size];
        }
    };

    public String getShowTime() {
        return showTime;
    }//end getShowTime

    public String getShowDate() {
        return showDate;
    }//end getShowDate

    public List<Integer> getSeats() {
        return seats;
    }//end getSeats

    @Override
    public String toString() {
        return "ViewingTime{" +
                "showTime='" + showTime + '\'' +
                ", showDate='" + showDate + '\'' +
                ", seats=" + seats +
                '}';
    }//end toString

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(showTime);
        parcel.writeString(showDate);
    }
}//end ViewingTime
