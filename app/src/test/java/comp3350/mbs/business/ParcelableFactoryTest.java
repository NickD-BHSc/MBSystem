package comp3350.mbs.business;

import android.os.Parcelable;

import junit.framework.TestCase;

import org.junit.Test;

import comp3350.mbs.R;
import comp3350.mbs.objects.Order;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.presentation.ParcelableOrder;
import comp3350.mbs.presentation.ParcelableSeat;
import comp3350.mbs.presentation.ParcelableTheatre;
import comp3350.mbs.presentation.ParcelableTheatreMovies;
import comp3350.mbs.presentation.ParcelableTicket;
import comp3350.mbs.presentation.ParcelableViewingTime;

public class ParcelableFactoryTest extends TestCase {

    private Parcelable parcelableObject;

    public ParcelableFactoryTest(String arg0){
        super(arg0);
    }

    public void setUp(){
        parcelableObject = null;
    }//end setUp

    @Test
    public void testCreateParcelableTheatre(){

        System.out.println("Starting TestParcelableFactory: testCreateParcelableTheatre");

        Theatre theatre = new Theatre("theatre1","address1");
        assertNotNull(theatre);
        assertEquals("theatre1",theatre.getName());
        assertEquals("address1",theatre.getAddress());

        parcelableObject = ParcelableFactory.createParcelableObject(theatre);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableTheatre);

        assertEquals("theatre1",((ParcelableTheatre)parcelableObject).getName());
        assertEquals("address1",((ParcelableTheatre)parcelableObject).getAddress());

        System.out.println("Finished TestParcelableFactory: testCreateParcelableTheatre\n");

    }//end testCreateParcelableTheatre

    @Test
    public void testCreateParcelableTheatreMovie(){

        System.out.println("Starting TestParcelableFactory: testCreateParcelableTheatreMovie");

        TheatreMovies theatreMovie = new TheatreMovies("theatre1","movie1",1,"movieDescription1");
        assertNotNull(theatreMovie);
        assertEquals("theatre1",theatreMovie.getTheatreName());
        assertEquals("movie1",theatreMovie.getMovieName());
        assertEquals(1, theatreMovie.getMoviePoster());
        assertEquals("movieDescription1",theatreMovie.getMovieDescription());

        parcelableObject = ParcelableFactory.createParcelableObject(theatreMovie);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableTheatreMovies);

        assertEquals("theatre1",((ParcelableTheatreMovies)parcelableObject).getTheatreName());
        assertEquals("movie1",((ParcelableTheatreMovies)parcelableObject).getMovieName());
        assertEquals(1,((ParcelableTheatreMovies)parcelableObject).getMoviePoster());
        assertEquals("movieDescription1",((ParcelableTheatreMovies)parcelableObject).getMovieDescription());


        System.out.println("Finished TestParcelableFactory: testCreateParcelableTheatreMovie\n");

    }//end testCreateParcelableTheatreMovie

    @Test
    public void testCreateParcelableViewingTime(){

        System.out.println("Starting TestParcelableFactory: testCreateParcelableViewingTime");

        ViewingTime viewingTime = new ViewingTime("theatre1","movie1","show time","show date","00000000000000000000000000000000");
        assertNotNull(viewingTime);
        assertEquals("theatre1", viewingTime.getTheatreName());
        assertEquals("movie1",viewingTime.getMovieName());
        assertEquals("show time", viewingTime.getShowTime());
        assertEquals("show date", viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000", viewingTime.getSeatString());

        parcelableObject = ParcelableFactory.createParcelableObject(viewingTime);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableViewingTime);

        assertEquals("theatre1", ((ParcelableViewingTime)parcelableObject).getTheatreName());
        assertEquals("movie1",((ParcelableViewingTime)parcelableObject).getMovieName());
        assertEquals("show time", ((ParcelableViewingTime)parcelableObject).getShowTime());
        assertEquals("show date", ((ParcelableViewingTime)parcelableObject).getShowDate());
        assertEquals("00000000000000000000000000000000", ((ParcelableViewingTime)parcelableObject).getSeatString());

        System.out.println("Finished TestParcelableFactory: testCreateParcelableViewingTime\n");

    }//end testCreateParcelableViewingTime

    @Test
    public void testCreateParcelableSeat(){

        System.out.println("Starting TestParcelableFactory: testCreateParcelableSeat");

        Seat seat = new Seat(1,false, R.drawable.seat);
        assertNotNull(seat);
        assertEquals(1,seat.getSeatNumber());
        assertEquals(false,seat.isBooked());
        assertEquals(R.drawable.seat,seat.getSeatImage());

        parcelableObject = ParcelableFactory.createParcelableObject(seat);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableSeat);

        assertEquals(1,((ParcelableSeat)parcelableObject).getSeatNumber());
        assertEquals(false,((ParcelableSeat)parcelableObject).isBooked());
        assertEquals(R.drawable.seat,((ParcelableSeat)parcelableObject).getSeatImage());

        System.out.println("Finished TestParcelableFactory: testCreateParcelableSeat\n");

    }//end testCreateParcelableSeat

    @Test
    public void testCreateParcelableTicket(){

        System.out.println("Starting TestParcelableFactory: testCreateParcelableTicket");
        Ticket ticket;

        ticket = new Ticket(11.50,"movie1");
        assertNotNull(ticket);
        assertEquals(11.50,ticket.getPrice());
        assertEquals("movie1",ticket.getMovieName());

        parcelableObject = ParcelableFactory.createParcelableObject(ticket);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableTicket);

        assertEquals(11.50,((ParcelableTicket)parcelableObject).getPrice());
        assertEquals("movie1",((ParcelableTicket)parcelableObject).getMovieName());

        ticket = new Ticket(13.91,"movie2");
        assertNotNull(ticket);
        assertEquals(13.91,ticket.getPrice());
        assertEquals("movie2",ticket.getMovieName());


        parcelableObject = ParcelableFactory.createParcelableObject(ticket);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableTicket);

        assertEquals(13.91,((ParcelableTicket)parcelableObject).getPrice());
        assertEquals("movie2",((ParcelableTicket)parcelableObject).getMovieName());

        System.out.println("Finished TestParcelableFactory: testCreateParcelableTicket\n");

    }//end testCreateParcelableTicket


    @Test
    public void testCreateParcelableOrder(){
        System.out.println("Starting TestParcelableFactory: testCreateParcelableOrder");
        Order order;

        order = new Order("movie1","show time","show date","theatre1",5);
        assertNotNull(order);
        assertEquals("movie1",order.getMovieName());
        assertEquals("show time",order.getShowTime());
        assertEquals("show date",order.getShowDate());
        assertEquals("theatre1",order.getTheatreName());
        assertEquals(5,order.getTicketQuantity());

        parcelableObject = ParcelableFactory.createParcelableObject(order);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableOrder);

        assertEquals("movie1",((ParcelableOrder)parcelableObject).getMovieName());
        assertEquals("show time",((ParcelableOrder)parcelableObject).getShowTime());
        assertEquals("show date",((ParcelableOrder)parcelableObject).getShowDate());
        assertEquals("theatre1",((ParcelableOrder)parcelableObject).getTheatreName());
        assertEquals(5,((ParcelableOrder)parcelableObject).getTicketQuantity());


        System.out.println("Finished TestParcelableFactory: testCreateParcelableOrder\n");
    }//end testCreateParcelableOrder

    @Test
    public void testCreateParcelableNullObjects(){

        System.out.println("Starting TestParcelableFactory: testCreateParcelableNullObjects");
        Theatre theatre;
        TheatreMovies theatreMovie;
        ViewingTime viewingTime;
        Ticket ticket;
        Order order;

        //Theatre
        theatre = new Theatre(null,null);
        assertNotNull(theatre);
        assertNull(theatre.getName());
        assertNull(theatre.getAddress());

        parcelableObject = ParcelableFactory.createParcelableObject(theatre);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableTheatre);

        assertNull(((ParcelableTheatre)parcelableObject).getName());
        assertNull(((ParcelableTheatre)parcelableObject).getAddress());

        //theatreMovie
        theatreMovie = new TheatreMovies(null,null);
        assertNotNull(theatreMovie);
        assertNull(theatreMovie.getTheatreName());
        assertNull(theatreMovie.getMovieName());
        assertEquals(-1, theatreMovie.getMoviePoster());
        assertNull(theatreMovie.getMovieDescription());

        parcelableObject = ParcelableFactory.createParcelableObject(theatreMovie);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableTheatreMovies);

        assertNull(((ParcelableTheatreMovies)parcelableObject).getTheatreName());
        assertNull(((ParcelableTheatreMovies)parcelableObject).getMovieName());
        assertEquals(-1,((ParcelableTheatreMovies)parcelableObject).getMoviePoster());
        assertNull(((ParcelableTheatreMovies)parcelableObject).getMovieDescription());

        theatreMovie = new TheatreMovies(null,null,-1,null);
        assertNotNull(theatreMovie);
        assertNull(theatreMovie.getTheatreName());
        assertNull(theatreMovie.getMovieName());
        assertEquals(-1, theatreMovie.getMoviePoster());
        assertNull(theatreMovie.getMovieDescription());

        parcelableObject = ParcelableFactory.createParcelableObject(theatreMovie);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableTheatreMovies);

        assertNull(((ParcelableTheatreMovies)parcelableObject).getTheatreName());
        assertNull(((ParcelableTheatreMovies)parcelableObject).getMovieName());
        assertEquals(-1,((ParcelableTheatreMovies)parcelableObject).getMoviePoster());
        assertNull(((ParcelableTheatreMovies)parcelableObject).getMovieDescription());

        //Viewing time
        viewingTime = new ViewingTime(null,null,null,null,null);
        assertNotNull(viewingTime);
        assertNull( viewingTime.getTheatreName());
        assertNull(viewingTime.getMovieName());
        assertNull( viewingTime.getShowTime());
        assertNull( viewingTime.getShowDate());
        assertNull( viewingTime.getSeatString());

        parcelableObject = ParcelableFactory.createParcelableObject(viewingTime);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableViewingTime);

        assertNull( ((ParcelableViewingTime)parcelableObject).getTheatreName());
        assertNull(((ParcelableViewingTime)parcelableObject).getMovieName());
        assertNull( ((ParcelableViewingTime)parcelableObject).getShowTime());
        assertNull( ((ParcelableViewingTime)parcelableObject).getShowDate());
        assertNull( ((ParcelableViewingTime)parcelableObject).getSeatString());

        //Ticket
        ticket = new Ticket(0.0,null);
        assertNotNull(ticket);
        assertEquals(0.0,ticket.getPrice());
        assertNull(ticket.getMovieName());

        parcelableObject = ParcelableFactory.createParcelableObject(ticket);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableTicket);

        assertEquals(0.0,((ParcelableTicket)parcelableObject).getPrice());
        assertNull(((ParcelableTicket)parcelableObject).getMovieName());

        ticket = new Ticket(0.0,null);
        assertNotNull(ticket);
        assertEquals(0.0,ticket.getPrice());
        assertNull(ticket.getMovieName());

        parcelableObject = ParcelableFactory.createParcelableObject(ticket);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableTicket);

        assertEquals(0.0,((ParcelableTicket)parcelableObject).getPrice());
        assertNull(((ParcelableTicket)parcelableObject).getMovieName());

        //Order
        order = new Order(null,null,null,null,0);
        assertNotNull(order);
        assertNull(order.getMovieName());
        assertNull(order.getShowTime());
        assertNull(order.getShowDate());
        assertNull(order.getTheatreName());
        assertEquals(0,order.getTicketQuantity());

        parcelableObject = ParcelableFactory.createParcelableObject(order);
        assertNotNull(parcelableObject);
        assertTrue(parcelableObject instanceof ParcelableOrder);

        assertNull(((ParcelableOrder)parcelableObject).getMovieName());
        assertNull(((ParcelableOrder)parcelableObject).getShowTime());
        assertNull(((ParcelableOrder)parcelableObject).getShowDate());
        assertNull(((ParcelableOrder)parcelableObject).getTheatreName());
        assertEquals(0,((ParcelableOrder)parcelableObject).getTicketQuantity());


        System.out.println("Finished TestParcelableFactory: testCreateParcelableNullObjects\n");

    }//end testCreateParcelableNullObjects

    @Test
    public void testInvalidParcelable(){

        System.out.println("Starting TestParcelableFactory: testInvalidParcelable");
        String testInput;

        //test 1
        testInput = "";
        assertNotNull(testInput);
        assertEquals("",testInput);

        parcelableObject = ParcelableFactory.createParcelableObject(testInput);
        assertNull(parcelableObject);

        //test 2
        testInput = "test";
        assertNotNull(testInput);
        assertEquals("test",testInput);

        parcelableObject = ParcelableFactory.createParcelableObject(testInput);
        assertNull(parcelableObject);

        //test3
        parcelableObject = ParcelableFactory.createParcelableObject(null);
        assertNull(parcelableObject);

        System.out.println("Finished TestParcelableFactory: testInvalidParcelable\n");

    }//end testInvalidParcelable

}//end TestParcelableFactory
