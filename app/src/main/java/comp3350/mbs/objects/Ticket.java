package comp3350.mbs.objects;


import java.text.DecimalFormat;

public class Ticket {
    private double price;
    private String movieName;
    DecimalFormat moneyFormat = new DecimalFormat("0.00");

    /**
     * Ticket constructor for implementing Parcelable interface in the ParcelableTicket class.
     */
    public Ticket(){}

    /**
     * Ticket Constructor
     *
     * @param price is the price of one of this type of ticket.
     * @param movieName is the type of the ticket.
     */
    public Ticket(double price, String movieName){
        this.price = price;
        this.movieName = movieName;
    }//end Constructor

    //================================================================
    //Getter methods
    public double getPrice(){
        return price;
    }//end getPrice

    public String getMovieName(){
        return movieName;
    }//end getMovieName

    public String getPriceAsString(){ return moneyFormat.format(price); }


}//end Ticket class