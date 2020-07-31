package comp3350.mbs.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import comp3350.mbs.objects.Order;

public class ParcelableOrder extends Order implements Parcelable{


    public ParcelableOrder(String movieName, String showTime, String showDate, String theatreName, int ticketQuantity){
        super(movieName, showTime, showDate, theatreName, ticketQuantity);
    }//end Constructor

    protected ParcelableOrder(Parcel in){
        super.setMovieName(in.readString());
        super.setShowTime(in.readString());
        super.setShowDate(in.readString());
        super.setTheatreName(in.readString());
        super.setTicketQuantity(in.readInt());
    }//end Constructor

    public static final Parcelable.Creator<ParcelableOrder> CREATOR = new Parcelable.Creator<ParcelableOrder>(){
        @Override
        public ParcelableOrder createFromParcel(Parcel in){
            return new ParcelableOrder(in);
        }//end createFromParcel

        @Override
        public ParcelableOrder[] newArray(int size){
            return new ParcelableOrder[size];
        }//end newArray
    };//end Creator

    @Override
    public int describeContents(){
        return 0;
    }//end describeContents

    @Override
    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(super.getMovieName());
        parcel.writeString(super.getShowTime());
        parcel.writeString(super.getShowDate());
        parcel.writeString(super.getTheatreName());
        parcel.writeInt(super.getTicketQuantity());

    }//end writeToParcel
}//end ParcelableOrder
