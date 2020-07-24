package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessTheatresTest extends TestCase {
    private static String dbName = Main.dbName;
    private  AccessTheatres accessTheatres;
    private List<Theatre> theatreList;
    private Theatre theatre;

    public AccessTheatresTest(String arg0){super(arg0);}

    public void setUp(){
        accessTheatres = null;
        theatreList = null;
        theatre = null;
    }


    @Test
    public void testRetrieveTheatreList(){

        System.out.println("Starting AccessTheatreTest: testRetrieveTheatreList");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessTheatres = new AccessTheatres();
        theatreList = accessTheatres.getTheatreList();

        assertNotNull(theatreList);
        assertTrue(3 == theatreList.size());

        Services.closeDataAccess();
        System.out.println("Finished AccessTheatreTest: testRetrieveTheatreList\n");

    }//end testRetrieveTheatreList

    @Test
    public void testTheatresFromList(){

        Services.closeDataAccess();
        System.out.println("Starting AccessTheatreTest: testTheatresFromList");

        Services.createDataAccess(new DataAccessStub(dbName));

        accessTheatres = new AccessTheatres();
        theatreList = accessTheatres.getTheatreList();
        assertNotNull(theatreList);
        assertTrue(3 == theatreList.size());

        theatre = theatreList.get(0);//get the first theatre.
        assertNotNull(theatre);

        //theatre fields for the first theatre.
        assertTrue("Scotiabank Theatre".equals(theatre.getName()));
        assertEquals("Scotiabank Theatre",theatre.getName());

        assertTrue("817 St.James".equals(theatre.getAddress()));
        assertEquals("817 St.James",theatre.getAddress());

        assertTrue("15.7km".equals(theatre.getDistance()));
        assertEquals("15.7km",theatre.getDistance());

        theatre = theatreList.get(1); //get the second theatre
        assertNotNull(theatre);

        //theatre fields for the second theatre.
        assertTrue("Cinema City Northgate".equals(theatre.getName()));
        assertEquals("Cinema City Northgate",theatre.getName());

        assertTrue("1399 McPhillips St.".equals(theatre.getAddress()));
        assertEquals("1399 McPhillips St.",theatre.getAddress());

        assertTrue("10km".equals(theatre.getDistance()));
        assertEquals("10km",theatre.getDistance());


        theatre = theatreList.get(2); //get the third theatre
        assertNotNull(theatre);

        //theatre fields for the third theatre.
        assertTrue("Silver City St.Vital Cinemas".equals(theatre.getName()));
        assertEquals("Silver City St.Vital Cinemas",theatre.getName());

        assertTrue("160-1225 St Mary's Rd".equals(theatre.getAddress()));
        assertEquals("160-1225 St Mary's Rd",theatre.getAddress());

        assertTrue("19.8km".equals(theatre.getDistance()));
        assertEquals("19.8km",theatre.getDistance());


        Services.closeDataAccess();
        System.out.println("Finished AccessTheatreTest: testTheatresFromList\n");

    }//end testTheatresFromList

    @Test
    public void testInvalidTheatre(){


        Services.closeDataAccess();
        System.out.println("Starting AccessTheatreTest: testInvalidTheatre");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessTheatres = new AccessTheatres();
        theatreList = accessTheatres.getTheatreList();

        assertEquals(3,theatreList.size());

        try{
            theatre = theatreList.get(3);//getting the non-existing 4th theatre.
            fail("IOBE expected");
        }catch (IndexOutOfBoundsException iobe){
        }//end try-catch

        Services.closeDataAccess();
        System.out.println("Finished AccessTheatreTest: testInvalidTheatre\n");

    }//end testInvalidTheatre

}//end AccessTheatresTest
