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
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Theatre;

public class MovieActivity extends AppCompatActivity {

    private RecyclerView movieRecyclerView;
    private CustomAdapter customAdapter;

    private RecyclerView.LayoutManager layoutManager;
    private List<Movie> movieLists;



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
        Theatre item = intent.getParcelableExtra("Theatre MovieLists");

        if (item != null) {
            if(item.getMovieList() != null) {
                movieLists = item.getMovieList();
            }

        }//end if
        //do nothing when there is no item retrieved.

    }//end addMovieInfo



}//end MainActivity class