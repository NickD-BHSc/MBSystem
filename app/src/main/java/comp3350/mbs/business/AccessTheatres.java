package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessTheatres {
    private DataAccessStub dataAccess;
    private List<Theatre> theatreList;

    //Constructor
    public AccessTheatres() {
        dataAccess = Services.getDataAccessService(Main.dbName);
        theatreList = null;
    }//end constructor

    /**
     * getTheatreList -a getter method for the theatreList field.
     * @return it will return the field theatreList.
     */
    public List<Theatre> getTheatreList(){
        theatreList = dataAccess.getTheatreList();
        return  theatreList;
    }//end getTheatreList


}//end AccessTheatres class
