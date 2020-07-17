package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Seat;
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


}//end AccessSeats class
