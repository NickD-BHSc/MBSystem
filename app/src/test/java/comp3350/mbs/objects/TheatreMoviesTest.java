package comp3350.mbs.objects;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.Test;

import comp3350.mbs.R;

public class TheatreMoviesTest extends TestCase {
    public TheatreMoviesTest(String arg0){super(arg0);}


    @Test
    public void testOneTheatreMovie(){
        System.out.println("Starting TheatreMoviesTest: testOneTheatreMovie");

        TheatreMovies theatreMovies1 = new TheatreMovies("Theatre1","Movie1", R.drawable.incredibles,"description1");
        assertNotNull(theatreMovies1);

        //theatreMovies1 fields
        assertTrue("Theatre1".equals(theatreMovies1.getTheatreName()));
        assertEquals("Theatre1",theatreMovies1.getTheatreName());

        assertTrue("Movie1".equals(theatreMovies1.getMovieName()));
        assertEquals("Movie1",theatreMovies1.getMovieName());

        assertTrue(R.drawable.incredibles == theatreMovies1.getMoviePoster());
        assertEquals(R.drawable.incredibles,theatreMovies1.getMoviePoster());

        assertTrue("description1".equals(theatreMovies1.getMovieDescription()));
        assertEquals("description1",theatreMovies1.getMovieDescription());


        System.out.println("Finished TheatreMoviesTest: testOneTheatreMovie\n");

    }//end testOneTheatreMovie


    @Test
    public void testDistinctTheatreMovies(){
        System.out.println("Starting TheatreMoviesTest: testDistinctTheatreMovies");

        TheatreMovies theatreMovies1 = new TheatreMovies("Theatre1","Movie1", R.drawable.incredibles,"description1");
        assertNotNull(theatreMovies1);

        //theatreMovies1 fields
        assertTrue("Theatre1".equals(theatreMovies1.getTheatreName()));
        assertEquals("Theatre1",theatreMovies1.getTheatreName());

        assertTrue("Movie1".equals(theatreMovies1.getMovieName()));
        assertEquals("Movie1",theatreMovies1.getMovieName());

        assertTrue(R.drawable.incredibles == theatreMovies1.getMoviePoster());
        assertEquals(R.drawable.incredibles,theatreMovies1.getMoviePoster());

        assertTrue("description1".equals(theatreMovies1.getMovieDescription()));
        assertEquals("description1",theatreMovies1.getMovieDescription());


        TheatreMovies theatreMovies2 = new TheatreMovies("Theatre2","Movie2",R.drawable.lion_king,"description2");
        assertNotNull(theatreMovies2);

        //theatreMovies2 fields
        assertTrue("Theatre2".equals(theatreMovies2.getTheatreName()));
        assertEquals("Theatre2",theatreMovies2.getTheatreName());

        assertTrue("Movie2".equals(theatreMovies2.getMovieName()));
        assertEquals("Movie2",theatreMovies2.getMovieName());

        assertTrue(R.drawable.lion_king == theatreMovies2.getMoviePoster());
        assertEquals(R.drawable.lion_king,theatreMovies2.getMoviePoster());

        assertTrue("description2".equals(theatreMovies2.getMovieDescription()));
        assertEquals("description2",theatreMovies2.getMovieDescription());

        //comparing theatre names
        assertFalse(theatreMovies1.getTheatreName().equals(theatreMovies2.getTheatreName()));
        assertNotEquals(theatreMovies1.getTheatreName(),theatreMovies2.getTheatreName());

        //comparing movie names
        assertFalse(theatreMovies1.getMovieName().equals(theatreMovies2.getMovieName()));
        assertNotEquals(theatreMovies1.getMovieName(),theatreMovies2.getMovieName());

        //comparing movie posters
        assertFalse(theatreMovies1.getMoviePoster() == theatreMovies2.getMoviePoster());
        assertNotEquals(theatreMovies1.getMoviePoster(),theatreMovies2.getMoviePoster());

        //comparing movie descriptions
        assertFalse(theatreMovies1.getMovieDescription().equals(theatreMovies2.getMovieDescription()));
        assertNotEquals(theatreMovies1.getMovieDescription(),theatreMovies2.getMovieDescription());

        assertFalse(theatreMovies1.equals(theatreMovies2));
        assertNotEquals(theatreMovies1,theatreMovies2);

        System.out.println("Finished TheatreMoviesTest: testDistinctTheatreMovies\n");

    }//end testDistinctTheatreMovies


    @Test
    public void testSameTheatreMovies(){
        System.out.println("Starting TheatreMoviesTest: testSameTheatreMovies");

        TheatreMovies theatreMovies1 = new TheatreMovies("Theatre1","Movie1", R.drawable.incredibles,"description1");
        assertNotNull(theatreMovies1);

        //theatreMovies1 fields
        assertTrue("Theatre1".equals(theatreMovies1.getTheatreName()));
        assertEquals("Theatre1",theatreMovies1.getTheatreName());

        assertTrue("Movie1".equals(theatreMovies1.getMovieName()));
        assertEquals("Movie1",theatreMovies1.getMovieName());

        assertTrue(R.drawable.incredibles == theatreMovies1.getMoviePoster());
        assertEquals(R.drawable.incredibles,theatreMovies1.getMoviePoster());

        assertTrue("description1".equals(theatreMovies1.getMovieDescription()));
        assertEquals("description1",theatreMovies1.getMovieDescription());

        TheatreMovies theatreMovies2 = new TheatreMovies("Theatre1","Movie1", R.drawable.incredibles,"description1");
        assertNotNull(theatreMovies2);

        //theatreMovies2 fields
        assertTrue("Theatre1".equals(theatreMovies2.getTheatreName()));
        assertEquals("Theatre1",theatreMovies2.getTheatreName());

        assertTrue("Movie1".equals(theatreMovies2.getMovieName()));
        assertEquals("Movie1",theatreMovies2.getMovieName());

        assertTrue(R.drawable.incredibles == theatreMovies2.getMoviePoster());
        assertEquals(R.drawable.incredibles,theatreMovies2.getMoviePoster());

        assertTrue("description1".equals(theatreMovies2.getMovieDescription()));
        assertEquals("description1",theatreMovies2.getMovieDescription());

        //comparing theatre names
        assertTrue(theatreMovies1.getTheatreName().equals(theatreMovies2.getTheatreName()));
        assertEquals(theatreMovies1.getTheatreName(),theatreMovies2.getTheatreName());

        //comparing movie names
        assertTrue(theatreMovies1.getMovieName().equals(theatreMovies2.getMovieName()));
        assertEquals(theatreMovies1.getMovieName(),theatreMovies2.getMovieName());

        //comparing movie posters
        assertTrue(theatreMovies1.getMoviePoster() == theatreMovies2.getMoviePoster());
        assertEquals(theatreMovies1.getMoviePoster(),theatreMovies2.getMoviePoster());

        //comparing movie descriptions
        assertTrue(theatreMovies1.getMovieDescription().equals(theatreMovies2.getMovieDescription()));
        assertEquals(theatreMovies1.getMovieDescription(),theatreMovies2.getMovieDescription());

        assertTrue(theatreMovies1.equals(theatreMovies2));
        assertEquals(theatreMovies1,theatreMovies2);
        System.out.println("Finished TheatreMoviesTest: testSameTheatreMovies\n");

    }//end testSameTheatreMovies


    @Test
    public void testNullTheatreMovie(){
        System.out.println("Starting TheatreMoviesTest: testNullTheatreMovie");

        TheatreMovies theatreMovies1 = new TheatreMovies(null,null);
        assertNotNull(theatreMovies1);

        //theatreMovies1 fields
        assertNull(theatreMovies1.getTheatreName());
        assertEquals(null,theatreMovies1.getTheatreName());

        assertNull(theatreMovies1.getMovieName());
        assertEquals(null,theatreMovies1.getMovieName());

        /** TODO change movie description field to null when giving theatre and movie name.
        assertNull(theatreMovies1.getMovieDescription());
        assertEquals(null,theatreMovies1.getMovieDescription());
         */
        assertTrue(-1 == theatreMovies1.getMoviePoster());
        assertEquals(-1,theatreMovies1.getMoviePoster());

        TheatreMovies theatreMovies2 = new TheatreMovies(null,null, -1,null);
        assertNotNull(theatreMovies2);

        //theatreMovie2 fields
        assertNull(theatreMovies2.getTheatreName());
        assertEquals(null,theatreMovies2.getTheatreName());

        assertNull(theatreMovies2.getMovieName());
        assertEquals(null,theatreMovies2.getMovieName());

        assertNull(theatreMovies2.getMovieDescription());
        assertEquals(null,theatreMovies2.getMovieDescription());

        assertTrue(-1 == theatreMovies2.getMoviePoster());
        assertEquals(-1,theatreMovies2.getMoviePoster());

        System.out.println("Finished TheatreMoviesTest: testNullTheatreMovie\n");

    }//end testNullTheatreMovie

}//end TheatreMoviesTest
