package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;
import java.util.List;
import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessSeatsTest extends TestCase {
    private static String dbName = Main.dbName;
    private AccessSeats accessSeats;
    private AccessViewingTimes accessViewingTimes;

    public AccessSeatsTest(String arg0){
        super(arg0);
    }

    public void setUp(){
        accessSeats = null;
        accessViewingTimes = null;
    }//end setUp


    @Test
    public void testValidUpdate(){
        Services.closeDataAccess();
        System.out.println("Starting AccessSeatingTest: testValidUpdate");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessSeats = new AccessSeats();
        accessViewingTimes = new AccessViewingTimes();

        List<ViewingTime> viewingTimeList = accessViewingTimes.getViewingTimeList( "Scotiabank Theatre", "Avengers Endgame" );
        ViewingTime vt = viewingTimeList.get(0);
        accessSeats.updateSeatList( vt, "11111111111111111111111111111111");

        assertEquals( vt.getSeatString(), "11111111111111111111111111111111");

        Services.closeDataAccess();
        System.out.println("Finished AccessSeatingTest: testValidUpdate");
    }//end testValidUpdate


    @Test
    public void testInvalidUpdate(){
        Services.closeDataAccess();
        System.out.println("Starting AccessSeatingTest: testInvalidUpdate");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessSeats = new AccessSeats();
        ViewingTime vt = new ViewingTime("Xtheatre", "Xmovie", "Right Now", "Today", "1234567890");

        String updateResult = accessSeats.updateSeatList(vt, "0987654321");

        assertEquals( updateResult, "Failure");

        Services.closeDataAccess();
        System.out.println("Finished AccessSeatingTest: testInvalidUpdate");
    }//end testInvalidUpdate


}//end AccessSeatsTest