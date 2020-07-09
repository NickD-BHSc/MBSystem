package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Movie implements Parcelable {

    private String title;
    private int poster;
    private String description;
    private List<ViewingTime> showingTime;

    /**
     * Constructor of Movie class
     *
     * @param title       is the name of the movie.
     * @param poster      is the picture of the movie.
     * @param description is the description of the movie.
     * @param showingTime is the list of showing time of the movie.
     */
    public Movie(String title, int poster, String description, List<ViewingTime> showingTime) {
        this.title = title;
        this.poster = poster;
        this.description = description;
        this.showingTime = showingTime;
    }//end constructor

    //================================================================
    //Parcelable methods
    protected Movie(Parcel in) {
        title = in.readString();
        poster = in.readInt();
        description = in.readString();
        //make sure that ViewingTime class also implements Parcelable!
        showingTime = in.createTypedArrayList(ViewingTime.CREATOR);
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeInt(poster);
        parcel.writeString(description);
        parcel.writeTypedList(showingTime);
    }

    //================================================================
    //Getter methods
    public String getTitle() {
        return title;
    }//end getTitle

    public int getPoster() {
        return poster;
    }//end getPoster

    public String getDescription() {
        return description;
    }//end getDescription

    public List<ViewingTime> getShowingTime() {
        return showingTime;
    }//end getShowingTime


    /**
     * equals - a method that determines if the given object (Movie) has the same title name as the instance title.
     * @param object is the object that will be compared to the instance's title.
     * @return it will return true if the given object's title is the same as the instance's title.
     *          Otherwise, it will return false.
     */
    public boolean equals(Object object){
        boolean result = false;

        if(object instanceof Movie){
            Movie movieItem = (Movie)object;//cast the object to Movie

            if(((movieItem.getTitle() == null) && (title == null))
                    || (movieItem.getTitle().equals(title))){
                result = true;
            }//end nested if

        }//end if

        return result;

    }//end equals

    /**
     * toString - a method that represents the Movie information in text.
     * @return it will return an information about the Movie (fields).
     */
    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", poster=" + poster +
                ", description='" + description + '\'' +
                ", showingTime=" + showingTime +
                '}';
    }//end toString


}//end Movie class
