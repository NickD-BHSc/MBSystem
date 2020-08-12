package comp3350.mbs.objects;

public class Order {

    private String movieName;
    private String showTime;
    private String showDate;
    private String theatreName;
    private int ticketQuantity;

    /**
     * Constructor of Order class.
     *
     * @param movieName is the type of the ticket.
     * @param showTime is the price of one of this type of ticket.
     */
    public Order(String movieName, String showTime, String showDate, String theatreName, int ticketQuantity){
        this.movieName = movieName;
        this.showTime = showTime;
        this.showDate = showDate;
        this.theatreName = theatreName;
        this.ticketQuantity = ticketQuantity;
    }//end Constructor


    //Getter methods
    public String getMovieName(){
        return movieName;
    }//end getType

    public int getTicketQuantity(){
        return ticketQuantity;
    }//end getQuantity

    public String getShowTime(){
        return showTime;
    }//end getShowTime

    public String getTheatreName(){
        return theatreName;
    }//end getTheatreLocation

    public String getShowDate(){
        return showDate;
    }

}//end Order
