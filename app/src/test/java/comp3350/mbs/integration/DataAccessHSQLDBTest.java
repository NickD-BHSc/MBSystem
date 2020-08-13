package comp3350.mbs.integration;

import junit.framework.TestCase;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.persistence.DataAccess;
import comp3350.mbs.persistence.DataAccessTest;

public class DataAccessHSQLDBTest extends TestCase {
    private static String dbName = Main.dbName;

    public DataAccessHSQLDBTest(String arg0)
    {
        super(arg0);
    }

    public void testDataAccess()
    {
        DataAccess dataAccess;

        Services.closeDataAccess();

        System.out.println("\nStarting Integration test DataAccess (using default DB)");

        Services.createDataAccess(dbName);
        dataAccess = Services.getDataAccessService(dbName);

        DataAccessTest.dataAccessTest(dataAccess);

        Services.closeDataAccess();

        System.out.println("Finished Integration test DataAccess (using default DB)");
    }
}
