package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

        Button viewTrailerBtn = findViewById(R.id.trailerViewBtn);
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

        String getTheatreName = intent.getStringExtra("Chosen_Theatre_Name");
        String getMovieName = intent.getStringExtra("Chosen_Movie_Name");
        int getMoviePoster = intent.getIntExtra("Movie_Poster",0);
        String getMovieDescription = intent.getStringExtra("Movie_Description");

        if(getTheatreName == null || getMovieName == null || getMovieDescription == null){
            throw new Error("No movie selected");
        }else{
            theatreMovieItem = new TheatreMovies(getTheatreName,getMovieName,getMoviePoster,getMovieDescription);
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
        customAdapter = new ViewingTimeAdapter(viewingTimeList);
        viewingTimeRecyclerView.setAdapter(customAdapter);
        layoutManager = new LinearLayoutManager(this);
        viewingTimeRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView

    /**
     * ViewingTimeAdapter class - a class that displays a list of ViewingTime objects in the recycler view.
     */
    private class ViewingTimeAdapter extends CustomAdapter {

        /**
         * ViewingTimeAdapter Constructor
         * @param itemList contains the list of ViewingTime.
         */
        public ViewingTimeAdapter(List itemList) {
            super(itemList);
        }//end constructor

        /**
         * onCreateViewHolder - method used to display the content of the items to the assigned layout activity.
         * @param parent   is the ViewGroup into which the new View will be added after it is bounded to an adapter
         *                 position.
         * @param viewType is the view type of the new View.
         * @return it will return a new ViewHolder (CustomViewHolder) that holds a View of the given type.
         */
        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            CustomViewHolder customViewHolder;
            View view;

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_viewing_time, parent, false);
            customViewHolder = new ViewingTimeHolder(view);

            return customViewHolder;
        }//end CustomViewHolder

        /**
         * onBindViewHolder - a method called by the RecyclerView to display the data at the specified position.
         * This method should update the contents of the CustomViewHolder (item) to reflect the item
         * at the given position.
         * @param holder   is the view holder which should be updated to represent the contents of the item at the
         *                 given position in the data set.
         * @param position is the position of the item within the adapter's data set.
         */
        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

            if(super.getItemList().get(position) instanceof ViewingTime) {

                    final ViewingTime item = (ViewingTime)super.getItemList().get(position);
                    ViewingTimeHolder viewingTimeHolder = (ViewingTimeHolder)holder;

                    viewingTimeHolder.viewTimeTextView.setText(item.getShowTime() + "\n" + item.getShowDate());

                    viewingTimeHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MovieInfoActivity.this,SeatingActivity.class);
                            intent.putExtra("Chosen_Theatre_Name",item.getTheatreName());
                            intent.putExtra("Chosen_Movie_Name",item.getMovieName());
                            intent.putExtra("Show_Time",item.getShowTime());
                            intent.putExtra("Show_Date",item.getShowDate());
                            intent.putExtra("Seats",item.getSeatString());
                            startActivity(intent);
                        }
                    });

            } else {
                throw new Error("an item from the list is expected to be a ViewingTime object.");
            }

        }//end onBindViewHolder

        /**
         * ViewingTimeHolder class -  a class that assigns the widgets from activity_viewing_time xml so that it
         *          could display each ViewingTime object from the list.
         */
        private class ViewingTimeHolder extends CustomViewHolder {

            private RelativeLayout relativeLayout;//used for the a click event
            private TextView viewTimeTextView;

            public ViewingTimeHolder(@NonNull View itemView) {
                super(itemView);
                viewTimeTextView = itemView.findViewById(R.id.viewTimeTextView);
                relativeLayout = itemView.findViewById(R.id.viewingTimeRelativeLayout);
            }//end constructor

        }//end ViewingTimeHolder class

    }//end ViewingTimeAdapter class

}//end MovieInfoActivity class