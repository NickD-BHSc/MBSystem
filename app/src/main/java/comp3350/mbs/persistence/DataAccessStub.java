package comp3350.mbs.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.ViewingTime;

public class DataAccessStub {

    private String dbName;
    private String dbType = "stub";

    private List<Theatre> theatreList;

    //Constructors
    public DataAccessStub(){
        //this.dbName = Main.dbName;
    }//end null constructor

    public DataAccessStub(String dbName) {
        this.dbName = dbName;
    }//end constructor


    /**
     * open - a method that opens the data from the database.
     * @param databaseName is the name of the database.
     */
    public void open(String databaseName){

        List<ViewingTime> viewingTimes = new ArrayList<>();//list of viewing time for a specific movie

        ViewingTime vt1 = new ViewingTime("7:00 to 10:00 PM", "June 11, 2020, Tuesday", null);
        ViewingTime vt2 = new ViewingTime("1:00 to 2:00 PM", "March 25, 2020, Wednesday", null);
        ViewingTime vt3 = new ViewingTime("5:00 to 6:30 PM", "August 19, 2020, Monday", null);
        ViewingTime vt4 = new ViewingTime("7:00 to 9:00 PM", "May 11, 2020, Friday", null);
        ViewingTime vt5 = new ViewingTime("4:30 to 7:00 PM", "July 2, 2020, Sunday", null);

        //data for viewingTimes added 2 times.
        viewingTimes.add(vt1);
        viewingTimes.add(vt2);
        viewingTimes.add(vt3);
        viewingTimes.add(vt4);
        viewingTimes.add(vt5);

        viewingTimes.add(vt1);
        viewingTimes.add(vt2);
        viewingTimes.add(vt3);
        viewingTimes.add(vt4);
        viewingTimes.add(vt5);

        List<Movie> movieLists = new ArrayList<>();//list of movies available in the theatre

        //TODO should also add the trailer as a parameter when Movie class accepts a Trailer parameter.
        String m1Summary = "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.";
        Movie m1 = new Movie("Avengers Endgame", R.drawable.avengers_endgame, m1Summary, viewingTimes, 12.50,null);
        Movie m2 = new Movie("The Incredibles", R.drawable.incredibles, "movie2", viewingTimes,11.50, null);
        Movie m3 = new Movie("The Lion King", R.drawable.lion_king, "movie3", viewingTimes, 9.50, null);
        Movie m4 = new Movie("Star Wars", R.drawable.starwars, "movie4", viewingTimes, 10.96,null);
        Movie m5 = new Movie("Superman", R.drawable.superman, "movie5", viewingTimes, 13.13,null);

        movieLists.add(m1);
        movieLists.add(m2);
        movieLists.add(m3);
        movieLists.add(m4);
        movieLists.add(m5);

        theatreList = new ArrayList<>();
        Theatre t1 = new Theatre("Theatre 1", "Address One", movieLists, "180m");
        Theatre t2 = new Theatre("Theatre 2", "Address Two", movieLists, "100m");
        Theatre t3 = new Theatre("Theatre 3", "Address Three", movieLists, "150m");
        Theatre t4 = new Theatre("Theatre 4", "Address Four", movieLists, "250m");
        Theatre t5 = new Theatre("Theatre 5", "Address Five", movieLists, "450m");
        Theatre t6 = new Theatre("Theatre 6", "Address Six", movieLists, "700m");
        Theatre t7 = new Theatre("Theatre 7", "Address Seven", movieLists, "800m");
        Theatre t8 = new Theatre("Theatre 8", "Address Eight", movieLists, "600m");
        Theatre t9 = new Theatre("Theatre 9", "Address Nine", movieLists, "300m");

        theatreList.add(t1);
        theatreList.add(t2);
        theatreList.add(t3);
        theatreList.add(t4);
        theatreList.add(t5);
        theatreList.add(t6);
        theatreList.add(t7);
        theatreList.add(t8);
        theatreList.add(t9);



        System.out.println("Opened " + dbType + " database " + dbName + ".");

    }//end open

    /**
     * close - a method that closes the database.
     */
    public void close(){
        System.out.println("Closed " + dbType + " database " + dbName + ".");
    }//end close


    /**
     * getTheatreList -a getter method for the theatreList field.
     * @return it will return the field theatreList.
     */
    public List<Theatre> getTheatreList(){
        return theatreList;
    }//end getTheatreList


    /**
     * getMovieList - a getter method for the movieList for the given theatre.
     * @param whichTheatre is the theatre that contains the list of movies.
     * @return it will return the movieList for the given theatre if it exists.
     *          Otherwise it will return null.
     */
    public List<Movie> getMovieList(Theatre whichTheatre){

        List<Movie> movieList = null;
        for(int i = 0; i <theatreList.size(); i++){

            if(theatreList.get(i).equals(whichTheatre)){
                movieList = theatreList.get(i).getMovieList();
            }//end if

        }//end for
        return movieList;

    }//end getMovieList

    /**
     * getViewingTimeList - a getter method for the viewingTimeList for the given movie
     *          assuming that the user has chosen the theatre already.
     * @param whichTheatre is thea theatre that the user has chosen.
     * @param whichMovie is the movie that contains the list of viewing time.
     * @return it will return the viewingTimeList for the given movie if it exists.
     *          Otherwise it will return null.
     */
    public List<ViewingTime> getViewingTimeList(Theatre whichTheatre, Movie whichMovie){
        List<ViewingTime> viewingTimeList = null;

        int posTheatre = theatreList.indexOf(whichTheatre); //position of the theatre in the list if it exists.

        if( posTheatre != -1){
            //given theatre is found.
            List<Movie> movies = theatreList.get(posTheatre).getMovieList();

            int posMovie = movies.indexOf(whichMovie);// position of the movie from the list if it exists.
            if(posMovie != -1){
                //given movie is found.
                viewingTimeList = movies.get(posMovie).getShowingTime();
            }//end nested if
        }//end if

        return viewingTimeList;

    }//end getViewingTimeList


}//end DataAccessStub
