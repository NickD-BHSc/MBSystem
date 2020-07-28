package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import comp3350.mbs.R;
import comp3350.mbs.objects.TicketStub;

public class TicketStubActivity extends AppCompatActivity{
    private TextView chosenMovieTitleTextView;
    private TextView chosenShowTimeTextView;
    private TextView chosenTicketQuantityTextView;
    private TextView chosenTheatreLocationTextView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_stub);
    }

    private void init() {

        chosenMovieTitleTextView = findViewById(R.id.movieTitleText);
        chosenShowTimeTextView = findViewById(R.id.showTimeText);
        chosenTicketQuantityTextView = findViewById(R.id.ticketQuantityTextView);
        chosenTheatreLocationTextView = findViewById(R.id.theatreLocationText);

//        Intent intent = getIntent();  //getting the number of seats booked in the previous activity.
//        seatCount= intent.getIntExtra("seats", 0);
//        theatreMovie = intent.getParcelableExtra("TheatreMovie_Selected"); //get the theatreMovie so we know the price
    }//end init

    private void addTicketStubInfo(){
        //I don't need a list of ticket stubs. I only need to set table ticketstubs to the appropriate values. Not sure where to input the sql queries right now
//        ArrayList<TicketStub>
//        chosenMovieTitleTextView.setText(R.id.movieTitleText);
//        chosenShowTimeTextView.setText(R.id.showTimeText);
//        chosenTicketQuantityTextView.setText(R.id.ticketQuantityTextView);
//        chosenTheatreLocationTextView.setText(R.id.theatreLocationText);
    }

}