package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.persistence.DataAccess;

public class AccessViewingTimes {

    private DataAccess dataAccess;

    /**
     * AccessViewingTimes Constructor - gets the data/service stored in the database Main.dbName.
     */
    public AccessViewingTimes(){
        dataAccess = Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getViewingTimeList - a getter method that returns a list of viewing time for the given movie
     *          assuming that the user has chosen the theatre already.
     * @param theatreName is thea theatre that the user has chosen.
     * @param movieName is the movie that contains the list of viewing times.
     * @return it will return the viewingTimeList for the given movie if it exists.
     *          Otherwise it will return null.
     */
    public List<ViewingTime> getViewingTimeList(String theatreName,String movieName){
        TheatreMovies theatreMovie = new TheatreMovies(theatreName,movieName);
        return dataAccess.getViewingTimeList(theatreMovie);
    }//end getViewingTimeList

}//end AccessViewingTimes
