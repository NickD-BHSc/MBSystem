package comp3350.mbs.persistence;

import java.util.List;

import comp3350.mbs.objects.Order;
import comp3350.mbs.objects.Review;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;

public interface DataAccess {

    void open(String dbName);

    void close();

    List<Theatre> getTheatreList();

    List<TheatreMovies> getMoviesFromTheatre(TheatreMovies theatreName);

    List<ViewingTime> getViewingTimeList(TheatreMovies theatreMovie);

    List<Order> getOrderList();

    Ticket getTicket(String movieName);

    String updateSeatList( ViewingTime viewingTime, String seatList);

    void insertNewOrder(Order order);

    void deleteOrder(Order order);

    List<Review> getReviewList(String movieName, String rating);

    void insertNewReview(Review review);

    void deleteReview( Review review);

}
