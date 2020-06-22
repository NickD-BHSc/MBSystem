package comp3350.mbs.objects;

import java.util.List;

public class ViewingTime {
    private String showTime;
    private String showDate;
    private List<Integer> seats;

    /**
     * Constructor of ViewingTime class
     * @param showTime is the showing time of the movie.
     * @param showDate is the date of viewing the movie.
     * @param seats is the list of seats available for the movie.
     */
    public ViewingTime(String showTime, String showDate, List<Integer> seats) {
        this.showTime = showTime;
        this.showDate = showDate;
        this.seats = seats;
    }//end constructor


}//end ViewingTime
