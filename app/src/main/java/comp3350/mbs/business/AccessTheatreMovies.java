package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.persistence.DataAccess;

public class AccessTheatreMovies {
    private DataAccess dataAccess;


    public AccessTheatreMovies() {
        dataAccess = Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getMoviesFromTheatre - a getter method that returns a list of movies from the given theatre.
     * @param whichTheatre is the given theatre name.
     * @return it will return a list of movies that is contained in the given theatre.
     */
    public List<TheatreMovies> getMoviesFromTheatre(String whichTheatre){
       return dataAccess.getMoviesFromTheatre(new TheatreMovies(whichTheatre,null));
    }//end getMoviesFromTheatre

    /**
     * getTheatresFromMovie - a getter method that returns a list of theatres from the given movie.
     * @param whichMovie is the given movie name.
     * @return it will return a list of theatres that has the given movie.
     */
    public List<TheatreMovies> getTheatresFromMovie(String whichMovie){
        return dataAccess.getTheatresFromMovie(new TheatreMovies(null,whichMovie));
    }//end getTheatresFromMovie

}//end AccessTheatreMovies
