package comp3350.mbs.presentation;

import android.os.Parcel;
import android.os.Parcelable;
import comp3350.mbs.objects.ViewingTime;

public class ParcelableViewingTime extends ViewingTime implements Parcelable {

    /**
     * ParcelableViewingTime Constructor
     * @param theatreName is the name of the theatre.
     * @param movieName is the name of the movie.
     * @param showTime is the show time of the movie.
     * @param showDate is the show date of the movie.
     * @param seatList is the list of seats for the movie.
     */
    public ParcelableViewingTime(String theatreName, String movieName, String showTime, String showDate, String seatList){
        super(theatreName, movieName, showTime, showDate, seatList);
    }//end Constructor

    protected ParcelableViewingTime(Parcel in){
        super.setTheatreName(in.readString());
        super.setMovieName(in.readString());
        super.setShowTime(in.readString());
        super.setShowDate(in.readString());
        super.setSeatString( in.readString());
    }//end Constructor

    public static final Creator<ParcelableViewingTime> CREATOR = new Creator<ParcelableViewingTime>(){
        @Override
        public ParcelableViewingTime createFromParcel(Parcel in){
            return new ParcelableViewingTime(in);
        }//end createFromParcel

        @Override
        public ParcelableViewingTime[] newArray(int size){
            return new ParcelableViewingTime[size];
        }//end newArray
    };//end Creator

    @Override
    public int describeContents(){
        return 0;
    }//end describeContents

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.getTheatreName());
        parcel.writeString(super.getMovieName());
        parcel.writeString(super.getShowTime());
        parcel.writeString(super.getShowDate());
        parcel.writeString(super.getSeatString());
    }//end writeToParcel

}//end ParcelableViewingTime class
