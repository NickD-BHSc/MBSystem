package comp3350.mbs.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.CustomAdapter;
import comp3350.mbs.business.AccessMovies;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Theatre;

public class MovieActivity extends AppCompatActivity {

    private RecyclerView movieRecyclerView;
    private CustomAdapter customAdapter;

    private RecyclerView.LayoutManager layoutManager;
    private List<Movie> movieLists;
    private Theatre selectedTheatre;


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
        selectedTheatre = null;
        //getting the item info from the previous activity.
        Intent intent = getIntent();
        Theatre theatreItem = intent.getParcelableExtra("Chosen_Theatre");
        AccessMovies accessMovies = new AccessMovies();
        if (theatreItem != null) {
            /* OLD VERSION
            if(theatreItem.getMovieList() != null) {
                movieLists = theatreItem.getMovieList();
            }
             */

            movieLists = accessMovies.getMovieList(theatreItem);
            selectedTheatre = theatreItem;

        }//end if

        //do nothing when there is no item retrieved.

    }//end addMovieInfo

    /**
     * getSelectedTheatre - a getter method for the field selectedTheatre.
     * @return it will return the selectedTheatre.
     */
    public Theatre getSelectedTheatre(){
        return selectedTheatre;
    }//end getSelectedTheatre



}//end MainActivity class