package comp3350.mbs.application;

public class Main {

    public static final String dbName = "MBS";

    public static void main(String [] args){
        startUp();

        //CLI.java? CLI.run();
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

}//end Main class
