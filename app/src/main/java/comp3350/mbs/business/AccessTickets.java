package comp3350.mbs.business;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.persistence.DataAccess;

public class AccessTickets {

    private DataAccess dataAccess;

    /**
     * AccessTickets Constructor - gets the data/service stored in the database Main.dbName.
     */
    public AccessTickets(){
        dataAccess =  Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getTicket - a getter method for the ticket when given a movie name.
     * @param movieName is the name of the movie associated with the ticket.
     * @return it will return a Ticket object that has the given movie.
     */
    public Ticket getTicket(String movieName){
        return dataAccess.getTicket(movieName);
    }//end getTicket

}//end AccessTickets
