package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import static comp3350.mbs.business.AccessTrailer.cleanString;

public class TrailerTest extends TestCase {
    private String movieTitle;

    public TrailerTest(String arg0){super(arg0);}


    public void setUp(){
         movieTitle = "";
    }//end setUp


    @Test
    public void testOneWordTitle(){
        System.out.println("Starting TrailerTest: testOneWordTitle");

        movieTitle = "Movie";
        assertEquals("movie", cleanString(movieTitle));

        movieTitle = " Movie ";
        assertEquals("movie", cleanString(movieTitle));

        movieTitle = " mOvIe ";
        assertEquals("movie", cleanString(movieTitle));

        movieTitle = " MOVIE ";
        assertEquals("movie", cleanString(movieTitle));
        System.out.println("Finished TrailerTest: testOneWordTitle\n");

    }//end testOneWordTitle


    @Test
    public void testTwoWordTitle(){
        System.out.println("Starting TrailerTest: testTwoWordTitle");

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
        System.out.println("Finished TrailerTest: testTwoWordTitle\n");

    }//end testTwoWordTitle


    @Test
    public void testEmptyTitle(){
        System.out.println("Starting TrailerTest: testEmptyTitle");

        movieTitle = "";
        try {
            cleanString(movieTitle);
            fail("Expected IAE");
        } catch (IllegalArgumentException iae){
        }

        System.out.println("Finished TrailerTest: testEmptyTitle\n");

    }//end testEmptyTitle


    @Test
    public void testNullTitle(){
        System.out.println("Starting TrailerTest: testNullTitle");

        movieTitle = null;
        try {
            cleanString(movieTitle);
            fail("Expected NPE");
        } catch (NullPointerException npe){
        }

        System.out.println("Finished TrailerTest: testNullTitle\n");

    }//end testNullTitle

}//end AccessTrailerTest
