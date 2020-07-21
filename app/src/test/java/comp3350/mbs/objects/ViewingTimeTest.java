package comp3350.mbs.objects;
import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;
public class ViewingTimeTest extends TestCase {

    public ViewingTimeTest(String arg0){super(arg0);}

    @Test
    public void testOneViewingTime(){

        System.out.println("Starting ViewingTimeTest: testOneViewingTime");

        ViewingTime viewingTime1 = new ViewingTime("Theatre1","Movie1","1:30 to 3:30 PM", "July 8, 2020, Wednesday");
        assertNotNull(viewingTime1);

        assertTrue("Theatre1".equals(viewingTime1.getTheatreName()));
        assertEquals("Theatre1", viewingTime1.getTheatreName());

        assertTrue("Movie1".equals(viewingTime1.getMovieName()));
        assertEquals("Movie1",viewingTime1.getMovieName());

        assertTrue("1:30 to 3:30 PM".equals(viewingTime1.getShowTime()));
        assertEquals("1:30 to 3:30 PM", viewingTime1.getShowTime());

        assertTrue("July 8, 2020, Wednesday".equals(viewingTime1.getShowDate()));
        assertEquals("July 8, 2020, Wednesday", viewingTime1.getShowDate());


        ViewingTime viewingTime2 = new ViewingTime("Theatre2","Movie2","3:30 to 6:00 PM", "July 10, 2020, Friday");

        assertTrue("Theatre2".equals(viewingTime2.getTheatreName()));
        assertEquals("Theatre2", viewingTime2.getTheatreName());

        assertTrue("Movie2".equals(viewingTime2.getMovieName()));
        assertEquals("Movie2",viewingTime2.getMovieName());

        assertTrue("3:30 to 6:00 PM".equals(viewingTime2.getShowTime()));
        assertEquals("3:30 to 6:00 PM", viewingTime2.getShowTime());

        assertTrue("July 10, 2020, Friday".equals(viewingTime2.getShowDate()));
        assertEquals("July 10, 2020, Friday", viewingTime2.getShowDate());

        System.out.println("Finished ViewingTimeTest: testOneViewingTime\n");

    }//end testOneViewingTime

    @Test
    public void testDistinctViewingTime(){
        System.out.println("Starting ViewingTimeTest: testDistinctViewingTime");

        ViewingTime viewingTime1 = new ViewingTime("Theatre1","Movie1","1:30 to 3:30 PM", "July 8, 2020, Wednesday");
        ViewingTime viewingTime2 = new ViewingTime("Theatre2","Movie2","3:30 to 6:00 PM", "July 10, 2020, Friday");

        assertNotNull(viewingTime1);
        assertNotNull(viewingTime2);

        //viewingTime1 fields
        assertTrue("Theatre1".equals(viewingTime1.getTheatreName()));
        assertEquals("Theatre1", viewingTime1.getTheatreName());

        assertTrue("Movie1".equals(viewingTime1.getMovieName()));
        assertEquals("Movie1",viewingTime1.getMovieName());

        assertTrue("1:30 to 3:30 PM".equals(viewingTime1.getShowTime()));
        assertEquals("1:30 to 3:30 PM", viewingTime1.getShowTime());

        assertTrue("July 8, 2020, Wednesday".equals(viewingTime1.getShowDate()));
        assertEquals("July 8, 2020, Wednesday", viewingTime1.getShowDate());

        //viewingTime2 fields
        assertTrue("Theatre2".equals(viewingTime2.getTheatreName()));
        assertEquals("Theatre2", viewingTime2.getTheatreName());

        assertTrue("Movie2".equals(viewingTime2.getMovieName()));
        assertEquals("Movie2",viewingTime2.getMovieName());

        assertTrue("3:30 to 6:00 PM".equals(viewingTime2.getShowTime()));
        assertEquals("3:30 to 6:00 PM", viewingTime2.getShowTime());

        assertTrue("July 10, 2020, Friday".equals(viewingTime2.getShowDate()));
        assertEquals("July 10, 2020, Friday", viewingTime2.getShowDate());


        //comparing theatre names.
        assertFalse(viewingTime1.getTheatreName().equals(viewingTime2.getTheatreName()));
        assertNotEquals(viewingTime1.getTheatreName(),viewingTime2.getTheatreName());

        //comparing movie names.
        assertFalse(viewingTime1.getMovieName().equals(viewingTime2.getMovieName()));
        assertNotEquals(viewingTime1.getMovieName(),viewingTime2.getMovieName());

        //comparing time for both viewingtime.
        assertFalse(viewingTime1.getShowTime().equals(viewingTime2.getShowTime()));
        assertNotEquals(viewingTime1.getShowTime(),viewingTime2.getShowTime());

        //comparing viewingtimes' dates.
        assertFalse(viewingTime1.getShowDate().equals(viewingTime2.getShowDate()));
        assertNotEquals(viewingTime1.getShowDate(),viewingTime2.getShowDate());

        //objects should not be the same when using the equals method from ViewingTime.
        assertFalse(viewingTime1.equals(viewingTime2));
        assertNotEquals(viewingTime1,viewingTime2);
        System.out.println("Finished ViewingTimeTest: testDistinctViewingTime\n");

    }//end testDistinctViewingTime

    @Test
    public void testSameViewingTimes(){
        System.out.println("Starting ViewingTimeTest: testSameViewingTimes");

        ViewingTime viewingTime1 = new ViewingTime("Theatre1","Movie1","1:30 to 3:30 PM", "July 8, 2020, Wednesday");
        ViewingTime viewingTime2 = new ViewingTime("Theatre1","Movie1","1:30 to 3:30 PM", "July 8, 2020, Wednesday");

        assertNotNull(viewingTime1);
        assertNotNull(viewingTime2);

        //viewingTime1 fields
        assertTrue("Theatre1".equals(viewingTime1.getTheatreName()));
        assertEquals("Theatre1", viewingTime1.getTheatreName());

        assertTrue("Movie1".equals(viewingTime1.getMovieName()));
        assertEquals("Movie1",viewingTime1.getMovieName());

        assertTrue("1:30 to 3:30 PM".equals(viewingTime1.getShowTime()));
        assertEquals("1:30 to 3:30 PM", viewingTime1.getShowTime());

        assertTrue("July 8, 2020, Wednesday".equals(viewingTime1.getShowDate()));
        assertEquals("July 8, 2020, Wednesday", viewingTime1.getShowDate());

        //viewingTime2 fields
        assertTrue("Theatre1".equals(viewingTime2.getTheatreName()));
        assertEquals("Theatre1", viewingTime2.getTheatreName());

        assertTrue("Movie1".equals(viewingTime2.getMovieName()));
        assertEquals("Movie1",viewingTime2.getMovieName());

        assertTrue("1:30 to 3:30 PM".equals(viewingTime2.getShowTime()));
        assertEquals("1:30 to 3:30 PM", viewingTime2.getShowTime());

        assertTrue("July 8, 2020, Wednesday".equals(viewingTime2.getShowDate()));
        assertEquals("July 8, 2020, Wednesday", viewingTime2.getShowDate());


        //comparing theatre names.
        assertTrue(viewingTime1.getTheatreName().equals(viewingTime2.getTheatreName()));
        assertEquals(viewingTime1.getTheatreName(),viewingTime2.getTheatreName());

        //comparing movie names.
        assertTrue(viewingTime1.getMovieName().equals(viewingTime2.getMovieName()));
        assertEquals(viewingTime1.getMovieName(),viewingTime2.getMovieName());

        //comparing time for both viewingtime.
        assertTrue(viewingTime1.getShowTime().equals(viewingTime2.getShowTime()));
        assertEquals(viewingTime1.getShowTime(),viewingTime2.getShowTime());

        //comparing viewingtimes' dates.
        assertTrue(viewingTime1.getShowDate().equals(viewingTime2.getShowDate()));
        assertEquals(viewingTime1.getShowDate(),viewingTime2.getShowDate());

        //objects should not be the same when using the equals method from ViewingTime.
        assertTrue(viewingTime1.equals(viewingTime2));
        assertEquals(viewingTime1,viewingTime2);
        System.out.println("Finished ViewingTimeTest: testSameViewingTimes\n");

    }//end testSameViewingTimes





}//end ViewingTimeTest
