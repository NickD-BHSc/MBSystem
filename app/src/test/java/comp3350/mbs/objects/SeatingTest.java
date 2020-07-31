package comp3350.mbs.objects;

import junit.framework.TestCase;

import org.junit.Test;

public class SeatingTest extends TestCase {

    public SeatingTest(String arg0){
        super( arg0 );
    }

    @Test
    public void testSetGet(){

        Seat seat;
        System.out.println("Starting SeatingTest: testSetGet");

        seat = new Seat( 0, false, 0);
        assertNotNull(seat);

        assertTrue(0 == seat.getSeatNumber());
        assertEquals(0, seat.getSeatNumber());

        assertTrue(!seat.isBooked());
        assertEquals(false, seat.isBooked());

        assertTrue(0 == seat.getSeatImage());
        assertEquals(0, seat.getSeatImage());

        seat.setSeatNumber(1);
        seat.setBooked(true);
        seat.setSeatImage(1);

        assertTrue(1 == seat.getSeatNumber());
        assertEquals(1,seat.getSeatNumber());

        assertTrue(seat.isBooked());
        assertEquals(true, seat.isBooked());

        assertTrue(1 == seat.getSeatImage());
        assertEquals(1, seat.getSeatImage());

        System.out.println( "Finished SeatingTest: testSetGet");

    }//end testSetGet


    @Test
    public void testEquals(){

        Seat seat1;
        Seat seat2;

        System.out.println("Starting SeatingTest: testEquals");

        seat1 = new Seat( 1, true, 0);
        seat2 = new Seat( 1, false, 1);
        assertNotNull(seat1);
        assertNotNull(seat2);

        assertTrue(seat1.equals(seat2));

        System.out.println("Finished SeatingTest: testEquals\n");

    }//end testEquals

}//end SeatingTest class
