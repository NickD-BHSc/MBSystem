package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessReviews;
import comp3350.mbs.business.ParcelableFactory;
import comp3350.mbs.business.ReviewValidation;
import comp3350.mbs.objects.Order;
import comp3350.mbs.objects.Review;

public class CreateReviewActivity extends AppCompatActivity {

    private TextView customerNameTextView;
    private TextView ratingTextView;
    private TextView commentsTextView;
    private TextView movieNameTextView;


    private Order order;

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_review);

        Button submitReviewButton = findViewById(R.id.submitReviewbutton);
        submitReviewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                customerNameTextView = findViewById(R.id.yourNameInput);
                ratingTextView = findViewById(R.id.ratingInput);
                commentsTextView = findViewById(R.id.commentsInput);
                String customerName = customerNameTextView.getText().toString();
                String rating = ratingTextView.getText().toString();
                String comments = commentsTextView.getText().toString();

                if(ReviewValidation.isReviewValid(customerName, rating, comments)) {
                    Review review = new Review(order.getMovieName(), customerName, rating, comments);
                    insertReviewToTable(review);
                    Intent startIntent = new Intent(getApplicationContext(), TicketStubActivity.class);
                    ParcelableOrder parcelableOrder = (ParcelableOrder) ParcelableFactory.createParcelableObject(order);
                    startIntent.putExtra("Order", parcelableOrder);
                    startActivity(startIntent);
                }
                else{
                    Toast.makeText(CreateReviewActivity.this,"Please enter info in all fields.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        init();
    }//end onCreate

    /**
     * init - a method that initializes the widgets
     */
    private void init(){

        Intent intent = getIntent();
        order = intent.getParcelableExtra("Order");
        movieNameTextView = findViewById(R.id.movieNameInput);
        movieNameTextView.setText(order.getMovieName());
    }//end init

    /**
     * insertReviewToTable- inserts a new entry into the REVIEWS table
     */
    private void insertReviewToTable(Review review){
        AccessReviews accessReviews = new AccessReviews();
        accessReviews.insertNewReview(review);
    }//end insertOrderToTable


}
