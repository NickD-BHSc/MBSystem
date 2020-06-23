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

        Intent intent = getIntent();
        Movie item = intent.getParcelableExtra("Movie item");

        movieTitleTextView = findViewById(R.id.movieInfoTitleTextView);
        movieDescTextView = findViewById(R.id.movieInfoDescTextView);
        moviePosterImageView = findViewById(R.id.movieInfoPicImageView);


        viewingTimeList = new ArrayList<>(item.getShowingTime());
        movieDescTextView.setText(item.getDescription());
        movieTitleTextView.setText(item.getTitle());
        moviePosterImageView.setImageResource(item.getPoster());
        buildRecyclerView();


    }//end onCreate

    private void buildRecyclerView(){

        viewingTimeRecyclerView = findViewById(R.id.movieInfoRecyclerView);
        viewingTimeRecyclerView.setHasFixedSize(true);


        viewingTimeAdapter = new ViewingTimeAdapter(viewingTimeList);
        viewingTimeRecyclerView.setAdapter(viewingTimeAdapter);

        layoutManager = new LinearLayoutManager(this);
        viewingTimeRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView

}//end MovieInfoActivity class