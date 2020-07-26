package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.CustomAdapter;
import comp3350.mbs.business.AccessSeats;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Seat;

public class SeatingActivity extends AppCompatActivity {

    private static final int SEAT_COLUMN = 8;
    private RecyclerView seatRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Seat> seatingList;
    private List<Seat> bookedSeats;

    private Button seatConfirmButton;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_list);
        init();
        buildRecyclerView();


        seatConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //make sure that the user has chosen at least one seat to be able to move to the next page.
//                if(bookedSeats.size() == 0){
//                    Toast.makeText(SeatingActivity.this,"Please select a seat.",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Intent intent = new Intent(SeatingActivity.this, TicketActivity.class);
//                    //passing the whole list.
//                    intent.putExtra("seats", bookedSeats.size());
//                    intent.putExtra("movie", movie);
//                    startActivity(intent);
//                }//end if-else



                if( bookedSeats.size() ==0 ){
                    Toast.makeText( SeatingActivity.this, "Please select a seat.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent( SeatingActivity.this, SnackActivity.class );
//                    intent.putExtra( "")
                    startActivity(( intent  ));
                }

            }
        });

    }//end onCreate

    /**
     * init - a method that initializes the widgets and the lists. It also creates a sample data for the seats.
     */
    private void init(){
        Intent intent = getIntent();
        movie = intent.getParcelableExtra("movie");

        seatConfirmButton = (Button)findViewById(R.id.seatConfirmButton);

        //initialize the lists.
        AccessSeats accessSeats = new AccessSeats();
        seatingList = accessSeats.getSeatList();//data that will be passed to the CustomAdapter.

        bookedSeats = new ArrayList<>();//list that contains the booked seats.

    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of seats.
     */
    private void buildRecyclerView(){
        seatRecyclerView = findViewById(R.id.seatRecyclerView);

        customAdapter = new CustomAdapter(SeatingActivity.this,seatingList,movie);
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
        bookedSeats.add( seat );
    }//end addSeat

    /**
     * removeSeat - a method that removes the chosen seat in the bookedList.
     * @param seat is the object that is going to be removed.
     */
    public void removeSeat( Seat seat ){
        bookedSeats.remove(seat);
    }//end removeSeat


}//end SeatActivity class