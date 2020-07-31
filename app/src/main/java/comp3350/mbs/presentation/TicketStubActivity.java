package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.mbs.R;
import comp3350.mbs.objects.ViewingTime;

public class TicketStubActivity extends AppCompatActivity{
    private TextView chosenMovieTitleTextView;
    private TextView chosenShowTimeTextView;
    private TextView chosenTicketQuantityTextView;
    private TextView chosenTheatreLocationTextView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_stub);

        Button backToMain = findViewById(R.id.backToMainScreenView);
        backToMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), TheatreActivity.class);
                startActivity(startIntent);
            }
        });
        init();
        addTicketStubInfo();
    }

    /**
     * init - a method that initializes the widgets
     */
    private void init() {
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
        ViewingTime vt = intent.getParcelableExtra("ViewingTime_Selected");
        int ticketQuant = intent.getIntExtra("SeatQuant", 0);
        String quantity = Integer.toString(ticketQuant);
        chosenTicketQuantityTextView.setText(quantity);
        chosenMovieTitleTextView.setText(vt.getMovieName());
        chosenShowTimeTextView.setText(vt.getShowTime());
        chosenTheatreLocationTextView.setText(vt.getTheatreName());
    }

}