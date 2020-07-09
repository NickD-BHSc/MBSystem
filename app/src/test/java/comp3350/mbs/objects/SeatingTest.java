package comp3350.mbs.objects;

import junit.framework.TestCase;

import org.junit.Test;

public class SeatingTest extends TestCase{

    public SeatingTest(String arg0){ super( arg0 );}

    @Test
    public void testSetGet(){

        Seat seat;

        System.out.println( "Begin Setter/Getter Test");

        seat = new Seat( 0, false, 0);

        assertEquals( seat.getSeatNumber(), 0 );
        assertTrue( !seat.isBooked() );
        assertEquals(  seat.getSeatImage(), 0);

        seat.setSeatNumber( 1 );
        seat.setBooked( true );
        seat.setSeatImage( 1 );

        assertEquals( seat.getSeatNumber(), 1);
        assertTrue( seat.isBooked() );
        assertEquals( seat.getSeatImage(), 1);

        System.out.println( "Setter/Getter Test Complete");
    }

    @Test
    public void testEquals(){
        Seat seat1;
        Seat seat2;

        System.out.println( "Begin Equals Test");

        seat1 = new Seat( 1, true, 0);
        seat2 = new Seat( 1, false, 1);

        assertTrue( seat1.equals( seat2 ));

        System.out.println( "Equals Test Complete");
    }
}
