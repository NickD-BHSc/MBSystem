package comp3350.mbs.objects;

public class Order {

    private String movieName;
    private String showTime;
    private String showDate;
    private String theatreName;
    private int ticketQuantity;

    /**
     * Theatre constructor for implementing Parcelable interface in the ParcelableTheatre class.
     */
    public Order(){}

    /**
     * Constructor of Order class.
     *
     * @param movieName is the type of the ticket.
     * @param showTime is the price of one of this type of ticket.
     */
    public Order(String movieName, String showTime, String showDate, String theatreName, int ticketQuantity) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.showDate = showDate;
        this.theatreName = theatreName;
        this.ticketQuantity = ticketQuantity;
    }//end Constructor


    //Getter methods
    public String getMovieName() {
        return movieName;
    }//end getType

    public int getTicketQuantity() {
        return ticketQuantity;
    }//end getQuantity

    public String getShowTime() { return showTime; }//end getShowTime

    public String getTheatreName() { return theatreName; }//end getTheatreLocation

    public String getShowDate() {
        return showDate;
    }

    //Setter methods
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public void setTicketQuantity(int ticketQuantity) {
        this.ticketQuantity = ticketQuantity;
    }
}
