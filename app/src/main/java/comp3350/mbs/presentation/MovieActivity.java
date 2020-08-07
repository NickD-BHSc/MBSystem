package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessTheatreMovies;
import comp3350.mbs.objects.TheatreMovies;

public class MovieActivity extends AppCompatActivity {

    private RecyclerView movieRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<TheatreMovies> movieLists;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        init();
    }//end onCreate

    /**
     * init - a method that gets the information from the previous activity (TheatreActivity)
     *          and put the information to the movieList. It will then create a recycler view to display
     *          the sample data to the layout activity.
     */
    private void init(){

        Intent intent = getIntent();
        String theatreName = intent.getStringExtra("Chosen_Theatre_Name");

        if (theatreName == null) {
            throw new Error("No chosen theatre");
        } else {

            AccessTheatreMovies accessMovies = new AccessTheatreMovies();
            movieLists = accessMovies.getMoviesFromTheatre(theatreName);
            if (movieLists == null) {
                throw new Error("no available movies for chosen theatre: " + theatreName);

            } else {
                buildRecyclerView();
            }
        }

    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of movies.
     */
    private void buildRecyclerView(){

        movieRecyclerView = findViewById(R.id.movieRecyclerView);

        customAdapter = new TheatreMoviesAdapter(movieLists);
        movieRecyclerView.setAdapter(customAdapter);
        layoutManager = new GridLayoutManager(this,1);
        movieRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView


    /**
     * TheatreMoviesAdapter class - a class that displays a list of TheatreMovies objects in the recycler view.
     */
    private class TheatreMoviesAdapter extends CustomAdapter {

        /**
         * TheatreMoviesAdapter Constructor
         * @param itemList contains the list of TheatreMovies.
         */
        public TheatreMoviesAdapter(List itemList) {
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

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movie,parent,false);
            customViewHolder = new TheatreMoviesViewHolder(view);

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

            if(super.getItemList().get(position) instanceof TheatreMovies) {

                    final TheatreMovies item = (TheatreMovies) super.getItemList().get(position); // get the item using the given position.
                    TheatreMoviesViewHolder movieViewHolder = (TheatreMoviesViewHolder)holder;

                    //set the following info about Movie to the TextViews.
                    movieViewHolder.titleTxtView.setText(item.getMovieName());
                    movieViewHolder.movieImageView.setImageResource(item.getMoviePoster());

                    //Moves to the MovieInfoActivity (activity that holds the viewing time of the movie) when a movie is selected.
                    movieViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MovieActivity.this, MovieInfoActivity.class);
                            intent.putExtra("Chosen_Theatre_Name",item.getTheatreName());
                            intent.putExtra("Chosen_Movie_Name",item.getMovieName());
                            intent.putExtra("Movie_Poster",item.getMoviePoster());
                            intent.putExtra("Movie_Description",item.getMovieDescription());
                            MovieActivity.this.startActivity(intent);
                        }
                    });

            } else {
                throw new Error("an item from the list is expected to be a Movie object.");
            }

        }//end onBindViewHolder

        /**
         * TheatreMoviesViewHolder class - a class that assigns the widgets from activity_movie xml so that it
         *          could display each TheatreMovies object from the list.
         */
        private class TheatreMoviesViewHolder extends CustomViewHolder {

            private RelativeLayout relativeLayout;//used for the a click event
            private ImageView movieImageView;
            private TextView titleTxtView;

            public TheatreMoviesViewHolder(@NonNull View itemView) {
                super(itemView);
                movieImageView = itemView.findViewById(R.id.moviePicImageView);
                titleTxtView = itemView.findViewById(R.id.movieTitleTxtView);
                relativeLayout = itemView.findViewById(R.id.movieRelativeLayout);
            }//end constructor

        }//end TheatreMoviesViewHolder class

    }//end TheatreMoviesAdapter class

}//end MainActivity class