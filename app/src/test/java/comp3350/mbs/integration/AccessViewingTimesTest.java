package comp3350.mbs.integration;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;
import comp3350.mbs.application.Services;
import comp3350.mbs.business.AccessViewingTimes;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessViewingTimesTest extends TestCase {

    public AccessViewingTimesTest(String arg0 ){
        super( arg0 );
    }

    @Test
    public void testAccessViewingTimes() {
        AccessViewingTimes avt;
        ViewingTime vt;
        List<ViewingTime> vtList;

        Services.closeDataAccess();

        System.out.println("Starting Integration test of AccessViewingTimes and persistence layer\n");

        Services.createDataAccess(new DataAccessStub());

        avt = new AccessViewingTimes();

        //test initial viewing time list
        vtList = avt.getViewingTimeList("Scotiabank Theatre", "Avengers Endgame");
        assertNotNull(vtList);
        vt = vtList.get(0);

        assertNotNull(vt);
        assertEquals("Scotiabank Theatre", vt.getTheatreName());
        assertEquals("Avengers Endgame", vt.getMovieName());
        assertEquals("1:00 to 4:00 PM", vt.getShowTime());
        assertEquals("June 11, 2021, Tuesday", vt.getShowDate());
        assertEquals("00000000000000000000000000000000", vt.getSeatString());

        //test seatlist update
        avt.updateSeatList(vt, "11111111111111111111111111111111");

        vtList = avt.getViewingTimeList("Scotiabank Theatre", "Avengers Endgame");
        assertNotNull(vtList);
        vt = vtList.get(0);

        //everything should be the same as before
        assertEquals("Scotiabank Theatre", vt.getTheatreName());
        assertEquals("Avengers Endgame", vt.getMovieName());
        assertEquals("1:00 to 4:00 PM", vt.getShowTime());
        assertEquals("June 11, 2021, Tuesday", vt.getShowDate());
        assertEquals("11111111111111111111111111111111", vt.getSeatString()); //but the seatlist should have changed

        //testing complete: reset viewing time
        avt.updateSeatList( vt, "00000000000000000000000000000000");

        Services.closeDataAccess();

        System.out.println( "\nFinished Integration test of AccessViewingTimes and persistence layer\n" );
    }
}
