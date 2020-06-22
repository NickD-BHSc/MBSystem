package comp3350.mbs.objects;

import java.util.List;

public class Movie {

    private String title;
    private int poster;
    private String description;
    private List<ViewingTime> showingTime;
    private List<String> mainActors;

    /**
     * Constructor of Movie class
     * @param title is the name of the movie.
     * @param poster is the picture of the movie.
     * @param description is the description of the movie.
     * @param showingTime is the list of showing time of the movie.
     * @param mainActors is the list of main actors of the movie.
     */
    public Movie(String title, int poster, String description, List<ViewingTime> showingTime, List<String> mainActors) {
        this.title = title;
        this.poster = poster;
        this.description = description;
        this.showingTime = showingTime;
        this.mainActors = mainActors;
    }//end constructor

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

    public List<String> getMainActors() {
        return mainActors;
    }//end getMainActors

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", poster=" + poster +
                ", description='" + description + '\'' +
                ", showingTime=" + showingTime +
                ", mainActors=" + mainActors +
                '}';
    }//end toString

}//end Movie class
