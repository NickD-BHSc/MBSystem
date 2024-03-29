package comp3350.mbs.objects;

public class ViewingTime {

    private String theatreName;
    private String movieName;
    private String showTime;
    private String showDate;
    private String seatString;

    /**
     * ViewingTime Constructor
     *
     * @param theatreName is the name of the theatre.
     * @param movieName is the movie name.
     * @param showTime is the show time of the movie.
     * @param showDate is the show date of the movie.
     * @param seatString is the encoded list of seats for the movie.
     */
    public ViewingTime(String theatreName, String movieName, String showTime, String showDate, String seatString){
        this.theatreName = theatreName;
        this.movieName = movieName;
        this.showTime = showTime;
        this.showDate = showDate;
        this.seatString = seatString;
    }//end constructor

    //================================================================
    //Getter methods
    public String getTheatreName(){
        return theatreName;
    }//end getTheatreName

    public String getMovieName(){
        return movieName;
    }//end getMovieName

    public String getShowTime(){
        return showTime;
    }//end getShowTime

    public String getShowDate(){
        return showDate;
    }//end getShowDate

    public String getSeatString(){
        return seatString;
    }//end getSeatString

    //Setter method
    public void setSeatString(String seatString) {
        this.seatString = seatString;
    }//end setSeatString

    /**
     * equals - a method that checks if the given object and this object are the same.
     * @param object is the object that will be compared to this object.
     * @return it will return true if all the fields are equal.
     *          Otherwise, it will return false.
     */
    public boolean equals(Object object){
        boolean result = false;

        if(object instanceof ViewingTime){
            ViewingTime viewingTime = (ViewingTime)object;

            if(((viewingTime.theatreName == null && theatreName == null) || (viewingTime.theatreName.equals(theatreName)))
                && ((viewingTime.movieName == null) || (viewingTime.movieName.equals(movieName)))
                && ((viewingTime.showTime == null) || (viewingTime.showTime.equals(showTime)))
                && ((viewingTime.showDate == null) || (viewingTime.showDate.equals(showDate)))
                && ((viewingTime.seatString == null ) || (viewingTime.seatString.equals( seatString)))){
                result =true;
            }
        }

        return result;
    }//end equals

}//end ViewingTime class
