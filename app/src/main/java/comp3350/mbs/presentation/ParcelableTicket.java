package comp3350.mbs.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import comp3350.mbs.objects.Ticket;

public class ParcelableTicket extends Ticket implements Parcelable {

    /**
     * Constructor of ParcelableTicket
     * @param price is the price of the ticket.
     * @param type is the type of the ticket.
     * @param quantity is the quantity of the ticket.
     */
    public ParcelableTicket(double price, String type, int quantity) {
        super(price, type, quantity);
    }//end constructor

    protected ParcelableTicket(Parcel in) {
        super.setPrice(in.readDouble());
        super.setMovieName(in.readString());
        super.setQuantity(in.readInt());
    }

    public static final Creator<ParcelableTicket> CREATOR = new Creator<ParcelableTicket>() {
        @Override
        public ParcelableTicket createFromParcel(Parcel in) {
            return new ParcelableTicket(in);
        }

        @Override
        public ParcelableTicket[] newArray(int size) {
            return new ParcelableTicket[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(super.getPrice());
        parcel.writeString(super.getMovieName());
        parcel.writeInt(super.getQuantity());
    }

}
