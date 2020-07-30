package comp3350.mbs.objects;

//might need to do a superclass for this and ticket.class? very considerable
public class TicketStub {
    private String movieName;
    private String showTime;
    private String theatreLocation;
    private int ticketQuantity;

    //needed an empty constructor when implementing Parcelable interface in the ParcelableTheatreMovies class.
    public TicketStub(){}

    /**
     * Constructor of Ticket class.
     *
     * @param movieName is the type of the ticket.
     * @param showTime is the price of one of this type of ticket.
     */
    public TicketStub(String movieName, String showTime, String theatreLocation, int ticketQuantity) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.theatreLocation = theatreLocation;
        this.ticketQuantity = ticketQuantity;
    }//end Constructor

    /**
     * Constructor of Ticket class.
     *
     * @param price is the price of one of this type of ticket.
     * @param movieName is the type of the ticket.
     * @param quantity is the number of tickets.
     */
    public TicketStub(double price, String movieName, int quantity) {
       // this.price = price;
        this.movieName = movieName;
       // this.quantity = quantity;
    }//end Constructor

    //================================================================
    //Getter methods
    public String getMovieName() {
        return movieName;
    }//end getType

    public int getTicketQuantity() {
        return ticketQuantity;
    }//end getQuantity

    public String getShowTime() { return showTime; }//end getShowTime

    public String getTheatreLocation() { return theatreLocation; }//end getTheatreLocation

    //================================================================
    //Setter methods
    public void setMovieName(String movieName) {
        //where do i put the sql cmds??
        //insert into TICKETSTUB values ("name")
    }

    public void setQuantity(int quantity) {
        //this.quantity = quantity;
    }

}//end Ticket