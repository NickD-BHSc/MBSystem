package comp3350.mbs.tests.business;


import org.junit.Test;

import comp3350.mbs.R;
import comp3350.mbs.objects.Movie;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testOneMovie(){

        Movie movie1 = new Movie("Avengers Endgame", R.drawable.avengers_endgame, "movie1 description", null, 12.50,null);

        System.out.println("Starting MovieTest: testOneMovie");
        assertNotNull(movie1);
        assertTrue("Avengers Endgame".equals(movie1.getTitle()));
        assertNull(movie1.getShowingTime());
        assertNull(movie1.getMainActors());
        assertTrue(12.50 == movie1.getPrice());

        Movie movie2 = new Movie("The Incredibles", R.drawable.incredibles, "movie2 description", null,11.50, null);
        assertNotNull(movie2);
        assertTrue("The Incredibles".equals(movie2.getTitle()));
        assertNull(movie2.getShowingTime());
        assertNull(movie2.getMainActors());
        assertTrue(11.50 == movie2.getPrice());

        System.out.println("Finished MovieTest: testOneMovie\n");


    }//end testOneMovie


    @Test
    public void testCompareMovies(){

        System.out.println("Starting MovieTest: testCompareMovies");

        Movie movie1 = new Movie("The Lion King", R.drawable.lion_king, "movie1 description", null, 9.50, null);
        Movie movie2 = new Movie("Star Wars", R.drawable.starwars, "movie2 description", null, 10.96,null);

        assertNotNull(movie1);
        assertNotNull(movie2);

        //comparing movies' names.
        assertFalse(movie1.getTitle().equals(movie2.getTitle()));

        //comparing movies' prices.
        assertFalse(movie1.getPrice() == movie2.getPrice());

        //checking if showTimes are null for both movie1 and movie2.
        assertNull(movie1.getShowingTime());
        assertNull(movie2.getShowingTime());

        //checking if movie1 object is the same as movie2 object.
        assertFalse(movie1.equals(movie2));

        System.out.println("Finished TheatreTest: testCompareMovies\n");

    }//end testCompareMovies


}//end MovieTest
