package comp3350.mbs.persistence;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.objects.Theatre;

public class DataAccessTest extends TestCase {
    private DataAccess dataAccess;
    public DataAccessTest(String arg0){super(arg0);}

    public void setUp(){
        System.out.println("\nStarting Persistence test DataAccess (using stub)");

        // Use the following statements to run with the stub database:
        dataAccess = new DataAccessStub();
        dataAccess.open("Stub");
        // or switch to the real database:
        // dataAccess = new DataAccessObject(Main.dbName);
        // dataAccess.open(Main.getDBPathName());
        // Note the increase in test execution time.
    }

    public void tearDown() {
        System.out.println("Finished Persistence test DataAccess (using stub)");
    }

    @Test
    public void testGetTheatreList(){
        List<Theatre> theatreList;
        Theatre theatre;

        theatreList = dataAccess.getTheatreList();
        assertEquals(3,theatreList.size());

    }//end testGetTheatreList
}
