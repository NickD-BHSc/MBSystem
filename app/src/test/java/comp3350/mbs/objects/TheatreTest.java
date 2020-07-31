package comp3350.mbs.objects;


import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.Test;

public class TheatreTest extends TestCase {

    public TheatreTest(String arg0) {
        super(arg0);
    }


    @Test
    public void testOneTheatre(){

        System.out.println("Starting TheatreTest: testOneTheatre");
        Theatre theatre1 = new Theatre("Theatre1","Address1");
        assertNotNull(theatre1);

        //theatre1 fields
        assertTrue("Theatre1".equals(theatre1.getName()));
        assertEquals("Theatre1",theatre1.getName());

        assertTrue("Address1".equals(theatre1.getAddress()));
        assertEquals("Address1",theatre1.getAddress());

        assertTrue(theatre1.equals(theatre1));
        assertEquals(theatre1, theatre1);


        Theatre theatre2 = new Theatre("Theatre2","Address2");
        assertNotNull(theatre2);

        //theatre2 fields
        assertTrue("Theatre2".equals(theatre2.getName()));
        assertEquals("Theatre2", theatre2.getName());

        assertTrue("Address2".equals(theatre2.getAddress()));
        assertEquals("Address2",theatre2.getAddress());

        assertTrue(theatre2.equals(theatre2));
        assertEquals(theatre2,theatre2);

        System.out.println("Finished TheatreTest: testOneTheatre\n");

    }//end testOneTheatre


    @Test
    public void testDistinctTheatres(){

        System.out.println("Starting TheatreTest: testDistinctTheatres");

        Theatre theatre1 = new Theatre("Theatre1","Address1");
        Theatre theatre2 = new Theatre("Theatre2","Address2");

        assertNotNull(theatre1);
        assertNotNull(theatre2);

        //theatre1 fields
        assertTrue("Theatre1".equals(theatre1.getName()));
        assertEquals("Theatre1",theatre1.getName());

        assertTrue("Address1".equals(theatre1.getAddress()));
        assertEquals("Address1",theatre1.getAddress());

        assertTrue(theatre1.equals(theatre1));
        assertEquals(theatre1, theatre1);


        //theatre2 fields
        assertTrue("Theatre2".equals(theatre2.getName()));
        assertEquals("Theatre2", theatre2.getName());

        assertTrue("Address2".equals(theatre2.getAddress()));
        assertEquals("Address2",theatre2.getAddress());

        assertTrue(theatre2.equals(theatre2));
        assertEquals(theatre2,theatre2);


        //comparing theatres' names.
        assertFalse(theatre1.getName().equals(theatre2.getName()));
        assertNotEquals(theatre1.getName(),theatre2.getName());

        //comparing theatres' address.
        assertFalse(theatre1.getAddress().equals(theatre2.getAddress()));
        assertNotEquals(theatre1.getAddress(),theatre2.getAddress());

        //checking if theatre1 object is the same as theatre2 object.
        assertFalse(theatre1.equals(theatre2));
        assertNotEquals(theatre1, theatre2);

        System.out.println("Finished TheatreTest: testDistinctTheatres\n");


    }//end testDistinctTheatres


    @Test
    public void testSameTheatres(){
        System.out.println("Starting TheatreTest: testSameTheatres");

        Theatre theatre1 = new Theatre("Theatre1","Address1");
        Theatre theatre2 = new Theatre("Theatre1","Address1");

        assertNotNull(theatre1);
        assertNotNull(theatre2);

        //theatre1 fields
        assertTrue("Theatre1".equals(theatre1.getName()));
        assertEquals("Theatre1",theatre1.getName());

        assertTrue("Address1".equals(theatre1.getAddress()));
        assertEquals("Address1",theatre1.getAddress());

        assertTrue(theatre1.equals(theatre1));
        assertEquals(theatre1, theatre1);

        //theatre2 fields
        assertTrue("Theatre1".equals(theatre2.getName()));
        assertEquals("Theatre1",theatre2.getName());

        assertTrue("Address1".equals(theatre2.getAddress()));
        assertEquals("Address1",theatre2.getAddress());

        assertTrue(theatre2.equals(theatre2));
        assertEquals(theatre2, theatre2);


        //comparing theatres' names.
        assertTrue(theatre1.getName().equals(theatre2.getName()));
        assertEquals(theatre1.getName(),theatre2.getName());

        //comparing theatres' address.
        assertTrue(theatre1.getAddress().equals(theatre2.getAddress()));
        assertEquals(theatre1.getAddress(),theatre2.getAddress());

        //checking if theatre1 object is the same as theatre2 object.
        assertTrue(theatre1.equals(theatre2));
        assertEquals(theatre1, theatre2);

        System.out.println("Finished TheatreTest: testSameTheatres\n");

    }//end testSameTheatres


    @Test
    public void testNullTheatre(){
        System.out.println("Starting TheatreTest: testNullTheatre");

        Theatre theatre = new Theatre(null,null,null);
        assertNotNull(theatre);

        assertNull(theatre.getName());
        assertEquals(null,theatre.getName());

        assertNull(theatre.getAddress());
        assertEquals(null,theatre.getAddress());

        assertNull(theatre.getDistance());
        assertEquals(null,theatre.getDistance());
        System.out.println("Finished TheatreTest: testNullTheatre\n");

    }//end testNullTheatre


}//end TheatreTest class

