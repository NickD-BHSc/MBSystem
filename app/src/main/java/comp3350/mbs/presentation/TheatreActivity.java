package comp3350.mbs.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.MovieAdapter;
import comp3350.mbs.adapter.TheatreAdapter;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.ViewingTime;

public class TheatreActivity extends AppCompatActivity {

    private RecyclerView theatreRecyclerView;
    private TheatreAdapter theatreAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Theatre> theatreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre_list);

        sampleData();
        buildRecyclerView();
    }//end onCreate

    /**
     * sampleData - a method that contains a sample of movie objects added to the movieLists.
     */
    private void sampleData() {

        List<Movie> movieLists = new ArrayList<>();
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

        viewingTimes.add(vt1);
        viewingTimes.add(vt2);
        viewingTimes.add(vt3);
        viewingTimes.add(vt4);
        viewingTimes.add(vt5);


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

        theatreList = new ArrayList<>();
        Theatre t1 = new Theatre("Theatre 1", "Address One", movieLists, "80m");
        Theatre t2 = new Theatre("Theatre 2", "Address Two", movieLists, "100m");
        Theatre t3 = new Theatre("Theatre 3", "Address Three", movieLists, "150m");
        Theatre t4 = new Theatre("Theatre 4", "Address Four", movieLists, "50m");
        Theatre t5 = new Theatre("Theatre 5", "Address Five", movieLists, "30m");
        Theatre t6 = new Theatre("Theatre 6", "Address Six", movieLists, "70m");
        Theatre t7 = new Theatre("Theatre 7", "Address Seven", movieLists, "80m");
        Theatre t8 = new Theatre("Theatre 8", "Address Eight", movieLists, "600m");
        Theatre t9 = new Theatre("Theatre 9", "Address Nine", movieLists, "300m");

        theatreList.add(t1);
        theatreList.add(t2);
        theatreList.add(t3);
        theatreList.add(t4);
        theatreList.add(t5);
        theatreList.add(t6);
        theatreList.add(t7);
        theatreList.add(t8);
        theatreList.add(t9);


    }//end sampleData


    private void buildRecyclerView() {
        theatreRecyclerView = findViewById(R.id.theatreRecyclerView);

        theatreAdapter = new TheatreAdapter(theatreList);
        theatreRecyclerView.setAdapter(theatreAdapter);

        layoutManager = new LinearLayoutManager(this);
        theatreRecyclerView.setLayoutManager(layoutManager);


        theatreAdapter.setOnItemClickListener(new TheatreAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(),MovieActivity.class);
                intent.putExtra("Theatre MovieLists", theatreList.get(position));
                startActivity(intent);

            }
        });

    }//end buildRecyclerView


}//end TheatreActivity class