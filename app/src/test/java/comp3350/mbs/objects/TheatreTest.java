package comp3350.mbs.objects;


import junit.framework.TestCase;

import org.junit.Test;

public class TheatreTest extends TestCase {

    public TheatreTest(String arg0){super(arg0);}

    @Test
    public void testOneTheatre(){

        System.out.println("Starting TheatreTest: testOneTheatre");
        Theatre theatre1 = new Theatre("Theatre1","Address1",null,"15km");
        assertNotNull(theatre1);
        assertTrue("Theatre1".equals(theatre1.getName()));
        assertTrue("Address1".equals(theatre1.getAddress()));
        assertNull(theatre1.getMovieList());
        assertTrue("15km".equals(theatre1.getDistance()));
        assertTrue(theatre1.equals(theatre1));


        Theatre theatre2 = new Theatre("Theatre2","Address2", null, "10km");
        assertNotNull(theatre2);
        assertTrue("Theatre2".equals(theatre2.getName()));
        assertTrue("Address2".equals(theatre2.getAddress()));
        assertNull(theatre2.getMovieList());
        assertTrue("10km".equals(theatre2.getDistance()));
        assertTrue(theatre2.equals(theatre2));

        System.out.println("Finished TheatreTest: testOneTheatre\n");


    }//end testOneTheatre

    @Test
    public void testCompareTheatres(){

        System.out.println("Starting TheatreTest: testCompareTheatres");

        Theatre theatre1 = new Theatre("Theatre1","Address1",null,"15km");
        Theatre theatre2 = new Theatre("Theatre2","Address2",null,"10km");

        assertNotNull(theatre1);
        assertNotNull(theatre2);

        //comparing theatres' names.
        assertFalse(theatre1.getName().equals(theatre2.getName()));

        //comparing theatres' address.
        assertFalse(theatre1.getAddress().equals(theatre2.getAddress()));

        //checking if movieLists are null for both theatre1 and theatre2.
        assertNull(theatre1.getMovieList());
        assertNull(theatre2.getMovieList());

        //checking if theatre1 object is the same as theatre2 object.
        assertFalse(theatre1.equals(theatre2));

        System.out.println("Finished TheatreTest: testCompareTheatres\n");


    }//end testTwoTheatres



}//end TheatreTest class

