package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessTheatres {
    private DataAccessStub dataAccess;

    //Constructor
    public AccessTheatres() {
        dataAccess = Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getTheatreList -a getter method for the theatreList field.
     * @return it will return the theatreList from the dataBaseStub.
     */
    public List<Theatre> getTheatreList(){
        return dataAccess.getTheatreList();
    }//end getTheatreList


}//end AccessTheatres class
