package comp3350.mbs.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.MovieAdapter;
import comp3350.mbs.objects.Movie;

public class MainActivity extends AppCompatActivity {

    private RecyclerView movieRecyclerView;
    private MovieAdapter movieAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Movie> movieLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sampleData();
        buildRecyclerView();

    }//end onCreate

    /**
     * buildRecyclerView - a method that builds the layout for the list of movies.
     */
    private void buildRecyclerView(){
        movieRecyclerView = findViewById(R.id.movieRecyclerView);
        movieRecyclerView.setHasFixedSize(true);

        movieAdapter = new MovieAdapter(movieLists);
        movieRecyclerView.setAdapter(movieAdapter);

        layoutManager = new LinearLayoutManager(this);
        movieRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView


    /**
     * sampleData - a method that contains a sample of movie objects added to the movieLists.
     */
    private void sampleData(){

        movieLists = new ArrayList<>();

        Movie m1 = new Movie("Avengers Endgame",R.drawable.avengers_endgame,"movie1",null,null);
        Movie m2 = new Movie("The Incredibles",R.drawable.incredibles,"movie2",null,null);
        Movie m3 = new Movie("The Lion King",R.drawable.lion_king,"movie3",null,null);
        Movie m4 = new Movie("Star Wars",R.drawable.starwars,"movie4",null,null);
        Movie m5 = new Movie("Superman",R.drawable.superman,"movie5",null,null);

        movieLists.add(m1);
        movieLists.add(m2);
        movieLists.add(m3);
        movieLists.add(m4);
        movieLists.add(m5);

    }//end sampleData



}//end MainActivity class