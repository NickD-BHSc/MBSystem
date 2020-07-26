package comp3350.mbs.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import comp3350.mbs.objects.Seat;

public class ParcelableSeat extends Seat implements Parcelable {

    /**
     * Constructor of ParcelableSeat class.
     * @param seatNumber is the number of the seat.
     * @param isBooked determines if the Seat (ParcelableSeat) object is booked or not.
     * @param seatImage is the image of the seat.
     */
    public ParcelableSeat(int seatNumber, boolean isBooked, int seatImage) {
        super(seatNumber, isBooked, seatImage);
    }//end constructor

    protected ParcelableSeat(Parcel in) {
        super.setSeatNumber(in.readInt());
        super.setBooked(in.readByte() != 0);
        super.setSeatImage(in.readInt());
    }

    public static final Creator<ParcelableSeat> CREATOR = new Creator<ParcelableSeat>() {
        @Override
        public ParcelableSeat createFromParcel(Parcel in) {
            return new ParcelableSeat(in);
        }

        @Override
        public ParcelableSeat[] newArray(int size) {
            return new ParcelableSeat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(super.getSeatNumber());
        parcel.writeByte((byte) (super.isBooked() ? 1 : 0));
        parcel.writeInt(super.getSeatImage());
    }
    
}
