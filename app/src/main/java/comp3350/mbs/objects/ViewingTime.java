package comp3350.mbs.objects;

public class ViewingTime{
    private String theatreName;
    private String movieName;
    private String showTime;
    private String showDate;

    //needed an empty constructor when implementing Parcelable interface in the ParcelableViewingTime class.
    public ViewingTime(){}

    /**
     * Constructor
     * @param theatreName is the name of the theatre.
     * @param movieName is the movie name.
     * @param showTime is the show time of the movie.
     * @param showDate is the show date of the movie.
     */
    public ViewingTime(String theatreName, String movieName, String showTime, String showDate) {
        this.theatreName = theatreName;
        this.movieName = movieName;
        this.showTime = showTime;
        this.showDate = showDate;
    }//end constructor


    //================================================================
    //Getter methods
    public String getTheatreName() {
        return theatreName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public String getShowDate() {
        return showDate;
    }


    //================================================================
    //Setter methods
    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }


    /**
     * equals - a method that checks if the given object and this object are the same.
     * @param object is the object that will be compared to this object.
     * @return it will return true if all the fields are equal.
     *          Otherwise, it will return false.
     */
    public boolean equals(Object object){
        boolean result = false;

        if(object instanceof ViewingTime){
            ViewingTime vt = (ViewingTime)object;//casting the given object.

            if(((vt.theatreName == null && theatreName == null) || (vt.theatreName.equals(theatreName)))
                && ((vt.movieName == null) || (vt.movieName.equals(movieName)))
                && ((vt.showTime == null) || (vt.showTime.equals(showTime)))
                && ((vt.showDate == null) || (vt.showDate.equals(showDate)))){
                result =true;
            }//end nested if


        }//end if

        return result;

    }//end equals

}//end ViewingTime
