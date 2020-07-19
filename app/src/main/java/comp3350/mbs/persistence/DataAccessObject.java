package comp3350.mbs.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;

public class DataAccessObject implements DataAccess {

    private Statement st1, st2, st3;
    private Connection c1;
    private ResultSet rs2, rs3, rs4, rs5;

    private String dbName;
    private String dbType;

    private String cmdString;
    private int updateCount;
    private String result;
    private static String EOF = "  ";

    private List<Theatre> theatreList;
    private List<TheatreMovies> theatreMoviesList;

    public DataAccessObject(String dbName)
    {
        this.dbName = dbName;
    }

    @Override
    public void open(String dbPath) {

        String url;
        try {
            // Setup for HSQL
            dbType = "HSQL";
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            url = "jdbc:hsqldb:file:" + dbPath; // stored on disk mode
            c1 = DriverManager.getConnection(url, "SA", "");
            st1 = c1.createStatement();//THEATRE TABLE
            st2 = c1.createStatement();//MOVIE TABLE
            //st3 = c1.createStatement();

        } catch (Exception e) {
            processSQLError(e);
        }//end try-catch

        System.out.println("Opened " +dbType +" database " +dbPath);

    }//end open

    @Override
    public void close() {
        try {
            // commit all changes to the database
            cmdString = "shutdown compact";
            rs2 = st1.executeQuery(cmdString);
            c1.close();
        } catch (Exception e) {
            processSQLError(e);
        }//end try-catch

        System.out.println("Closed " +dbType +" database " +dbName);

    }//end close

    @Override
    public List<Theatre> getTheatreList() {
        theatreList = new ArrayList<>();
        String name;
        String address;
        String distance;

        try {
            cmdString = "SELECT * FROM THEATRES"; // selecting all the fields from the THEATRES Table
            rs2 =st1.executeQuery(cmdString);

            while(rs2.next()){
                name =rs2.getString("NAME");
                address = rs2.getString("ADDRESS");
                distance = rs2.getString("DISTANCE");
                Theatre theatre = new Theatre(name,address,distance);
                theatreList.add(theatre);
            }//end while
        }catch(Exception e){
            processSQLError(e);
        }//end try-catch


        return theatreList;
    }


    @Override
    public List<Seat> getSeatList() {
        return null;
    }

    @Override
    public List<Ticket> getTicketList() {
        return null;
    }

    @Override
    public Ticket getTicket(String ticketType) {
        return null;
    }

    @Override
    public List<TheatreMovies> getMoviesFromTheatre(TheatreMovies whichTheatre) {
        theatreMoviesList = new ArrayList<>();

        TheatreMovies tm;
        String theatreName;
        String movieName;
        int moviePoster;
        String movieDescription;

        try{
            cmdString = "SELECT * FROM MOVIES WHERE THEATRENAME = " + "'" +whichTheatre.getTheatreName() + "'"; //Selecting all the fields from the MOVIES table from the given theatre.
            rs2 = st2.executeQuery(cmdString);

            while(rs2.next()){
                theatreName = rs2.getString("THEATRENAME");
                movieName = rs2.getString("TITLE");
                moviePoster = rs2.getInt("POSTER");
                movieDescription = rs2.getString("DESCRIPTION");

                //TODO access the actual image of the movie instead of the numbers.
                if(moviePoster == 0){
                    moviePoster = R.drawable.avengers_endgame;
                }else if(moviePoster == 1){
                    moviePoster = R.drawable.incredibles;
                }else if(moviePoster == 2){
                    moviePoster = R.drawable.lion_king;
                }else if(moviePoster == 3){
                    moviePoster = R.drawable.starwars;
                }else if(moviePoster == 4){
                    moviePoster = R.drawable.superman;
                }else{
                    moviePoster = R.drawable.ic_launcher_foreground;//show this to represent that the movie has no specific image.
                }//end if-elses

                tm = new TheatreMovies(theatreName,movieName,moviePoster,movieDescription);
                theatreMoviesList.add(tm);

            }//end while

        }catch(Exception e){
            processSQLError(e);
        }//end try-catch


        return theatreMoviesList;
    }

    @Override
    public List<TheatreMovies> getTheatresFromMovie(TheatreMovies whichMovie) {
        return null;
    }


    public String processSQLError(Exception e) {
        String result = "*** SQL Error: " + e.getMessage();

        // Remember, this will NOT be seen by the user!
        e.printStackTrace();

        return result;
    }//end processSqError

}//end DataAccessObject class
