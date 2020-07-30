package comp3350.mbs.application;

import comp3350.mbs.persistence.DataAccess;
import comp3350.mbs.persistence.DataAccessObject;
import comp3350.mbs.persistence.DataAccessStub;

public class Services {

    private static DataAccess dataAccessService = null;


    /**
     * createDataAccess - a static method that creates a database with the specified name.
     * @param dbName is the name of the database.
     * @return it will return the data stored in the database (DataAccessStub).
     */
    public static DataAccess createDataAccess(String dbName){

        if(dataAccessService == null){
            //dataAccessService = new DataAccessStub(dbName);//stub database
            dataAccessService = new DataAccessObject(dbName); //Actual database
            dataAccessService.open(Main.getDBPathName());
        }

        return dataAccessService;

    }//end createDataAccess


    /**
     * createDataAccess - a static method that creates a database with an alternate dataAccess service.
     * @param alternateDataAccessService is the alternate dataAccess that will be assigned to the field dataAccessService.
     * @return it will return the dataAccessService.
     */
    public static DataAccess createDataAccess(DataAccess alternateDataAccessService) {
        if (dataAccessService == null) {
            dataAccessService = alternateDataAccessService;
            dataAccessService.open(Main.getDBPathName());
        }
        return dataAccessService;
    }//end createDataAccess


    /**
     * getDataAccessService - a static method that returns the data stored in the given database.
     * @param dbName is the name of the database.
     * @return it will return the data stored in the given database.
     */
    public static DataAccess getDataAccessService(String dbName){

        if(dataAccessService == null){
            System.out.println("Connection to data access has not been established.");
            System.exit(1);
        }

        return dataAccessService;

    }//end DataAccessStub


    /**
     * closeDataAccess - a static method that closes the dataAccessService.
     */
    public static void closeDataAccess(){
        if(dataAccessService!=null){
            dataAccessService.close();
            dataAccessService = null;
        }

    }//end closeDataAccess


}//end Services
