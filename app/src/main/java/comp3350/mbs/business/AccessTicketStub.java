package comp3350.mbs.business;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.TicketStub;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.persistence.DataAccess;

public class AccessTicketStub {
    private DataAccess dataAccess;

    public AccessTicketStub()
    {
        dataAccess = Services.getDataAccessService(Main.dbName);
    }

    public TicketStub getTicketStub(ViewingTime vt){
        return dataAccess.getTicketStub(vt);
    }

}
