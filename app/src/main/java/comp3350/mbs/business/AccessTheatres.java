package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.persistence.DataAccess;

public class AccessTheatres {
    private DataAccess dataAccess;

    /**
     * AccessTheatres Constructor - gets the data/service stored in the database Main.dbName.
     */
    public AccessTheatres() {
        dataAccess = Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getTheatreList -a getter method that returns a list of theatres.
     * @return it will return the theatreList from the dataAccess.
     */
    public List<Theatre> getTheatreList(){
        return dataAccess.getTheatreList();
    }//end getTheatreList


}//end AccessTheatres class
