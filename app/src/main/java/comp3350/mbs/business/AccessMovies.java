package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessMovies {
    private DataAccessStub dataAccess;
    private List<Movie> movieList;
    //Constructor
    public AccessMovies(){
        dataAccess = Services.getDataAccessService(Main.dbName);
        movieList = null;
    }//end constructor

    /**
     * getMovieList - a getter method for the movieList for the given theatre.
     * @param whichTheatre is the theatre that contains the list of movies.
     * @return it will return the movieList for the given theatre if it exists.
     *          Otherwise it will return null.
     */
    public List<Movie> getMovieList(Theatre whichTheatre){
        movieList = dataAccess.getMovieList(whichTheatre);
        return movieList;
    }//end getMovieList


}//end AccessMovies
