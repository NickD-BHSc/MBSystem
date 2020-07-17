package comp3350.mbs.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;

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
            st1 = c1.createStatement();
            st2 = c1.createStatement();
            st3 = c1.createStatement();

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
        return null;
    }

    @Override
    public List<Movie> getMovieList(Theatre whichTheatre) {
        return null;
    }

    @Override
    public List<ViewingTime> getViewingTimeList(Theatre whichTheatre, Movie whichMovie) {
        return null;
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


    public String processSQLError(Exception e) {
        String result = "*** SQL Error: " + e.getMessage();

        // Remember, this will NOT be seen by the user!
        e.printStackTrace();

        return result;
    }//end processSqError

}//end DataAccessObject class
