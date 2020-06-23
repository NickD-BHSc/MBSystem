package comp3350.mbs.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.ViewingTimeAdapter;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.ViewingTime;

public class MovieInfoActivity extends AppCompatActivity {

    private RecyclerView viewingTimeRecyclerView;
    private ViewingTimeAdapter viewingTimeAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<ViewingTime> viewingTimeList;

    private ImageView moviePosterImageView;
    private TextView movieTitleTextView;
    private TextView movieDescTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        assignWidgets();
        addMovieInfo();
        buildRecyclerView();


    }//end onCreate

    /**
     * assignWidgets - a method that gets the widgets from the activity_movie_info which are
     *              2 textviews and 1 imageview.
     */
    private void assignWidgets(){

        movieTitleTextView = findViewById(R.id.movieInfoTitleTextView);
        movieDescTextView = findViewById(R.id.movieInfoDescTextView);
        moviePosterImageView = findViewById(R.id.movieInfoPicImageView);

    }//end assignWidgets

    /**
     * addMovieInfo - a method that gets the information from the previous activity (MainActivity)
     *              and put the information to the assigned widgets.
     */
    private void addMovieInfo(){
        //getting the item info from the previous activity.
        Intent intent = getIntent();
        Movie item = intent.getParcelableExtra("Movie item");

        viewingTimeList = item.getShowingTime();
        movieDescTextView.setText(item.getDescription());
        movieTitleTextView.setText(item.getTitle());
        moviePosterImageView.setImageResource(item.getPoster());
    }//end addMovieInfo

    private void buildRecyclerView(){

        viewingTimeRecyclerView = findViewById(R.id.movieInfoRecyclerView);
        viewingTimeRecyclerView.setHasFixedSize(true);


        viewingTimeAdapter = new ViewingTimeAdapter(viewingTimeList);
        viewingTimeRecyclerView.setAdapter(viewingTimeAdapter);

        layoutManager = new LinearLayoutManager(this);
        viewingTimeRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView

}//end MovieInfoActivity class