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
import comp3350.mbs.business.AccessViewingTimes;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.ViewingTime;

public class MovieInfoActivity extends AppCompatActivity {

    private RecyclerView viewingTimeRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ImageView moviePosterImageView;
    private TextView movieTitleTextView;
    private TextView movieDescTextView;

    private List<ViewingTime> viewingTimeList;
    private TheatreMovies theatreMovieItem;
    private String movieTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        Button viewTrailerBtn = (Button) findViewById(R.id.trailerViewBtn);
        viewTrailerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), TrailerActivity.class);
                movieTitle = movieTitleTextView.getText().toString();
                startIntent.putExtra("comp3350.mbs.presentation.TITLE", movieTitle);
                startActivity(startIntent);
            }
        });

        init();
        addMovieInfo();

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
     * addMovieInfo - a method that gets the information from the previous activity (TheatreActivity)
     *          and put the information to the assigned widgets. It will also create a recycler
     *          view to display the viewing time list.
     */
    private void addMovieInfo(){

        Intent intent = getIntent();
        //theatreMovieItem = intent.getParcelableExtra("Movie_Selected");
        String getTheatreName = intent.getStringExtra("Chosen_Theatre_Name");
        String getMovieName = intent.getStringExtra("Chosen_Movie_Name");
        int getMoviePoster = intent.getIntExtra("Movie_Poster",0);
        String getMovieDescription = intent.getStringExtra("Movie_Description");
        theatreMovieItem = new TheatreMovies(getTheatreName,getMovieName,getMoviePoster,getMovieDescription);

        if(theatreMovieItem == null){
            throw new Error("No movie selected");
        }else{

            movieTitleTextView.setText(theatreMovieItem.getMovieName());
            moviePosterImageView.setImageResource(theatreMovieItem.getMoviePoster());
            movieDescTextView.setText(theatreMovieItem.getMovieDescription());

            AccessViewingTimes accessViewingTimes = new AccessViewingTimes();
            viewingTimeList = accessViewingTimes.getViewingTimeList(theatreMovieItem.getTheatreName(),theatreMovieItem.getMovieName());

            if(viewingTimeList == null){
                throw new Error("No available viewing time for movie: " + theatreMovieItem.getMovieName());
            }else{
                buildRecyclerView();
            }
        }

    }//end addMovieInfo

    /**
     * buildRecyclerView - a method that builds the layout for the list of viewing time.
     */
    private void buildRecyclerView(){

        viewingTimeRecyclerView = findViewById(R.id.movieInfoRecyclerView);
        customAdapter = new CustomAdapter(MovieInfoActivity.this,viewingTimeList);
        viewingTimeRecyclerView.setAdapter(customAdapter);
        layoutManager = new LinearLayoutManager(this);
        viewingTimeRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView


    /**
     * getTheatreMovieItem - a getter method for theatreMovieItem.
     * @return it will return the field theatreMovieItem.
     */
    public TheatreMovies getTheatreMovieItem(){
        return theatreMovieItem;
    }//end getTheatreMovieItem

}//end MovieInfoActivity class