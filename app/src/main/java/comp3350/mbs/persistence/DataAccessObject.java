package comp3350.mbs.persistence;

import java.sql.Connection;
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
    public void open(String dbName) {

    }

    @Override
    public void close() {

    }

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
}
