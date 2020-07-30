package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.objects.Ticket;

public class AccessTicketsTest extends TestCase{

    private static String dbName = Main.dbName;
    private  AccessTickets accessTickets;
    private List<Ticket> ticketList;
    private Ticket ticket;

    public AccessTicketsTest(String arg0){
        super(arg0);
    }


    public void setUp(){
        accessTickets = null;
        ticketList = null;
        ticket = null;
    }//end setUp

    @Test
    public void testGetValidTicket(){
        System.out.println("Starting AccessTicketsTest: testValidTicket");

        //attempt to retrieve a ticket that is in the db
        Ticket ticketResult = accessTickets.getTicket("Avengers Endgame");

        assertEquals(10.00, ticketResult.getPrice());
        assertEquals("The Avengers", ticketResult.getMovieName());

        System.out.println("Finished AccessTicketsTest: testGetValidTicket");
    }//end testGetValidTicket

    @Test
    public void testGetInvalidTicket(){
        System.out.println("Starting AccessTicketsTest: testGetInvalidTicket");

        try{
            //attempt to retrieve a ticket that is in the db
            Ticket ticketResult = accessTickets.getTicket("Avengers Endgame");
            fail("Null Pointer Exception Expected");
        }
        catch(NullPointerException exception){
        }

        System.out.println("Finished AccessTicketsTest: testGetValidTicket");
    }//end testGetInvalidTicket

    @Test
    public void testGetNullTicket(){
        System.out.println("Starting AccessTicketsTest: testGetInvalidTicket");

        try{
            //attempt to retrieve a null ticket
            Ticket ticketResult = accessTickets.getTicket(null);
            fail("Null Pointer Exception Expected");
        }
        catch(NullPointerException exception){
        }

        System.out.println("Finished AccessTicketsTest: testGetValidTicket");
    }//end testGetNullTicket

}
