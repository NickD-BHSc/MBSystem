package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessTicketsTest extends TestCase{

    private static String dbName = Main.dbName;
    private  AccessTickets accessTickets;
    private List<Ticket> ticketList;
    private Ticket ticket;

    public AccessTicketsTest(String arg0){
        super(arg0);
    }//end AccessTicketsTest

    public void setUp(){
        accessTickets = null;
        ticketList = null;
        ticket = null;
    }//end setUp

    @Test
    public void testGetValidTicket(){

        Services.closeDataAccess();
        System.out.println("Starting AccessTicketsTest: testValidTicket");

        Services.createDataAccess(new DataAccessStub(dbName));
        accessTickets = new AccessTickets();

        Ticket ticketResult = accessTickets.getTicket("Avengers Endgame");

        assertEquals(10.00, ticketResult.getPrice());
        assertEquals("Avengers Endgame", ticketResult.getMovieName());

        Services.closeDataAccess();
        System.out.println("Finished AccessTicketsTest: testGetValidTicket");

    }//end testGetValidTicket

   }//end AccessTicketsTest
