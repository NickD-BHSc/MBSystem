package comp3350.mbs.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.persistence.DataAccess;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessSeats {
    private DataAccess dataAccess;

    public AccessSeats(){
        dataAccess = Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getSeatList -a getter method for the seatList field from the DataAccessStub.
     * @return it will return a list of seats.
     */
    public List<Seat> getSeatList(){
        return dataAccess.getSeatList();
    }//end getSeatList


    /**
     * updateSeatList - a method to update the seatlist's of viewing time objects in the database
     * @param v - ViewingTime to update
     * @param s - Seat string to change
     */
    public void updateSeatList(ViewingTime v, String s){
        dataAccess.updateSeatList( v, s );
    }



}//end AccessSeats class
