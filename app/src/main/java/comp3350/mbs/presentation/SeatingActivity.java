package comp3350.mbs.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.CustomAdapter;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Ticket;

public class SeatingActivity extends AppCompatActivity {

    private static final int SEAT_COLUMN = 8;
    private RecyclerView seatRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Seat> seatingList;
    private List<Integer> bookedSeats;

    private Button seatConfirmButton;

    //Only used for debugging. (Delete later)
    private TextView showResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_list);
        init();
        buildRecyclerView();


        seatConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeatingActivity.this, TicketActivity.class);
                intent.putExtra("seats", bookedSeats.size());
                startActivity(intent);
            }
        });

    }//end onCreate

    /**
     * init - a method that initializes the widgets and the lists. It also creates a sample data for the seats.
     */
    private void init(){
        seatConfirmButton = (Button)findViewById(R.id.seatConfirmButton);
        showResultTextView = (TextView)findViewById(R.id.showResult);//delete later.

        //initialize the lists.
        seatingList = new ArrayList<>();//sample data that will be passed to the CustomAdapter.
        bookedSeats = new ArrayList<>();//list that contains the booked seats.

        //some sample data
        for(int i = 0; i < 32; i++) {
            Seat seat;
            if( i%5 != 0){
                seat = new Seat(i,false, R.drawable.seat);
            }else{
                seat = new Seat(i,true, R.drawable.seat_taken);
            }//end if-else
            seatingList.add(seat);
        }//end for loop

    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of seats.
     */
    private void buildRecyclerView(){
        seatRecyclerView = findViewById(R.id.seatRecyclerView);

        customAdapter = new CustomAdapter(SeatingActivity.this,seatingList);
        seatRecyclerView.setAdapter(customAdapter);

        //5 column
        layoutManager = new GridLayoutManager(this,SEAT_COLUMN);
        seatRecyclerView.setLayoutManager(layoutManager);
    }//end buildRecyclerView

    /**
     * addSeat - a method that adds the chosen seat in the bookedSeats.
     * @param seat is the object that is going to be added.
     */
    public void addSeat( Seat seat ){
        bookedSeats.add( seat.getSeatNumber() );
    }//end addSeat

    /**
     * removeSeat - a method that removes the chosen seat in the bookedList.
     * @param seat is the object that is going to be removed.
     */
    public void removeSeat( Seat seat ){
        bookedSeats.remove( bookedSeats.indexOf( seat.getSeatNumber() ));
    }//end removeSeat


}//end SeatActivity class