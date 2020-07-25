package comp3350.mbs.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import comp3350.mbs.objects.TheatreMovies;

public class ParcelableTheatreMovies extends TheatreMovies implements Parcelable {

    public ParcelableTheatreMovies(String theatreName, String movieName) {
        super(theatreName, movieName);
    }

    public ParcelableTheatreMovies(String theatreName, String movieName, int moviePoster, String movieDescription) {
        super(theatreName, movieName, moviePoster, movieDescription);
    }

    protected ParcelableTheatreMovies(Parcel in) {
        super.setTheatreName(in.readString());
        super.setMovieName(in.readString());
        super.setMoviePoster(in.readInt());
        super.setMovieDescription(in.readString());
    }

    public static final Creator<ParcelableTheatreMovies> CREATOR = new Creator<ParcelableTheatreMovies>() {
        @Override
        public ParcelableTheatreMovies createFromParcel(Parcel in) {
            return new ParcelableTheatreMovies(in);
        }

        @Override
        public ParcelableTheatreMovies[] newArray(int size) {
            return new ParcelableTheatreMovies[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.getTheatreName());
        parcel.writeString(super.getMovieName());
        parcel.writeInt(super.getMoviePoster());
        parcel.writeString(super.getMovieDescription());
    }
}
