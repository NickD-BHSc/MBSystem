package comp3350.mbs.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        init();
        buildRecyclerView();

    }//end onCreate


    /**
     * buildRecyclerView - a method that builds the layout for the list of movies.
     */
    private void buildRecyclerView() {

        movieRecyclerView = findViewById(R.id.movieRecyclerView);

        customAdapter = new CustomAdapter(MovieActivity.this,movieLists);
        movieRecyclerView.setAdapter(customAdapter);
        layoutManager = new GridLayoutManager(this,1);
        movieRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView

    /**
     * init - a method that gets the information from the previous activity (TheatreActivity)
     * and put the information to the movieList.
     */
    private void init() {
        //getting the item info from the previous activity.
        Intent intent = getIntent();
        Theatre theatreItem = intent.getParcelableExtra("Chosen_Theatre");
        AccessTheatreMovies accessMovies = new AccessTheatreMovies();

        if (theatreItem != null) {

            movieLists = accessMovies.getMoviesFromTheatre(theatreItem.getName());

        }//end if

        //do nothing when there is no item retrieved.

    }//end addMovieInfo



}//end MainActivity class