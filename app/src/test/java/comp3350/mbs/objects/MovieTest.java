package comp3350.mbs.objects;

import org.junit.Test;

import comp3350.mbs.R;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testOneMovie(){

        Movie movie1 = new Movie("Avengers Endgame", R.drawable.avengers_endgame, "movie1 description", null);

        System.out.println("Starting MovieTest: testOneMovie");
        assertNotNull(movie1);
        assertTrue("Avengers Endgame".equals(movie1.getTitle()));
        assertNull(movie1.getShowingTime());

        Movie movie2 = new Movie("The Incredibles", R.drawable.incredibles, "movie2 description", null);
        assertNotNull(movie2);
        assertTrue("The Incredibles".equals(movie2.getTitle()));
        assertNull(movie2.getShowingTime());

        System.out.println("Finished MovieTest: testOneMovie\n");


    }//end testOneMovie


    @Test
    public void testCompareMovies(){

        System.out.println("Starting MovieTest: testCompareMovies");

        Movie movie1 = new Movie("The Lion King", R.drawable.lion_king, "movie1 description", null);
        Movie movie2 = new Movie("Star Wars", R.drawable.starwars, "movie2 description", null);

        assertNotNull(movie1);
        assertNotNull(movie2);

        //comparing movies' names.
        assertFalse(movie1.getTitle().equals(movie2.getTitle()));
        
        //checking if showTimes are null for both movie1 and movie2.
        assertNull(movie1.getShowingTime());
        assertNull(movie2.getShowingTime());

        //checking if movie1 object is the same as movie2 object.
        assertFalse(movie1.equals(movie2));

        System.out.println("Finished TheatreTest: testCompareMovies\n");

    }//end testCompareMovies


}//end MovieTest

