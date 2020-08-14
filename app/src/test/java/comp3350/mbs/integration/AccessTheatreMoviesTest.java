package comp3350.mbs.integration;

import junit.framework.TestCase;

import java.util.List;

import comp3350.mbs.application.Services;
import comp3350.mbs.business.AccessTheatreMovies;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessTheatreMoviesTest extends TestCase{

    public AccessTheatreMoviesTest(String arg0){
        super( arg0 );
    }

    public void testAccessTheatreMovies(){
        List<TheatreMovies> tml;
        AccessTheatreMovies atm;
        TheatreMovies actual;

        Services.closeDataAccess();

        System.out.println("Starting Integration test for AccessTheatreMovies to persistence layer\n");

        Services.createDataAccess(new DataAccessStub() );

        //create new accessTheatreMovie, theatreMovies list, theatreMovie object
        atm = new comp3350.mbs.business.AccessTheatreMovies();
        tml = atm.getMoviesFromTheatre("Cinema City Northgate");
        TheatreMovies expected = new TheatreMovies("Cinema City Northgate","Avengers Endgame",0,"Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.");

        assertTrue(tml.size() > 0);
        actual = tml.get(0);
        assertNotNull(actual);

        assertEquals(expected.getMovieName(), actual.getMovieName());
        assertEquals(expected.getMovieDescription(), actual.getMovieDescription());
        assertEquals(expected.getTheatreName(), actual.getTheatreName());

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
