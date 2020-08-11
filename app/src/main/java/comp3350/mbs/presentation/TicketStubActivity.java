package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessOrders;
import comp3350.mbs.objects.Order;

public class TicketStubActivity extends AppCompatActivity{
    private TextView chosenMovieTitleTextView;
    private TextView chosenShowTimeTextView;
    private TextView chosenTicketQuantityTextView;
    private TextView chosenTheatreLocationTextView;

    private Order order;

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_stub);

        init();
        addTicketStubInfo();

        Button backToMain = findViewById(R.id.backToMainScreenView);
        backToMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(startIntent);
            }
        });

        Button createReviewButton = findViewById(R.id.createReviewButton);
        createReviewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), CreateReviewActivity.class);

                startIntent.putExtra("Order_Movie_Name", order.getMovieName());
                startActivity(startIntent);
            }
        });

    }//end onCreate
    
    /**
     * onBackPressed - don't let the user go back once they have submitted their order.
     */
    @Override
    public void onBackPressed(){
        Toast.makeText(TicketStubActivity.this,"This order has already been completed.",Toast.LENGTH_SHORT).show();
    }//end onBackPressed

    /**
     * init - a method that initializes the widgets
     */
    private void init(){

        chosenMovieTitleTextView = findViewById(R.id.movieTitleText);
        chosenShowTimeTextView = findViewById(R.id.showTimeText);
        chosenTicketQuantityTextView = findViewById(R.id.ticketNumberText);
        chosenTheatreLocationTextView = findViewById(R.id.theatreLocationText);
    }//end init

    /**
     * addTicketStubInfo - initializes each text view with the appropriate ticket stub information
     * including movie title, theatre location, show time, and ticket quantity
     */
    private void addTicketStubInfo(){

        Intent intent = getIntent();
        String getTheatreName = intent.getStringExtra("Order_Theatre");
        String getMovieName = intent.getStringExtra("Order_Movie");
        String getShowTime = intent.getStringExtra("Order_Show_Time");
        String getShowDate = intent.getStringExtra("Order_Show_Date");
        int getNumTickets = intent.getIntExtra("Order_Num_Tickets",0);

        order = new Order(getMovieName,getShowTime,getShowDate,getTheatreName,getNumTickets);
        chosenTicketQuantityTextView.setText(Integer.toString(order.getTicketQuantity()));
        chosenMovieTitleTextView.setText(order.getMovieName());
        chosenShowTimeTextView.setText(order.getShowTime());
        chosenTheatreLocationTextView.setText(order.getTheatreName());
    }//end addTicketStubInfo


}//end TicketStubActivity class