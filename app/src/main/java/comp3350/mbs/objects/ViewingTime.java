package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class ViewingTime implements Parcelable {
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
    public ViewingTime(String theatreName, String movieName, String showTime, String showDate) {
        this.theatreName = theatreName;
        this.movieName = movieName;
        this.showTime = showTime;
        this.showDate = showDate;
    }//end constructor

    //================================================================
    //Parcelable methods
    protected ViewingTime(Parcel in) {
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


    //================================================================
    //Getter methods
    public String getTheatreName() {
        return theatreName;
    }
    public String getMovieName() {
        return movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public String getShowDate() {
        return showDate;
    }


    /**
     * equals - a method that checks if the given object and this object are the same.
     * @param object is the object that will be compared to this object.
     * @return it will return true if all the fields are equal.
     *          Otherwise, it will return false.
     */
    public boolean equals(Object object){
        boolean result = false;

        if(object instanceof ViewingTime){
            ViewingTime vt = (ViewingTime)object;//casting the given object.

            if(((vt.theatreName == null && theatreName == null) || (vt.theatreName.equals(theatreName)))
                && ((vt.movieName == null) || (vt.movieName.equals(movieName)))
                && ((vt.showTime == null) || (vt.showTime.equals(showTime)))
                && ((vt.showDate == null) || (vt.showDate.equals(showDate)))){
                result =true;
            }//end nested if


        }//end if

        return result;

    }//end equals

}//end ViewingTime
