package comp3350.mbs.integration;

import junit.framework.TestCase;

import java.util.List;
import comp3350.mbs.application.Services;
import comp3350.mbs.application.Main;
import comp3350.mbs.business.AccessTheatreMovies;
import comp3350.mbs.business.AccessTheatres;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;

import static org.junit.Assert.assertNotEquals;
import comp3350.mbs.business.AccessOrders;
import comp3350.mbs.objects.Order;
import comp3350.mbs.persistence.DataAccessObject;
import comp3350.mbs.persistence.DataAccessStub;

public class accessOrdersTest extends TestCase {

    public accessOrdersTest(String arg0){
        super( arg0 );
    }

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

    public void testAccessTheatreMovies(){
        List<TheatreMovies> tml;
        AccessTheatreMovies atm;
        TheatreMovies actual;

        Services.closeDataAccess();

        System.out.println("Starting Integration test for AccessTheatreMovies to persistence layer\n");

        if( true )
            Services.createDataAccess(new DataAccessStub() );
        else
            Services.createDataAccess(new DataAccessObject( Main.dbName) );

        atm = new AccessTheatreMovies();
        tml = atm.getMoviesFromTheatre("Cinema City Northgate");
        TheatreMovies expected = new TheatreMovies("Cinema City Northgate","Avengers Endgame",0,"Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.");

        assertTrue(tml.size() > 0);
        actual = tml.get(0);

        assertNotNull(actual);

        assertEquals(actual.getMovieName(), expected.getMovieName());
        assertEquals(actual.getMovieDescription(), expected.getMovieDescription());
        assertEquals(actual.getTheatreName(), expected.getTheatreName());

        //remove current TheatreMovie from list to make sure invalid case does not get added
        while(!tml.isEmpty()){
            tml.remove(0);
        }
        //make sure list is empty
        assertTrue(tml.isEmpty());
        //assert that invalid theatre name does not add anything to the list of theatre movies
        tml = atm.getMoviesFromTheatre("Non-existent theatre");
        assertTrue(tml.isEmpty());

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessTheatreMovies to persistence layer\n");
    }
    
}
