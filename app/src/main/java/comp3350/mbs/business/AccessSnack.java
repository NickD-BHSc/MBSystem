
package comp3350.mbs.business;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Snack;
import comp3350.mbs.persistence.DataAccess;

public class AccessSnack{

    private DataAccess dataAccess;

    /**
     * AccessTickets Constructor - gets the data/service stored in the database Main.dbName.
     */
    public AccessSnack(){
        dataAccess =  Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getTicket - a getter method for the snack when given a movie name.
     * @param movieName is the name of the movie associated with the ticket.
     * @return it will return a Ticket object that has the given movie.
     */
    public Snack getSnack(String movieName) {
        return dataAccess.getSnack(movieName);
    }//end getTicket

}//end AccessTickets

