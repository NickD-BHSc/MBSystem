package comp3350.mbs.objects;

import junit.framework.TestCase;

import org.junit.Test;

public class TicketTest extends TestCase {

    public TicketTest(String arg0){
        super(arg0);
    }

    @Test
    public void testTicket1(){

        System.out.println("\nStarting testTicket1");

        Ticket ticket = new Ticket(0, "Avengers Endgame");
        assertNotNull(ticket);
        assertEquals(0.0, ticket.getPrice());
        assertTrue("0.00".equals(ticket.getPriceAsString()));
        assertTrue("Avengers Endgame".equals(ticket.getMovieName()));

        System.out.println("Finished testTicket1");

    }//end testTicket1

    @Test
    public void testTicket2(){

        System.out.println("\nStarting testTicket2");

        Ticket ticket = new Ticket(5.00, "Avengers Endgame");
        assertNotNull(ticket);
        assertEquals(5.0, ticket.getPrice());
        assertTrue("5.00".equals(ticket.getPriceAsString()));
        assertTrue("Avengers Endgame".equals(ticket.getMovieName()));

        System.out.println("Finished testTicket2");

    }//end testTicket2

}//end TicketTest class
