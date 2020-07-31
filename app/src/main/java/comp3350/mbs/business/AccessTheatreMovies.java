package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.persistence.DataAccess;

public class AccessTheatreMovies {

    private DataAccess dataAccess;

    /**
     * AccessTheatreMovies Constructor - gets the data/service stored in the database Main.dbName.
     */
    public AccessTheatreMovies(){
        dataAccess = Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getMoviesFromTheatre - a getter method that returns a list of movies from the given theatre.
     * @param theatreName is the given theatre name.
     * @return it will return a list of movies that is contained in the given theatre.
     */
    public List<TheatreMovies> getMoviesFromTheatre(String theatreName){
       return dataAccess.getMoviesFromTheatre(new TheatreMovies(theatreName,null));
    }//end getMoviesFromTheatre

}//end AccessTheatreMovies class
