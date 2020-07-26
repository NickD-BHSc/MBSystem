package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.objects.Seat;
import comp3350.mbs.R;

public class SeatEncodingTest extends TestCase {



    public SeatEncodingTest(String arg0){ super( arg0 );}

    SeatEncoding se;
    List<Seat> seatList;
    List<Seat> bookedSeats;
    String seatString;

    @Test
    public void testEmptyList(){
        System.out.println("Staring SeatEncodingTest: Empty List");
        se = new SeatEncoding();
        seatList = new ArrayList<Seat>();
        bookedSeats = new ArrayList<Seat>();

        seatString = se.encodeSeatList(seatList, bookedSeats );

        assertTrue( seatString.equals( "" ) );

        System.out.println("Finished SeatEncodingTest: Empty List\n");
    }

    @Test
    public void testEmptyString(){
        System.out.println("Starting SeatEncodingTest: Empty String");
        se = new SeatEncoding();
        seatString = "";

        seatList = se.decodeSeatList( seatString );

        List<Seat> testList = new ArrayList<Seat>();

        assertTrue( testList.equals( seatList ) );

        System.out.println("Finished SeatEncodingTest: EmptyString\n");

    }

    @Test
    public void testCommonDecode(){
        System.out.println("Starting SeatEncodingTest: Common Decode");
        se = new SeatEncoding();
        seatString = "1010";

        seatList = se.decodeSeatList( seatString );

        List<Seat> testList = new ArrayList<Seat>();
        testList.add( new Seat( 0, true, R.drawable.seat_taken));
        testList.add( new Seat( 1, false, R.drawable.seat));
        testList.add( new Seat( 2, true, R.drawable.seat_taken));
        testList.add( new Seat( 3, false, R.drawable.seat));

        for( int i = 0; i < 4; i++){
            assertTrue( testList.get(i).equals( seatList.get(i)));
        }

        System.out.println("Finsihed SeatEncodingTest: Common Decode\n");
    }

    @Test
    public void testCommonEncode(){
        System.out.println( "Starting SeatEncodingTest: Common Encode");
        se = new SeatEncoding();

        seatList = new ArrayList<Seat>();
        bookedSeats = new ArrayList<Seat>();
        for( int i = 0; i < 5; i++){
            Seat s = new Seat( i, false, R.drawable.seat);
            seatList.add( s );

            if( i%2 == 0 ){
                bookedSeats.add( s );
            }
        }

        seatString = se.encodeSeatList( seatList, bookedSeats);

        String testString = "10101";

        assertEquals( seatString, testString);

        System.out.println( "Finished SeatEncodingTest: Common Encode\n");

    }

    @Test
    public void testNullString(){
        System.out.println( "Starting SeatEncodingTest: Null String");
        se = new SeatEncoding();
        seatString = null;

        seatList = se.decodeSeatList( seatString );

        List<Seat> testList = new ArrayList<Seat>();

        assertEquals( seatList, testList);

        System.out.println( "Finished SeatEncodingTest: Null String\n");


    }

    @Test
    public void testNullLists(){
        System.out.println( "Starting SeatEncodingTest: Null Lists");
        se = new SeatEncoding();

        seatList = null;
        bookedSeats = null;

        seatString = se.encodeSeatList( seatList, bookedSeats );
        String testString = "";

        assertEquals(seatString, testString);
        System.out.println( "Finished SeatEncodingTest: Null Lists\n");

    }

    @Test
    public void testRandomString(){
        System.out.println( "Starting SeatEncodingTest: Random String");
        se = new SeatEncoding();

        seatString = "asdfjkl;";

        seatList = se.decodeSeatList( seatString );

        List<Seat> testList = new ArrayList<Seat>();

        for( int i = 0; i < seatString.length(); i++){
            testList.add( new Seat( i, true, R.drawable.seat_taken));
        }

        for( int j = 0; j < testList.size(); j++ ){
            assertTrue( testList.get(j).isBooked() == seatList.get(j).isBooked() );
        }

        System.out.println( "Finished SeatEncodingTest: Random String\n");
    }

    @Test
    public void testNullSeats(){
        System.out.println( "Starting SeatEncodingTest: Null Seats");
        se = new SeatEncoding();

        seatList = new ArrayList<Seat>();
        bookedSeats = new ArrayList<Seat>();
        for( int i = 0; i < 5; i++ ){
            seatList.add( null );
            bookedSeats.add( null );
        }

        seatString = se.encodeSeatList(seatList, bookedSeats );

        String testString = "";

        assertEquals( seatString, testString );

        System.out.println( "Finished SeatEncodingTest: Null Seats\n");
    }
}
