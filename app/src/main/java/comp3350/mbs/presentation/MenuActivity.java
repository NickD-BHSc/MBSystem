package comp3350.mbs.presentation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import comp3350.mbs.R;
import comp3350.mbs.application.Main;

public class MenuActivity  extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        copyDatabaseToDevice();
        Main.startUp();
        setContentView(R.layout.activity_menu);

        Button buyTicketsButton = (Button) findViewById(R.id.buyTicketsButton);
        buyTicketsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), TheatreActivity.class);
                startActivity(startIntent);
            }
        });

        Button viewTicketsButton = (Button) findViewById(R.id.viewTicketsButton);
        viewTicketsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(startIntent);
            }
        });

        Button viewReviewsButton = (Button) findViewById(R.id.viewReviewsButton);
        viewReviewsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), ReviewActivity.class);
                startActivity(startIntent);
            }
        });


    }//end onCreate


    /**
     * copyDatabaseToDevice - a method that copies the database to the app.
     */
    private void copyDatabaseToDevice(){

        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try{

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++){
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);
            Main.setDBPathName(dataDirectory.toString() + "/" + Main.dbName);

        } catch (IOException ioe){
            warning(this, "Unable to access application data: " + ioe.getMessage());
        }

    }//end copyDatabaseToDevice

    /**
     * copyAssetsToDirectory - a method that copies the assets to file directory.
     *
     * @param assets    is the assets in an array of string.
     * @param directory is the file directory.
     * @throws IOException is the IOException when file is not found.
     */
    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException{

        AssetManager assetManager = getAssets();

        for (String asset : assets){
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];
            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()){
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1){
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }

    }//end copyAssetsToDirectory

    /**
     * warning - a method that shows a warning because the activity is unable to access application data.
     * @param owner is the activity that has an error/warning.
     * @param message is the message that will be shown.
     */
    public void warning(Activity owner, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(owner).create();

        alertDialog.setTitle("Warning");
        alertDialog.setMessage(message);

        alertDialog.show();
    }//end warning

}//end menuActivity