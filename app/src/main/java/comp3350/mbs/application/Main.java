package comp3350.mbs.application;

public class Main {

    public static final String dbName = "MBS";
    private static String dbPathName = "src/main/assets/db/MBS";

    public static void main(String [] args){
        startUp();
        shutDown();
        System.out.println("All done.");
    }//end main

    /**
     * startUp - a static method that creates a database with the specified name.
     */
    public static void startUp(){
        Services.createDataAccess(dbName);
    }//end startUp

    /**
     * shutDown - a static method that closes the database.
     */
    public static void shutDown(){
        Services.closeDataAccess();
    }//end shutDown

    /**
     * getDBPathName - a getter method that returns the database name.
     * @return it will either return the database name or the path name.
     */
    public static String getDBPathName(){
        if (dbPathName == null)
            return dbName;
        else
            return dbPathName;
    }//end getDbPathName

    /**
     * setDBPathName - a setter method that sets the dbPathName to the new path.
     * @param pathName is the new pathName that will be assigned to the dbPathName.
     */
    public static void setDBPathName(String pathName){
        System.out.println("Setting DB path to: " + pathName);
        dbPathName = pathName;
    }//end setDBPathName


	public static boolean isInt( String str) {
		int le = str.length( );
		int count = 0 ;
		if(	le >= 1 ) {
			for( int i = 0; i < le ; i ++ ){
				if( str.charAt( i ) >= 48 && str.charAt( i) <= 57 )  
					count ++;
			}
			if( count == le) 
				return true;
			else 
				return false;
		}
		return false;
	}
}//end Main class
