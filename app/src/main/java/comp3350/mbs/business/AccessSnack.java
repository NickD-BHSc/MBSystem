
package comp3350.mbs.business;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Snack;
import comp3350.mbs.persistence.DataAccess;

public class AccessSnack{
    private DataAccess dataAccess;

    /**
     * AccessTickets Constructor - gets the data/service stored in the database Main.dbName.
     */
    public AccessSnack(){
//        dataAccess =  Services.getDataAccessService(Main.dbPathName);
		dataAccess = Services.createDataAccess(Main.dbName);
    }//end constructor

    /**
     * getSnack - a getter method for the snack when given a .
//     * @param  is the name of the  associated with the Snack.
     * @return it will return a Snack object that has the given movie.
     */
//    public Snack getSnack(int h, int p, int f, int d, int n, int c) {
        public Snack getSnack( ) {
            return dataAccess.getSnack();
	   }//end getSnack

}//end AccessTickets

