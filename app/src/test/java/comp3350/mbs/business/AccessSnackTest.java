
package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Snack;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessSnackTest extends TestCase{

    private static String dbName = Main.dbName;
    private  AccessSnack accessSnack;
    private Snack snack;

    public AccessSnackTest(String arg0){
        super(arg0);
    }//end AccessTicketsTest

    public void setUp(){
        accessSnack = null;
		snack = null;
    }//end setUp

    @Test
    public void testGetValidSnack(){

        Services.closeDataAccess();
        System.out.println("Starting AccessSnackTest: testValidSnack");

        Services.createDataAccess(new DataAccessStub(dbName));
        accessSnack = new AccessSnack();

        Snack snackResult = accessSnack.getSnack( );

        assertEquals(2.00, snackResult.getHotdogPrice());
        assertEquals(3.00, snackResult.getPopcornPrice());
        assertEquals(3.00, snackResult.getFriesPrice());
        assertEquals(1.00, snackResult.getDrinkPrice());
        assertEquals(5.00, snackResult.getNoodlePrice());
        assertEquals(4.00, snackResult.getChipsPrice());
        Services.closeDataAccess();
        System.out.println("Finished AccessSnackTest: testGetValidSnack");

    }//end testGetValidTicket

}//end AccessTicketsTest
