package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessTheatreMovies;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;

public class MovieActivity extends AppCompatActivity {

    private RecyclerView movieRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<TheatreMovies> movieLists;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        init();
    }//end onCreate

    /**
     * init - a method that gets the information from the previous activity (TheatreActivity)
     *          and put the information to the movieList. It will then create a recycler view to display
     *          the sample data to the layout activity.
     */
    private void init(){

        Intent intent = getIntent();
        Theatre theatreItem = intent.getParcelableExtra("Chosen_Theatre");

        if(theatreItem == null){
            throw new Error("No chosen theatre");
        }else{
            AccessTheatreMovies accessMovies = new AccessTheatreMovies();
            movieLists = accessMovies.getMoviesFromTheatre(theatreItem.getName());
            if(movieLists == null){
                throw new Error("no available movies for chosen theatre: " + theatreItem.getName());

            }else{
                buildRecyclerView();
            }
        }

    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of movies.
     */
    private void buildRecyclerView(){

        movieRecyclerView = findViewById(R.id.movieRecyclerView);

        customAdapter = new CustomAdapter(MovieActivity.this,movieLists);
        movieRecyclerView.setAdapter(customAdapter);
        layoutManager = new GridLayoutManager(this,1);
        movieRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView

}//end MainActivity class