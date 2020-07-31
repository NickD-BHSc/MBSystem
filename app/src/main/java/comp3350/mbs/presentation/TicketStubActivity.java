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

        Button backToMain = findViewById(R.id.backToMainScreenView);
        backToMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(startIntent);
            }
        });
        init();
        addTicketStubInfo();
        insertOrderToTable();
    }//end onCreate

    @Override
    public void onBackPressed() {
        Toast.makeText(TicketStubActivity.this,"This order has already been completed.",Toast.LENGTH_SHORT).show();
    }

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
        order = intent.getParcelableExtra("Order");
        chosenTicketQuantityTextView.setText(Integer.toString(order.getTicketQuantity()));
        chosenMovieTitleTextView.setText(order.getMovieName());
        chosenShowTimeTextView.setText(order.getShowTime());
        chosenTheatreLocationTextView.setText(order.getTheatreName());
    }//end addTicketStubInfo

    /**
     * insertOrderToTable- inserts a new entry into the ORDERS table
     */
    private void insertOrderToTable(){
        AccessOrders accessOrders = new AccessOrders();
        accessOrders.insertNewOrder(order);
    }//end insertOrderToTable

}//end TicketStubActivity class