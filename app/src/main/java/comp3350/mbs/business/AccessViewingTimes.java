package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.persistence.DataAccess;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessViewingTimes {
    private DataAccess dataAccess;
    //Constructor
    public AccessViewingTimes(){
        dataAccess = Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getViewingTimeList - a getter method for the viewingTimeList for the given movie
     *          assuming that the user has chosen the theatre already.
     * @param whichTheatre is thea theatre that the user has chosen.
     * @param whichMovie is the movie that contains the list of viewing time.
     * @return it will return the viewingTimeList for the given movie if it exists.
     *          Otherwise it will return null.
     */
    public List<ViewingTime> getViewingTimeList(Theatre whichTheatre, Movie whichMovie){
       // return dataAccess.getViewingTimeList(whichTheatre,whichMovie);
        return null;
    }//end getViewingTimeList

}//end AccessViewingTimes
