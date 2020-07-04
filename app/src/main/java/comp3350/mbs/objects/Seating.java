package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Seating implements Parcelable {
    private List<Integer> seats;//true = open, false = booked
    private int bookedCount; //amount of seats booked
    private ArrayList<Integer> bookedSeats; //list of booked seat numbers



    public Seating( List<Integer> l){
        this.seats = l;
        bookedCount = 0;
        bookedSeats = new ArrayList<Integer>();
    }



    //================================================================
    //Parcelable methods
    protected Seating(Parcel in) {

        seats = (List<Integer>) in.readSerializable();
        bookedCount = in.readInt();
        bookedSeats = (ArrayList<Integer>) in.readSerializable();
    }

    public static final Creator<Seating> CREATOR = new Creator<Seating>() {
        @Override
        public Seating createFromParcel(Parcel in) {
            return new Seating(in);
        }

        @Override
        public Seating[] newArray(int size) {
            return new Seating[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable((Serializable) seats);
        parcel.writeInt( bookedCount );
        parcel.writeSerializable((Serializable)bookedSeats);
    }


    //getters
    public List<Integer> getSeats(){ return this.seats; }

    public int getBookedCount(){ return this.bookedCount; }

    public ArrayList<Integer> getBookedSeats(){ return this.bookedSeats;}

    //setters
    public void setSeats( List<Integer> l ){ this.seats = l;}

    public void changeSeat( int pos, Integer seat){ (this.seats).set( pos, seat);}

    public void incrementBooked( int x ){
        this.bookedCount += x;
    }

    public void setBooked( int x ){
        this.bookedCount = x;
    }

    public void addSeat( int x ){
        this.bookedSeats.add( x );
    }

    public void removeSeat( int x ){
        this.bookedSeats.remove( this.bookedSeats.indexOf( (Integer)x ) );
    }

}
