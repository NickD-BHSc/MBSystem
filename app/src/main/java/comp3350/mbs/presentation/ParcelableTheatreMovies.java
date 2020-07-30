package comp3350.mbs.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import comp3350.mbs.objects.TheatreMovies;

public class ParcelableTheatreMovies extends TheatreMovies implements Parcelable {

    /**
     * ParcelableTheatreMovies Constructor
     * @param theatreName is the name of the theatre.
     * @param movieName is the name of the movie.
     * @param moviePoster is the poster of the movie.
     * @param movieDescription is the description of the movie.
     */
    public ParcelableTheatreMovies(String theatreName, String movieName, int moviePoster, String movieDescription){
        super(theatreName, movieName, moviePoster, movieDescription);
    }//end Constructor

    protected ParcelableTheatreMovies(Parcel in){
        super.setTheatreName(in.readString());
        super.setMovieName(in.readString());
        super.setMoviePoster(in.readInt());
        super.setMovieDescription(in.readString());
    }//end Constructor

    public static final Creator<ParcelableTheatreMovies> CREATOR = new Creator<ParcelableTheatreMovies>(){
        @Override
        public ParcelableTheatreMovies createFromParcel(Parcel in){
            return new ParcelableTheatreMovies(in);
        }//end createFromParcel

        @Override
        public ParcelableTheatreMovies[] newArray(int size){
            return new ParcelableTheatreMovies[size];
        }//end newArray
    };//end Creator

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.getTheatreName());
        parcel.writeString(super.getMovieName());
        parcel.writeInt(super.getMoviePoster());
        parcel.writeString(super.getMovieDescription());
    }

}//end ParcelableTheatreMovies
