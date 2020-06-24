package comp3350.mbs.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.MovieAdapter;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.ViewingTime;

public class MovieActivity extends AppCompatActivity {

    private RecyclerView movieRecyclerView;
    private MovieAdapter movieAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Movie> movieLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        init();
        //sampleData();
        buildRecyclerView();

    }//end onCreate

    //TODO Need to save the data of the activity when going back.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("MOVIE_LIST", new ArrayList<>(movieAdapter.getListMovies()));
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        movieLists = savedInstanceState.getParcelableArrayList("MOVIE_LIST");
    }

    /**
     * buildRecyclerView - a method that builds the layout for the list of movies.
     */
    private void buildRecyclerView() {

        movieRecyclerView = findViewById(R.id.movieRecyclerView);

        movieAdapter = new MovieAdapter(movieLists);
        movieRecyclerView.setAdapter(movieAdapter);

        layoutManager = new GridLayoutManager(this,1);
        movieRecyclerView.setLayoutManager(layoutManager);


        movieAdapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(),MovieInfoActivity.class);
                intent.putExtra("Movie item", movieLists.get(position));
                startActivity(intent);
            }
        });

    }//end buildRecyclerView

    /**
     * init - a method that gets the information from the previous activity (TheatreActivity)
     * and put the information to the movieList;
     */
    private void init() {
        //getting the item info from the previous activity.
        Intent intent = getIntent();
        Theatre item = intent.getParcelableExtra("Theatre MovieLists");

        if (item != null && item.getMovieList() != null) {
            movieLists = item.getMovieList();
        } else {
            movieLists = new ArrayList<>();//empty movie lists.
        }//end if-else

    }//end addMovieInfo

    /**
     * sampleData - a method that contains a sample of movie objects added to the movieLists.
     */
    private void sampleData() {

        movieLists = new ArrayList<>();
        List<ViewingTime> viewingTimes = new ArrayList<>();

        ViewingTime vt1 = new ViewingTime("7:00 to 10:00 PM", "June 11, 2020, Tuesday", null);
        ViewingTime vt2 = new ViewingTime("1:00 to 2:00 PM", "March 25, 2020, Wednesday", null);
        ViewingTime vt3 = new ViewingTime("5:00 to 6:30 PM", "August 19, 2020, Monday", null);
        ViewingTime vt4 = new ViewingTime("7:00 to 9:00 PM", "May 11, 2020, Friday", null);
        ViewingTime vt5 = new ViewingTime("4:30 to 7:00 PM", "July 2, 2020, Sunday", null);

        //data for viewingTimes added three times.
        viewingTimes.add(vt1);
        viewingTimes.add(vt2);
        viewingTimes.add(vt3);
        viewingTimes.add(vt4);
        viewingTimes.add(vt5);
        /*
        viewingTimes.add(vt1);
        viewingTimes.add(vt2);
        viewingTimes.add(vt3);
        viewingTimes.add(vt4);
        viewingTimes.add(vt5);
        */

        String m1Summary = "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.";
        Movie m1 = new Movie("Avengers Endgame", R.drawable.avengers_endgame, m1Summary, viewingTimes, null);
        Movie m2 = new Movie("The Incredibles", R.drawable.incredibles, "movie2", viewingTimes, null);
        Movie m3 = new Movie("The Lion King", R.drawable.lion_king, "movie3", viewingTimes, null);
        Movie m4 = new Movie("Star Wars", R.drawable.starwars, "movie4", viewingTimes, null);
        Movie m5 = new Movie("Superman", R.drawable.superman, "movie5", viewingTimes, null);

        movieLists.add(m1);
        movieLists.add(m2);
        movieLists.add(m3);
        movieLists.add(m4);
        movieLists.add(m5);

    }//end sampleData


}//end MainActivity class