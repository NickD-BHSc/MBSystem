package comp3350.mbs.persistence;

import java.util.List;

import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;

public class DataAccessObject implements DataAccess {
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
