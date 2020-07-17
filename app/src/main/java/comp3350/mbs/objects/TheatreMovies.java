package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class TheatreMovies implements Parcelable {
    private String theatreName;
    private String movieName;
    private int moviePoster;
    private String movieDescription;

    /**
     * Constructor
     * @param theatreName is the given theatre name.
     * @param movieName is the given movie name.
     */
    public TheatreMovies(String theatreName, String movieName) {
        this.theatreName = theatreName;
        this.movieName = movieName;
        this.moviePoster = -1; //null or no poster.
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
    //Parcelable methods
    protected TheatreMovies(Parcel in) {
        theatreName = in.readString();
        movieName = in.readString();
        moviePoster = in.readInt();
        movieDescription = in.readString();
    }

    public static final Creator<TheatreMovies> CREATOR = new Creator<TheatreMovies>() {
        @Override
        public TheatreMovies createFromParcel(Parcel in) {
            return new TheatreMovies(in);
        }

        @Override
        public TheatreMovies[] newArray(int size) {
            return new TheatreMovies[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(theatreName);
        parcel.writeString(movieName);
        parcel.writeInt(moviePoster);
        parcel.writeString(movieDescription);
    }

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
