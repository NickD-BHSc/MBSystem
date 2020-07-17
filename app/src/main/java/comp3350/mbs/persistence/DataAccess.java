package comp3350.mbs.persistence;

import java.util.List;

import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;

public interface DataAccess {

    void open(String dbName);

    void close();

    List<Theatre> getTheatreList();

    List<Seat> getSeatList();

    List<Ticket> getTicketList();

    Ticket getTicket(String ticketType);

    List<TheatreMovies> getMoviesFromTheatre(TheatreMovies whichTheatre);
    List<TheatreMovies> getTheatresFromMovie(TheatreMovies whichMovie); //may not be needed.

}
