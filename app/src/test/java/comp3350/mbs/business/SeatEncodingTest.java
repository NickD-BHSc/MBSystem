package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.objects.Seat;
import comp3350.mbs.R;

public class SeatEncodingTest extends TestCase {

    private SeatEncoding se;
    private List<Seat> seatList;
    private List<Seat> bookedSeats;
    private String seatString;

    public SeatEncodingTest(String arg0){ super( arg0 );}


    public void setUp(){
        se = null;
        seatList = null;
        bookedSeats = null;
        seatString = "";
    }//end setUp


    @Test
    public void testEmptyList(){
        System.out.println("Staring SeatEncodingTest:  testEmptyList");
        se = new SeatEncoding();
        seatList = new ArrayList<>();
        bookedSeats = new ArrayList<>();

        seatString = se.encodeSeatList(seatList, bookedSeats );

        assertTrue( seatString.equals( "" ) );
        assertEquals("",seatString);

        System.out.println("Finished SeatEncodingTest:  testEmptyList\n");
    }//end testEmptyList


    @Test
    public void testEmptyString(){
        System.out.println("Starting SeatEncodingTest: testEmptyString");
        se = new SeatEncoding();
        seatString = "";

        seatList = se.decodeSeatList( seatString );

        List<Seat> testList = new ArrayList<>();

        assertTrue( testList.equals( seatList ) );
        assertEquals(testList,seatList);

        System.out.println("Finished SeatEncodingTest: testEmptyString\n");

    }//end testEmptyString


    @Test
    public void testCommonDecode(){
        System.out.println("Starting SeatEncodingTest:  testCommonDecode");

        Seat testSeat;//for testList
        Seat seat;//for seatList

        se = new SeatEncoding();
        seatString = "1010";
        seatList = se.decodeSeatList( seatString );

        List<Seat> testList = new ArrayList<>();
        testList.add( new Seat( 0, true, R.drawable.seat_taken));
        testList.add( new Seat( 1, false, R.drawable.seat));
        testList.add( new Seat( 2, true, R.drawable.seat_taken));
        testList.add( new Seat( 3, false, R.drawable.seat));

        assertEquals(4,testList.size());
        assertEquals(4,seatList.size());

        //seat #0
        testSeat = testList.get(0);
        seat = seatList.get(0);

        assertTrue(testSeat.equals(seat));
        assertEquals(testSeat.getSeatNumber(),seat.getSeatNumber());
        assertEquals(testSeat.isBooked(),seat.isBooked());
        assertEquals(testSeat.getSeatImage(),seat.getSeatImage());

        //seat #1
        testSeat = testList.get(1);
        seat = seatList.get(1);

        assertTrue(testSeat.equals(seat));
        assertEquals(testSeat.getSeatNumber(),seat.getSeatNumber());
        assertEquals(testSeat.isBooked(),seat.isBooked());
        assertEquals(testSeat.getSeatImage(),seat.getSeatImage());

        //seat #2
        testSeat = testList.get(2);
        seat = seatList.get(2);

        assertTrue(testSeat.equals(seat));
        assertEquals(testSeat.getSeatNumber(),seat.getSeatNumber());
        assertEquals(testSeat.isBooked(),seat.isBooked());
        assertEquals(testSeat.getSeatImage(),seat.getSeatImage());


        //seat #3
        testSeat = testList.get(3);
        seat = seatList.get(3);

        assertTrue(testSeat.equals(seat));
        assertEquals(testSeat.getSeatNumber(),seat.getSeatNumber());
        assertEquals(testSeat.isBooked(),seat.isBooked());
        assertEquals(testSeat.getSeatImage(),seat.getSeatImage());


        System.out.println("Finsihed SeatEncodingTest:  testCommonDecode\n");
    }//end testCommonDecode


    @Test
    public void testCommonEncode(){
        System.out.println( "Starting SeatEncodingTest:  testCommonEncode");
        se = new SeatEncoding();

        seatList = new ArrayList<>();
        bookedSeats = new ArrayList<>();

        //TODO remove the for loop
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

        System.out.println( "Finished SeatEncodingTest:  testCommonEncode\n");

    }//end testCommonEncode


    @Test
    public void testNullString(){
        System.out.println( "Starting SeatEncodingTest: testNullString");
        se = new SeatEncoding();
        seatString = null;

        seatList = se.decodeSeatList( seatString );

        List<Seat> testList = new ArrayList<>();

        assertEquals( seatList, testList);

        System.out.println( "Finished SeatEncodingTest: testNullString\n");

    }//end testNullString


    @Test
    public void testNullLists(){
        System.out.println( "Starting SeatEncodingTest: testNullLists");
        se = new SeatEncoding();

        seatList = null;
        bookedSeats = null;

        seatString = se.encodeSeatList( seatList, bookedSeats );
        String testString = "";

        assertEquals(seatString, testString);
        System.out.println( "Finished SeatEncodingTest: testNullLists\n");

    }//end testNullLists


    @Test
    public void testRandomString(){
        System.out.println( "Starting SeatEncodingTest: testRandomString");
        se = new SeatEncoding();

        seatString = "asdfjkl;";

        seatList = se.decodeSeatList( seatString );

        List<Seat> testList = new ArrayList<>();

        //TODO remove the for loops
        for( int i = 0; i < seatString.length(); i++){
            testList.add( new Seat( i, true, R.drawable.seat_taken));
        }

        for( int j = 0; j < testList.size(); j++ ){
            assertTrue( testList.get(j).isBooked() == seatList.get(j).isBooked() );
        }

        System.out.println( "Finished SeatEncodingTest: testRandomString\n");
    }//end testRandomString


    @Test
    public void testNullSeats(){
        System.out.println( "Starting SeatEncodingTest: testNullSeats");
        se = new SeatEncoding();

        seatList = new ArrayList<>();
        bookedSeats = new ArrayList<>();
        for( int i = 0; i < 5; i++ ){
            seatList.add( null );
            bookedSeats.add( null );
        }

        seatString = se.encodeSeatList(seatList, bookedSeats );

        String testString = "";

        assertEquals( seatString, testString );

        System.out.println( "Finished SeatEncodingTest: testNullSeats\n");
    }//testNullSeats

}//end SeatEncodingTest
