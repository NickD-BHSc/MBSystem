package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Theatre implements Parcelable {
    private String name;
    private String address;
    private List<Movie> movieList;
    private String distance;

    /**
     * Constructor of Theatre class.
     *
     * @param name      is the name of the theatre.
     * @param address   is the address of the theatre.
     * @param movieList is the list of movies available in the theatre.
     * @param distance  is the distance between the user's location.
     */
    public Theatre(String name, String address, List<Movie> movieList, String distance) {
        this.name = name;
        this.address = address;
        this.movieList = movieList;
        this.distance = distance;
    }//end Constructor

    //================================================================
    //Parcelable methods
    protected Theatre(Parcel in) {
        name = in.readString();
        address = in.readString();
        movieList = in.createTypedArrayList(Movie.CREATOR);
        distance = in.readString();
    }

    public static final Creator<Theatre> CREATOR = new Creator<Theatre>() {
        @Override
        public Theatre createFromParcel(Parcel in) {
            return new Theatre(in);
        }

        @Override
        public Theatre[] newArray(int size) {
            return new Theatre[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeTypedList(movieList);
        parcel.writeString(distance);
    }

    //================================================================
    //Getter methods
    public String getName() {
        return name;
    }//end getName

    public String getAddress() {
        return address;
    }//end getAddress

    public List<Movie> getMovieList() {
        return movieList;
    }//end getMovieList

    public String getDistance() {
        return distance;
    }//end getDistance

}//end Theatre
