package comp3350.mbs.objects;

import junit.framework.TestCase;

import org.junit.Test;

public class OrderTest extends TestCase {

    public OrderTest(String arg0){
        super(arg0);
    }


    @Test
    public void testOrder1(){

        System.out.println("\nStarting testOrder1");

        Order order = new Order("Avengers Endgame", "1:30 to 3:30 PM", "July 8, 2020, Wednesday", "xTheatre", 3);
        assertNotNull(order);
        assertTrue("Avengers Endgame".equals(order.getMovieName()));
        assertTrue("1:30 to 3:30 PM".equals(order.getShowTime()));
        assertTrue("July 8, 2020, Wednesday".equals(order.getShowDate()));
        assertTrue("xTheatre".equals(order.getTheatreName()));
        assertEquals(3, order.getTicketQuantity());

        System.out.println("Finished testOrder1");

    }//end testOrder1

}
