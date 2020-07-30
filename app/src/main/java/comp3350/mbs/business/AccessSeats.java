package comp3350.mbs.business;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.persistence.DataAccess;

public class AccessSeats {

    private DataAccess dataAccess;

    /**
     * AccessSeats Constructor - gets the data/service stored in the database Main.dbName.
     */
    public AccessSeats(){
        dataAccess = Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * updateSeatList - a method to update the seatlist's of viewing time objects in the database
     * @param viewingTime - ViewingTime to update
     * @param seatString - Seat string to change
     */
    public String updateSeatList(ViewingTime viewingTime, String seatString){
        return dataAccess.updateSeatList(viewingTime, seatString);
    }//end updateSeatList

}//end AccessSeats class
