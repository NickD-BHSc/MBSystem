package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import static comp3350.mbs.business.AccessTrailer.cleanString;

public class TrailerTest extends TestCase {
    private String movieTitle;

    public void setUp(){
        String movieTitle = "";
    }

    @Test
    public void testOneWordTitle(){
        movieTitle = "Movie";
        assertEquals("movie", cleanString(movieTitle));

        movieTitle = " Movie ";
        assertEquals("movie", cleanString(movieTitle));

        movieTitle = " mOvIe ";
        assertEquals("movie", cleanString(movieTitle));

        movieTitle = " MOVIE ";
        assertEquals("movie", cleanString(movieTitle));
    }

    @Test
    public void testTwoWordTitle(){
        movieTitle = "Movie Title";
        assertEquals("movietitle", cleanString(movieTitle));

        movieTitle = " Movie Title ";
        assertEquals("movietitle", cleanString(movieTitle));

        movieTitle = " MOVIE title ";
        assertEquals("movietitle", cleanString(movieTitle));

        movieTitle = " movie TITLE ";
        assertEquals("movietitle", cleanString(movieTitle));

        movieTitle = " mOvIe tITlE ";
        assertEquals("movietitle", cleanString(movieTitle));
    }

    @Test
    public void testEmptyTitle(){
        movieTitle = "";
        try {
            cleanString(movieTitle);
            fail("Expected IAE");
        } catch (IllegalArgumentException iae){
        }
    }

    @Test
    public void testNullTitle(){
        movieTitle = null;
        try {
            cleanString(movieTitle);
            fail("Expected NPE");
        } catch (NullPointerException npe){
        }
    }
}
