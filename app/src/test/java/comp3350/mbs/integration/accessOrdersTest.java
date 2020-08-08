package comp3350.mbs.integration;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;
import comp3350.mbs.application.Services;
import comp3350.mbs.application.Main;
import comp3350.mbs.business.AccessOrders;
import comp3350.mbs.business.AccessSeats;
import comp3350.mbs.business.AccessTheatreMovies;
import comp3350.mbs.business.AccessTheatres;
import comp3350.mbs.business.AccessTickets;
import comp3350.mbs.business.AccessViewingTimes;
import comp3350.mbs.objects.Order;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;


public class accessOrdersTest extends TestCase {

    public accessOrdersTest(String arg0){
        super( arg0 );
    }

    @Test
    public void testAccessOrders() {
        AccessOrders ao;
        Order order;
        List<Order> orderList;

        Services.closeDataAccess();

        System.out.println("Starting Integration test of AccessOrders to persistence layer\n");

        Services.createDataAccess(Main.dbName);

        ao = new AccessOrders();

        //order list should be empty, no orders have been added
        orderList = ao.getOrderList();
        assertTrue(orderList.isEmpty()); //must be empty

        //test addOrder()
        order = new Order("Avengers", "7:00 to 9:00PM", "Friday, August 7th", "Happy Theatre", 2);
        ao.insertNewOrder(order);
        orderList = ao.getOrderList();
        assertTrue( orderList.get(0).equals( order ) ); //order from get call should be the same as ours

        //test deleteOrder()
        ao.deleteOrder( order );
        orderList = ao.getOrderList();
        assertTrue( orderList.isEmpty() ); //our order should be removed so the list should be empty

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessOrders to persistence layer\n");
    }

//    @Test
//    public void testAccessSeats(){
//        AccessSeats as;
//        ViewingTime vt;
//        String seatString;
//
//        Services.closeDataAccess();
//
//        System.out.println("Starting Integration test for AccessSeats to persistence layer\n");
//
//        Services.createDataAccess(Main.dbName);
//
//        as = new AccessSeats();
//
//        vt = new ViewingTime("Scotiabank Theatre", "Avengers Endgame", "1:00 to 4:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
//        seatString = "10000000000000000000000000000000";
//
//        as.updateSeatList(vt, seatString);
//        //assertEquals();
//        Services.closeDataAccess();
//
//        System.out.println("\nFinished Integration test of AccessOrders to persistence layer\n");
//    }

    public void testAccessViewingTimes(){
        AccessViewingTimes avt;
        String theatreName, movieName;
        List<ViewingTime> viewingTime;

        Services.closeDataAccess();

        System.out.println("Starting Integration test for AccessViewingTimes to persistence layer\n");

        Services.createDataAccess(Main.dbName);

        theatreName = "Scotiabank Theatre";
        movieName = "Avengers Endgame";
        String showTime = "1:00 to 4:00 PM";

        avt = new AccessViewingTimes();

        viewingTime = avt.getViewingTimeList(theatreName, movieName);
        assertEquals(viewingTime.get(0).getShowTime(), showTime);
        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessViewingTimes to persistence layer\n");

        //okay, i think i get how these integration tests work now. It's all about testing the access methods with the DataAccessObject and seeing if it retrieves what you expect it to retrieve
        //from the database and compare it to a hardcoded expected value.
    }

    public void testAccessTheatres(){
        List<Theatre> theatreList;
        AccessTheatres at;
        Theatre actual;

        Services.closeDataAccess();

        System.out.println("Starting Integration test for AccessTheatres to persistence layer\n");

        Services.createDataAccess(Main.dbName);

        at = new AccessTheatres();
        theatreList = at.getTheatreList();
        Theatre expected = new Theatre("Scotiabank Theatre", "817 St.James", "15.7km");
        actual = theatreList.get(0);

        assertEquals(actual.getName(), expected.getName());
        assertEquals(actual.getAddress(), expected.getAddress());
        assertEquals(actual.getDistance(), expected.getDistance());

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessViewingTimes to persistence layer\n");
    }

    public void testAccessTheatreMovies(){
        List<TheatreMovies> tml;
        AccessTheatreMovies atm;
        TheatreMovies actual;

        Services.closeDataAccess();

        System.out.println("Starting Integration test for AccessTheatreMovies to persistence layer\n");

        Services.createDataAccess(Main.dbName);

        atm = new AccessTheatreMovies();
        tml = atm.getMoviesFromTheatre("Cinema City Northgate");
        TheatreMovies expected = new TheatreMovies("Cinema City Northgate","Avengers Endgame",0,"Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.");
        actual = tml.get(0);

        assertEquals(actual.getMovieName(), expected.getMovieName());
        assertEquals(actual.getMovieDescription(), expected.getMovieDescription());
        assertEquals(actual.getTheatreName(), expected.getTheatreName());

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessTheatreMovies to persistence layer\n");
    }

    public void testAccessTickets(){
        AccessTickets at;
        Ticket actual;

        Services.closeDataAccess();

        System.out.println("Starting Integration test for AccessTickets to persistence layer\n");

        Services.createDataAccess(Main.dbName);

        at = new AccessTickets();
        Ticket expected = new Ticket(20.0, "The Lion King");
        actual = at.getTicket("The Lion King");

        assertEquals(actual.getMovieName(), expected.getMovieName());
        assertEquals(actual.getPrice(), expected.getPrice());

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessTickets to persistence layer\n");
    }
    
}
