package comp3350.mbs.integration;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.business.AccessTheatres;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.persistence.DataAccessStub;

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

        Services.createDataAccess( new DataAccessStub() );

        at = new AccessTheatres();
        theatreList = at.getTheatreList();
        Theatre expected = new Theatre("Scotiabank Theatre", "817 St.James", "15.7km");
        actual = theatreList.get(0);

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAddress(), actual.getAddress());
        assertEquals(expected.getDistance(), actual.getDistance());

        expected = new Theatre("Scotiabank Theatre", "Some Address", "99km");
        assertEquals(expected.getName(), actual.getName());
        assertNotEquals(expected.getAddress(), actual.getAddress());
        assertNotEquals(expected.getDistance(), actual.getDistance());

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessViewingTimes to persistence layer\n");
    }
}
