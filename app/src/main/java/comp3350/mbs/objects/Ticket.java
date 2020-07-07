package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DecimalFormat;

public class Ticket implements Parcelable {
    private double price;
    private String type;
    private int quantity = 1;
    DecimalFormat moneyFormat = new DecimalFormat("0.00");

    /**
     * Constructor of Ticket class.
     *
     * @param price      is the price of one of this type of ticket.
     * @param type   is the type of the ticket.
     */
    public Ticket(double price, String type) {
        this.price = price;
        this.type = type;
    }//end Constructor

    /**
     * Constructor of Ticket class.
     *
     * @param price      is the price of one of this type of ticket.
     * @param type      is the type of the ticket.
     * @param quantity  is the number of tickets.
     */
    public Ticket(double price, String type, int quantity) {
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }//end Constructor

    //================================================================
    //Parcelable methods
    protected Ticket(Parcel in) {
        price = in.readDouble();
        type = in.readString();
        quantity = in.readInt();
    }

    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel in) {
            return new Ticket(in);
        }

        @Override
        public Ticket[] newArray(int size) { return new Ticket[size]; }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(price);
        parcel.writeString(type);
        parcel.writeInt(quantity);
    }

    //================================================================
    //Getter methods
    public double getPrice() {
        return price;
    }//end getPrice

    public String getType() {
        return type;
    }//end getType

    public int getQuantity() {
        return quantity;
    }//end getQuantity

    public String getPriceAsString(){ return moneyFormat.format(price); }


}//end Ticket