package comp3350.mbs.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import comp3350.mbs.objects.Ticket;

public class ParcelableTicket extends Ticket implements Parcelable {

    /**
     * ParcelableTicket Constructor
     * @param price is the price of the ticket.
     * @param movieName is the type of the ticket.
     */
    public ParcelableTicket(double price, String movieName){
        super(price, movieName);
    }//end Constructor

    protected ParcelableTicket(Parcel in){
        super.setPrice(in.readDouble());
        super.setMovieName(in.readString());
    }//end Constructor

    public static final Creator<ParcelableTicket> CREATOR = new Creator<ParcelableTicket>(){
        @Override
        public ParcelableTicket createFromParcel(Parcel in){
            return new ParcelableTicket(in);
        }//end createFromParcel

        @Override
        public ParcelableTicket[] newArray(int size){
            return new ParcelableTicket[size];
        }//end newArray
    };//end Creator

    @Override
    public int describeContents(){
        return 0;
    }//end describeContents

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeDouble(super.getPrice());
        parcel.writeString(super.getMovieName());
    }//end writeToParcel

}
