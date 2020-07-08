package comp3350.mbs.objects;
import org.junit.Test;

import static org.junit.Assert.*;
public class ViewingTimeTest {


    @Test
    public void testViewingTime1(){

        System.out.println("Starting ViewingTimeTest: testViewingTime1");

        ViewingTime viewingTime = new ViewingTime("1:30 to 3:30 PM", "July 8, 2020, Wednesday");

        assertNotNull(viewingTime);
        assertEquals("1:30 to 3:30 PM", viewingTime.getShowTime());
        assertEquals("July 8, 2020, Wednesday", viewingTime.getShowDate());

        System.out.println("Finished ViewingTimeTest: testViewingTime1\n");

    }//end testViewingTime1

    @Test
    public void testCompareViewingTime(){
        System.out.println("Starting ViewingTimeTest: testCompareViewingTime");

        ViewingTime viewingTime1 = new ViewingTime("1:30 to 3:30 PM", "July 8, 2020, Wednesday");
        ViewingTime viewingTime2 = new ViewingTime("3:30 to 6:00 PM", "July 10, 2020, Friday");

        assertNotNull(viewingTime1);
        assertNotNull(viewingTime2);

        assertEquals("1:30 to 3:30 PM", viewingTime1.getShowTime());
        assertEquals("3:30 to 6:00 PM", viewingTime2.getShowTime());

        //comparing time for both viewingtime.
        assertFalse(viewingTime1.getShowTime().equals(viewingTime2.getShowTime()));

        assertEquals("July 8, 2020, Wednesday", viewingTime1.getShowDate());
        assertEquals("July 10, 2020, Friday", viewingTime2.getShowDate());

        //comparing viewingtimes' dates.
        assertFalse(viewingTime1.getShowDate().equals(viewingTime2.getShowDate()));

        assertFalse(viewingTime1.equals(viewingTime2));
        assertNotEquals(viewingTime1,viewingTime2);
        System.out.println("Finished ViewingTimeTest: testCompareViewingTime\n");

    }//end testCompareViewingTime






}//end ViewingTimeTest
