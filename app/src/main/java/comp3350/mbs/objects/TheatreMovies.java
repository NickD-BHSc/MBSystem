package comp3350.mbs.objects;

public class TheatreMovies {
    private String theatreName;
    private String movieName;
    private int moviePoster;
    private String movieDescription;

    //needed an empty constructor when implementing Parcelable interface in the ParcelableTheatreMovies class.
    public TheatreMovies(){}

    /**
     * Constructor
     * @param theatreName is the given theatre name.
     * @param movieName is the given movie name.
     */
    public TheatreMovies(String theatreName, String movieName) {
        this.theatreName = theatreName;
        this.movieName = movieName;
        this.moviePoster = -1; //represents null or no poster.
        this.movieDescription = "";//no movie description.
    }//end TheatreMovies constructor

    /**
     * Constructor
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
    public String getTheatreName() {
        return theatreName;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getMoviePoster() {
        return moviePoster;
    }

    public String getMovieDescription() {
        return movieDescription;
    }


    //================================================================
    //Setter methods
    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }//end setTheatreName

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }//end setMovieName

    public void setMoviePoster(int moviePoster) {
        this.moviePoster = moviePoster;
    }//end setMoviePoster

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }//end setMovieDescription

    /**
     * equals - a method that determines if the given object is equal to this object.
     * @param object is the object that will be compared.
     * @return it will return true if the given object has the same theatre or movie name.
     *          Otherwise it will return false.
     */
    public boolean equals(Object object){
        boolean result = false;

        if(object instanceof TheatreMovies){
            TheatreMovies tm = (TheatreMovies)object;

            if((((tm.theatreName == null) && (theatreName == null)) || ((tm.theatreName != null) && (tm.theatreName.equals(theatreName))))
                && (((tm.movieName == null) && (movieName == null)) || ((tm.movieName != null) && (tm.movieName.equals(movieName))))){
                result = true;
            }//end nested if

        }//end if
        return result;

    }//end equals

}//end TheatreMovies class
