package comp3350.mbs.objects;

public class TheatreMovies {
    private String theatreName;
    private String movieName;
    private int moviePoster;
    private String movieDescription;

    /**
     * TheatreMovies constructor for implementing Parcelable interface in the ParcelableTheatreMovies class.
     */
    public TheatreMovies(){}

    /**
     * TheatreMovies Constructor - This is mainly used when we only need the theatre name and not the movie information.
     * There is no movie poster and no description needed.
     * @param theatreName is the given theatre name.
     * @param movieName is the given movie name.
     */
    public TheatreMovies(String theatreName, String movieName) {
        this.theatreName = theatreName;
        this.movieName = movieName;
        this.moviePoster = -1;
        this.movieDescription = null;
    }//end TheatreMovies constructor

    /**
     * TheatreMovies Constructor
     *
     * @param theatreName is the given theatre name.
     * @param movieName is the given movie name.
     * @param moviePoster is the picture/poster of the movie.
     * @param movieDescription is the description of the movie.
     */
    public TheatreMovies(String theatreName, String movieName, int moviePoster, String movieDescription) {
        this.theatreName = theatreName;
        this.movieName = movieName;
        this.moviePoster = moviePoster;
        this.movieDescription = movieDescription;
    }//end TheatreMovies constructor

    //================================================================
    //Getter methods
    public String getTheatreName(){
        return theatreName;
    }

    public String getMovieName(){
        return movieName;
    }

    public int getMoviePoster(){
        return moviePoster;
    }

    public String getMovieDescription(){
        return movieDescription;
    }


    /**
     * equals - a method that determines if the given object is equal to this object.
     * @param object is the object that will be compared.
     * @return it will return true if the given object has the same theatre or movie name.
     *          Otherwise it will return false.
     */
    public boolean equals(Object object){
        boolean result = false;

        if(object instanceof TheatreMovies){
            TheatreMovies theatreMovie = (TheatreMovies)object;

            if((((theatreMovie.theatreName == null) && (theatreName == null)) || ((theatreMovie.theatreName != null) && (theatreMovie.theatreName.equals(theatreName))))
                && (((theatreMovie.movieName == null) && (movieName == null)) || ((theatreMovie.movieName != null) && (theatreMovie.movieName.equals(movieName))))){
                result = true;
            }

        }
        return result;

    }//end equals

}//end TheatreMovies class
