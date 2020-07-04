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
     *
     * @param showTime is the showing time of the movie.
     * @param showDate is the date of viewing the movie.
     * @param seats    is the list of seats available for the movie.
     */
    public ViewingTime(String showTime, String showDate, List<Integer> seats) {
        this.showTime = showTime;
        this.showDate = showDate;
        this.seats = seats;
    }//end constructor


    //================================================================
    //Parcelable methods
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(showTime);
        parcel.writeString(showDate);
    }

    //================================================================
    //Getter methods
    public String getShowTime() {
        return showTime;
    }//end getShowTime

    public String getShowDate() {
        return showDate;
    }//end getShowDate

    public List<Integer> getSeats() {
        return seats;
    }//end getSeats


    /**
     * equals - a method that determines if the given object (ViewingTime) has the same time and date as the fields showTime and showData.
     * @param object is the object that will be compared to the instance's showTime and showDate.
     * @return it will return true if the given object's time and date are the same as the instance's showTime and showData.
     *          Otherwise, it will return false.
     */
    public boolean equals(Object object){

        boolean result = false;

        if(object instanceof ViewingTime){
            ViewingTime vwItem = (ViewingTime)object;

            if(((vwItem.getShowTime() == null) && (showTime == null))
                && ((vwItem.getShowDate() == null) && (showDate == null))
                || ((vwItem.getShowDate().equals(showDate)) && (vwItem.getShowTime().equals(showTime)))){
                result = true;
            }//end nested if

        }//end if


        return result;
    }//end equals

    /**
     * toString - a method that represents the Viewing Time information in text.
     * @return it will return an information about the Viewing Time (fields).
     */
    @Override
    public String toString() {
        return "ViewingTime{" +
                "showTime='" + showTime + '\'' +
                ", showDate='" + showDate + '\'' +
                ", seats=" + seats +
                '}';
    }//end toString

}//end ViewingTime
