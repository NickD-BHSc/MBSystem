package comp3350.mbs.business;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessTickets {

    private DataAccessStub dataAccess;

    public AccessTickets()
    {
        dataAccess = (DataAccessStub) Services.getDataAccessService(Main.dbName);
    }

    public Ticket getTicket(String ticketType)
    {
        return dataAccess.getTicket(ticketType);
    }

}
