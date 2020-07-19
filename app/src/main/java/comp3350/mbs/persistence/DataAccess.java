package comp3350.mbs.persistence;

import java.util.List;

import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;

public interface DataAccess {

    void open(String dbName);

    void close();

    List<Theatre> getTheatreList();

    List<TheatreMovies> getMoviesFromTheatre(TheatreMovies whichTheatre);

    List<TheatreMovies> getTheatresFromMovie(TheatreMovies whichMovie); //may not be needed.

    List<ViewingTime> getViewingTimeList(TheatreMovies theatreMovie);//get the list of viewing time from the given theatre and movie.

    List<Seat> getSeatList();

    List<Ticket> getTicketList();

    Ticket getTicket(String ticketType);
}
