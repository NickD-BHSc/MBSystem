package comp3350.mbs.integration;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.business.AccessTheatres;
import comp3350.mbs.objects.Theatre;

import static org.junit.Assert.assertNotEquals;

public class AccessTheatresTest extends TestCase {

    public AccessTheatresTest(String arg0){
        super( arg0 );
    }

    @Test
    public void testAccessTheatres(){
        List<Theatre> theatreList;
        AccessTheatres at;
        Theatre actual;

        Services.closeDataAccess();

        System.out.println("Starting Integration test for AccessTheatres to persistence layer\n");

        Services.createDataAccess(Main.dbName);

        at = new AccessTheatres();
        theatreList = at.getTheatreList();
        Theatre expected = new Theatre("Scotiabank Theatre", "817 St.James", "15.7km");
        actual = theatreList.get(0);

        assertEquals(actual.getName(), expected.getName());
        assertEquals(actual.getAddress(), expected.getAddress());
        assertEquals(actual.getDistance(), expected.getDistance());

        expected = new Theatre("Scotiabank Theatre", "Some Address", "99km");
        assertEquals(actual.getName(), expected.getName());
        assertNotEquals(actual.getAddress(), expected.getAddress());
        assertNotEquals(actual.getDistance(), expected.getDistance());

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessViewingTimes to persistence layer\n");
    }
}
