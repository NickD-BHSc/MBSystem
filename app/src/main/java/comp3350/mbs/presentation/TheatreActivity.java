package comp3350.mbs.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.CustomAdapter;
import comp3350.mbs.application.Main;
import comp3350.mbs.business.AccessTheatres;
import comp3350.mbs.objects.Theatre;

public class TheatreActivity extends AppCompatActivity {

    private RecyclerView theatreRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private AccessTheatres accessTheatres;
    private List<Theatre> theatreList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        copyDatabaseToDevice();
        Main.startUp();
        setContentView(R.layout.activity_theatre_list);

       init();
    }//end onCreate

    /**
     * init - a method that gets the sample data from the database (located at AccessTheatres) and
     *          assign it to the field theatreList. It will then create a recycler view to display
     *          the sample data to the layout activity.
     */
    private void init(){
        accessTheatres = new AccessTheatres();
        theatreList = accessTheatres.getTheatreList();

        if(theatreList == null){
                throw new Error("no list of theatres available.");
        }else{
            buildRecyclerView();
        }//end if-else
    }//end init


    /**
     * buildRecyclerView - a method that builds the layout for the list of Theatres.
     */
    private void buildRecyclerView() {
        theatreRecyclerView = findViewById(R.id.theatreRecyclerView);

        customAdapter = new CustomAdapter(TheatreActivity.this,theatreList);
        theatreRecyclerView.setAdapter(customAdapter);

        layoutManager = new LinearLayoutManager(this);
        theatreRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.dbName);

        } catch (IOException ioe) {
            comp3350.mbs.presentation.Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];
            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }


}//end TheatreActivity class