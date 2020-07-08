package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Seat implements Parcelable {
    private int seatNumber;
    private boolean isBooked;
    private int seatImage;

    public Seat(int seatNumber,boolean isBooked, int seatImage) {
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
        this.seatImage = seatImage;
    }//end Seat


    protected Seat(Parcel in) {
        seatNumber = in.readInt();
        isBooked = in.readByte() != 0;
        seatImage = in.readInt();
    }

    public static final Creator<Seat> CREATOR = new Creator<Seat>() {
        @Override
        public Seat createFromParcel(Parcel in) {
            return new Seat(in);
        }

        @Override
        public Seat[] newArray(int size) {
            return new Seat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(seatNumber);
        parcel.writeByte((byte) (isBooked ? 1 : 0));
        parcel.writeInt(seatImage);
    }

    //================================================================
    //Getter methods
    public int getSeatNumber() {
        return seatNumber;
    }//end getSeatNumber

    public boolean isBooked() {
        return isBooked;
    }//end isBooked


    public int getSeatImage() {
        return seatImage;
    }//end getSeatImage


    //================================================================
    //Setter methods
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }//end setSeatNumber

    public void setBooked(boolean booked) {
        isBooked = booked;
    }//end setBooked

    public void setSeatImage(int seatImage) {
        this.seatImage = seatImage;
    }//end setSeatImage

    /**
     * equals - a method that determines if the seat is equal to the given seat by checking its seat number.
     * @param object is the seat that will be compared to.
     * @return it will return true if the given seat object has the same seat number as the field seatNumber.
     *          Otherwise, it will return false.
     */
    public boolean equals(Seat object){
        return seatNumber == object.getSeatNumber();
    }//end equals


}//end Seat class
