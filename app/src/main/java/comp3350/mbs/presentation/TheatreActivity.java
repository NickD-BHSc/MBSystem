package comp3350.mbs.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessTheatres;
import comp3350.mbs.objects.Theatre;

public class TheatreActivity extends AppCompatActivity {

    private RecyclerView theatreRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private AccessTheatres accessTheatres;
    private List<Theatre> theatreList;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
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
                throw new Error("No list of theatres available.");
        }else{
            buildRecyclerView();
        }

    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of Theatres.
     */
    private void buildRecyclerView(){

        theatreRecyclerView = findViewById(R.id.theatreRecyclerView);

        customAdapter = new CustomAdapter(TheatreActivity.this,theatreList);
        theatreRecyclerView.setAdapter(customAdapter);

        layoutManager = new LinearLayoutManager(this);
        theatreRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView

}//end TheatreActivity class