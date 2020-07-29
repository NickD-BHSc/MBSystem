package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessTicketStub;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.ViewingTime;

public class TicketStubActivity extends AppCompatActivity{

    private AccessTicketStub accessTicketStub;
    private TextView chosenMovieTitleTextView;
    private TextView chosenShowTimeTextView;
    private TextView chosenTicketQuantityTextView;
    private TextView chosenTheatreLocationTextView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_stub);
        init();
        addTicketStubInfo();
    }

    private void init() {

        chosenMovieTitleTextView = findViewById(R.id.movieTitleText);
        chosenShowTimeTextView = findViewById(R.id.showTimeText);
        chosenTicketQuantityTextView = findViewById(R.id.ticketNumberText);
        chosenTheatreLocationTextView = findViewById(R.id.theatreLocationText);

//        Intent intent = getIntent();  //getting the number of seats booked in the previous activity.
//        seatCount= intent.getIntExtra("seats", 0);
//        theatreMovie = intent.getParcelableExtra("TheatreMovie_Selected"); //get the theatreMovie so we know the price
    }//end init

    private void addTicketStubInfo(){
        Intent intent = getIntent();
        TheatreMovies movieTitle = intent.getParcelableExtra("TheatreMovie_Selected");
        String movieName  = movieTitle.getMovieName();
        ViewingTime vt = intent.getParcelableExtra("ViewingTime_Selected");
        int ticketQuant = intent.getIntExtra("SeatQuant", 0);
        //I don't need a list of ticket stubs. I only need to set table ticketstubs to the appropriate values. Not sure where to input the sql queries right now
        String quantity = Integer.toString(ticketQuant);
        chosenMovieTitleTextView.setText(movieName);
        chosenShowTimeTextView.setText(vt.getShowTime());
        chosenTicketQuantityTextView.setText(quantity);
        chosenTheatreLocationTextView.setText(vt.getTheatreName());
    }

}