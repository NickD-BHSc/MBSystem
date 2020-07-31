package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.objects.Seat;
import comp3350.mbs.R;

public class SeatEncodingTest extends TestCase {

    private SeatEncoding seatEncoding;
    private List<Seat> seatList;
    private List<Seat> bookedSeats;
    private String seatString;

    public SeatEncodingTest(String arg0){
        super(arg0);
    }//end SeatEncodingTest

    public void setUp(){
        seatEncoding = null;
        seatList = null;
        bookedSeats = null;
        seatString = "";
    }//end setUp

    @Test
    public void testEmptyList(){

        System.out.println("Staring SeatEncodingTest:  testEmptyList");
        seatEncoding = new SeatEncoding();
        seatList = new ArrayList<>();
        bookedSeats = new ArrayList<>();
        seatString = seatEncoding.encodeSeatList(seatList, bookedSeats);

        assertTrue(seatString.equals( "" ));
        assertEquals("",seatString);

        System.out.println("Finished SeatEncodingTest:  testEmptyList\n");

    }//end testEmptyList

    @Test
    public void testEmptyString(){

        System.out.println("Starting SeatEncodingTest: testEmptyString");
        seatEncoding = new SeatEncoding();
        seatString = "";
        seatList = seatEncoding.decodeSeatList(seatString);
        List<Seat> testList = new ArrayList<>();

        assertTrue(testList.equals(seatList));
        assertEquals(testList,seatList);

        System.out.println("Finished SeatEncodingTest: testEmptyString\n");

    }//end testEmptyString

    @Test
    public void testCommonDecode(){

        System.out.println("Starting SeatEncodingTest:  testCommonDecode");

        seatEncoding = new SeatEncoding();
        seatString = "1010";
        seatList = seatEncoding.decodeSeatList(seatString);

        List<Seat> testList = new ArrayList<Seat>();
        testList.add(new Seat( 0, true, R.drawable.seat_taken));
        testList.add(new Seat( 1, false, R.drawable.seat));
        testList.add(new Seat( 2, true, R.drawable.seat_taken));
        testList.add(new Seat( 3, false, R.drawable.seat));

        for(int i = 0; i < 4; i++){
            assertTrue(testList.get(i).equals(seatList.get(i)));
        }

        System.out.println("Finished SeatEncodingTest:  testCommonDecode\n");

    }//end testCommonDecode

    @Test
    public void testCommonEncode(){

        System.out.println("Starting SeatEncodingTest:  testCommonEncode");
        seatEncoding = new SeatEncoding();

        seatList = new ArrayList<>();
        bookedSeats = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Seat seat = new Seat(i, false, R.drawable.seat);
            seatList.add(seat);

            if(i%2 == 0){
                bookedSeats.add(seat);
            }
        }

        seatString = seatEncoding.encodeSeatList(seatList, bookedSeats);
        String testString = "10101";
        assertEquals(seatString, testString);

        System.out.println("Finished SeatEncodingTest:  testCommonEncode\n");

    }//end testCommonEncode

    @Test
    public void testNullString(){

        System.out.println("Starting SeatEncodingTest: testNullString");
        seatEncoding = new SeatEncoding();

        seatList = seatEncoding.decodeSeatList(null);
        List<Seat> testList = new ArrayList<>();
        assertEquals(seatList, testList);

        System.out.println("Finished SeatEncodingTest: testNullString\n");

    }//end testNullString

    @Test
    public void testNullLists(){

        System.out.println( "Starting SeatEncodingTest: testNullLists");
        seatEncoding = new SeatEncoding();
        seatString = seatEncoding.encodeSeatList(null, null);
        String testString = "";
        assertEquals(seatString, testString);

        System.out.println("Finished SeatEncodingTest: testNullLists\n");

    }//end testNullLists

    @Test
    public void testRandomString(){

        System.out.println("Starting SeatEncodingTest: testRandomString");
        seatEncoding = new SeatEncoding();

        seatString = "asdfjkl;";
        seatList = seatEncoding.decodeSeatList(seatString);

        List<Seat> testList = new ArrayList<>();

        for( int i = 0; i < seatString.length(); i++){
            testList.add( new Seat( i, true, R.drawable.seat_taken));
        }

        for( int j = 0; j < testList.size(); j++ ){
            assertTrue( testList.get(j).isBooked() == seatList.get(j).isBooked());
        }

        System.out.println("Finished SeatEncodingTest: testRandomString\n");

    }//end testRandomString

    @Test
    public void testNullSeats(){

        System.out.println("Starting SeatEncodingTest: testNullSeats");
        seatEncoding = new SeatEncoding();

        seatList = new ArrayList<>();
        bookedSeats = new ArrayList<>();
        for( int i = 0; i < 5; i++ ){
            seatList.add(null);
            bookedSeats.add(null);
        }

        seatString = seatEncoding.encodeSeatList(seatList, bookedSeats);
        String testString = "";
        assertEquals(seatString, testString);

        System.out.println("Finished SeatEncodingTest: testNullSeats\n");

    }//testNullSeats

}//end SeatEncodingTest
