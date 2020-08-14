package comp3350.mbs.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessReviews;
import comp3350.mbs.objects.Review;

public class ReviewActivity extends AppCompatActivity {

    private RecyclerView reviewRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView noReviewsAvailable;

    private AccessReviews accessReviews;
    private List<Review> reviewList;
    private Spinner movieNameSpinner;
    private Spinner ratingSpinner;
    private String movieNameSelected;
    private String ratingSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);

        movieNameSpinner = findViewById(R.id.movieNameSpinner);
        ratingSpinner = findViewById(R.id.ratingsSpinner);
        movieNameSelected = "All Movies";
        ratingSelected = "All Ratings";


        List<String> movieNames = new ArrayList<>();
        movieNames.add("All Movies");
        movieNames.add("Avengers Endgame");
        movieNames.add("Star Wars");
        movieNames.add("The Incredibles");
        movieNames.add("Superman");
        movieNames.add("The Lion King");

        ArrayAdapter<String> movieNameAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, movieNames);
        movieNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//https://www.tutorialspoint.com/android/android_spinner_control.htm
        movieNameSpinner.setAdapter(movieNameAdapter);


        List<String> ratings = new ArrayList<>();
        ratings.add("All Ratings");
        ratings.add("5");
        ratings.add("4");
        ratings.add("3");
        ratings.add("2");
        ratings.add("1");

        ArrayAdapter<String> ratingsAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, ratings);
        ratingsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//https://www.tutorialspoint.com/android/android_spinner_control.htm
        ratingSpinner.setAdapter(ratingsAdapter);

        movieNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                movieNameSelected = parent.getItemAtPosition(position).toString();
                init();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                movieNameSelected = "All Movies";
            }
        });

        ratingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ratingSelected = parent.getItemAtPosition(position).toString();
                init();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ratingSelected = "All Ratings";
            }
        });
        init();

    }//end onCreate

    /**
     * init - a method that gets the sample data from the database (located at AccessReviews) and
     *          assign it to the field reviewList. It will then create a recycler view to display
     *          the sample data to the layout activity.
     */
    private void init(){

        accessReviews = new AccessReviews();
        reviewList = accessReviews.getReviewList(movieNameSelected, ratingSelected);
        noReviewsAvailable = findViewById(R.id.noReviewstextView);
        reviewRecyclerView = findViewById(R.id.reviewRecyclerView);


        if(reviewList == null){
            throw new Error("No list of review available.");
        }else if(reviewList.size() == 0){
            noReviewsAvailable.setVisibility(View.VISIBLE);
            reviewRecyclerView.setVisibility(View.INVISIBLE);
        }
        else{
            noReviewsAvailable.setVisibility(View.INVISIBLE);
            reviewRecyclerView.setVisibility(View.VISIBLE);
            buildRecyclerView();
        }

    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of Reviews.
     */
    private void buildRecyclerView(){

        reviewRecyclerView = findViewById(R.id.reviewRecyclerView);
        customAdapter = new ReviewActivity.ReviewAdapter(reviewList);
        reviewRecyclerView.setAdapter(customAdapter);

        layoutManager = new LinearLayoutManager(this);
        reviewRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView


    /**
     * ReviewAdapter class - a class that displays a list of Review objects in the recycler view.
     */
    private class ReviewAdapter extends CustomAdapter {

        /**
         * ReviewAdapter Constructor
         * @param itemList contains the list of Reviews.
         */
        public ReviewAdapter(List itemList) {
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

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_review, parent, false);
            customViewHolder = new ReviewViewHolder(view);

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

            if(super.getItemList().get(position) instanceof Review){
                if(holder instanceof ReviewViewHolder) {
                    final Review item = (Review) super.getItemList().get(position);
                    ReviewViewHolder reviewViewHolder = (ReviewViewHolder)holder;

                    reviewViewHolder.movieNameTextView.setText(item.getMovieName());
                    reviewViewHolder.customerNameTextView.setText("Review From: " + item.getCustomerName());
                    reviewViewHolder.ratingTextView.setText(item.getRating() + "/5");
                    reviewViewHolder.commentsTextView.setText(item.getComments());
                }

            }else{
                throw new Error("an item from the list is expected to be a Review object.");
            }

        }//end onBindViewHolder

        /**
         * ReviewViewHolder class - a class that assigns the widgets from activity_review xml so that it
         *          could display each Seat object from the list.
         */
        private class ReviewViewHolder extends CustomViewHolder {

            private TextView movieNameTextView;
            private TextView customerNameTextView;
            private TextView ratingTextView;
            private TextView commentsTextView;

            public ReviewViewHolder(@NonNull View itemView) {
                super(itemView);
                movieNameTextView = itemView.findViewById(R.id.movieNameTextView);
                customerNameTextView = itemView.findViewById(R.id.customerNameTextView);
                ratingTextView = itemView.findViewById(R.id.ratingTextView);
                commentsTextView = itemView.findViewById(R.id.commentsTextView);
            }//end constructor

        }//end ReviewViewHolder class

    }//end ReviewAdapter class
    
}//end ReviewActivity class
