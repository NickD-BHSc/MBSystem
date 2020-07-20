package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.CustomAdapter;
import comp3350.mbs.business.AccessViewingTimes;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.ViewingTime;

public class MovieInfoActivity extends AppCompatActivity {

    private RecyclerView viewingTimeRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<ViewingTime> viewingTimeList;

    private ImageView moviePosterImageView;
    private TextView movieTitleTextView;
    private TextView movieDescTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        Button viewTrailerBtn = (Button) findViewById(R.id.trailerViewBtn);
        viewTrailerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), TrailerActivity.class);
                String movieTitle = movieTitleTextView.getText().toString();
                startIntent.putExtra("comp3350.mbs.presentation.TITLE", movieTitle);
                startActivity(startIntent);

            }
        });

        init();
        addMovieInfo();

        //TODO cannot use buildRecyclerView method yet when using the actual database since it has no viewing time table.
        buildRecyclerView();


    }//end onCreate


    /**
     * init - a method that initializes the widgets from the activity_movie_info which are
     * 2 textviews and 1 imageview.
     */
    private void init() {

        movieTitleTextView = findViewById(R.id.movieInfoTitleTextView);
        movieDescTextView = findViewById(R.id.movieInfoDescTextView);
        moviePosterImageView = findViewById(R.id.movieInfoPicImageView);

    }//end init

    /**
     * addMovieInfo - a method that gets the information from the previous activity (MainActivity)
     * and put the information to the assigned widgets.
     */
    private void addMovieInfo() {
        //getting the item information for list of showing time from the previous activity.
        Intent intent = getIntent();
        TheatreMovies theatreMovieItem = intent.getParcelableExtra("Movie_Selected");//movieItem has theatre's name and movie info.

        if(theatreMovieItem != null) {

            AccessViewingTimes accessViewingTimes = new AccessViewingTimes();
            viewingTimeList = accessViewingTimes.getViewingTimeList(theatreMovieItem.getTheatreName(),theatreMovieItem.getMovieName());

            movieDescTextView.setText(theatreMovieItem.getMovieDescription());
            movieTitleTextView.setText(theatreMovieItem.getMovieName());
            moviePosterImageView.setImageResource(theatreMovieItem.getMoviePoster());

        }//end if
        //do nothing when no item was retrieved.

    }//end addMovieInfo

    /**
     * buildRecyclerView - a method that builds the layout for the list of viewing time.
     */
    private void buildRecyclerView() {

        viewingTimeRecyclerView = findViewById(R.id.movieInfoRecyclerView);

        customAdapter = new CustomAdapter(MovieInfoActivity.this,viewingTimeList);
        viewingTimeRecyclerView.setAdapter(customAdapter);

        layoutManager = new LinearLayoutManager(this);
        viewingTimeRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView
    //TODO pass the theatre name and movie name to the summary page.

}//end MovieInfoActivity class