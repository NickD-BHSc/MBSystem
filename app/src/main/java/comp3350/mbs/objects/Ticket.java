package comp3350.mbs.objects;


import java.text.DecimalFormat;

public class Ticket {
    private double price;
    private String type;
    private int quantity;
    DecimalFormat moneyFormat = new DecimalFormat("0.00");

    //needed an empty constructor when implementing Parcelable interface in the ParcelableTheatreMovies class.
    public Ticket(){}

    /**
     * Constructor of Ticket class.
     *
     * @param price is the price of one of this type of ticket.
     * @param type is the type of the ticket.
     */
    public Ticket(double price, String type) {
        this.price = price;
        this.type = type;
        this.quantity = 1;
    }//end Constructor

    /**
     * Constructor of Ticket class.
     *
     * @param price is the price of one of this type of ticket.
     * @param type is the type of the ticket.
     * @param quantity is the number of tickets.
     */
    public Ticket(double price, String type, int quantity) {
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }//end Constructor

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

    //================================================================
    //Setter methods
    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}//end Ticket