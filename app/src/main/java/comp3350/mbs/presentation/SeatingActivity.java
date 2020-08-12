package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessSeats;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.business.SeatEncoding;

public class SeatingActivity extends AppCompatActivity {

    private static final int SEAT_COLUMN = 8;
    private RecyclerView seatRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button seatConfirmButton;

    private AccessSeats accessSeats;
    private SeatEncoding seatEncoding;
    private List<Seat> seatingList;
    private List<Seat> bookedSeats;
    private ViewingTime viewingTime;
    private String seatString;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_list);
        init();
        buildRecyclerView();

<<<<<<< HEAD
=======


>>>>>>> 8a1c2d84ecc87bc327e771367586fc21d5ef347f
        seatConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //make sure that the user has chosen at least one seat to be able to move to the next page.
                if(bookedSeats.size() == 0){
                    Toast.makeText(SeatingActivity.this,"Please select a seat.",Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
                }else{
                    Intent intent = new Intent(SeatingActivity.this, TicketActivity.class);
=======
                }else {
//                    Intent intent = new Intent(SeatingActivity.this, TicketActivity.class);
                    addParcBookedSeats();
                    Intent intent = new Intent(SeatingActivity.this, SnackActivity.class);

                    intent.putParcelableArrayListExtra("Booked_Seats", (ArrayList<? extends Parcelable>) parcBookedSeats);
                    Parcelable parcTheatreMovie = ParcelableFactory.createParcelableObject(theatreMovie);
                    intent.putExtra("TheatreMovie_Selected", parcTheatreMovie);

                    //passing the whole list.
                    intent.putExtra("seats", bookedSeats.size());
>>>>>>> 8a1c2d84ecc87bc327e771367586fc21d5ef347f
                    accessSeats = new AccessSeats();
                    seatEncoding = new SeatEncoding();
                    seatString = seatEncoding.encodeSeatList(seatingList, bookedSeats);
                    System.out.println("Updated Seat String:"+seatString);
                    accessSeats.updateSeatList(viewingTime, seatString );

                    intent.putExtra("Chosen_Seats",bookedSeatsInfo());
                    intent.putExtra("Chosen_Num_Seats",bookedSeats.size());
                    intent.putExtra("Chosen_Theatre_Name",viewingTime.getTheatreName());
                    intent.putExtra("Chosen_Movie_Name",viewingTime.getMovieName());
                    intent.putExtra("Show_Time",viewingTime.getShowTime());
                    intent.putExtra("Show_Date",viewingTime.getShowDate());
                    startActivity(intent);
                }
            }
        });

    }//end onCreate

    /**
     * init - a method that initializes the widgets and the lists. It also creates a sample data for the seats.
     */
    private void init(){

        seatConfirmButton = findViewById(R.id.seatConfirmButton);

        Intent intent = getIntent();
        String getTheatreName = intent.getStringExtra("Chosen_Theatre_Name");
        String getMovieName = intent.getStringExtra("Chosen_Movie_Name");
        String getShowTime = intent.getStringExtra("Show_Time");
        String getShowDate = intent.getStringExtra("Show_Date");
        String getSeats = intent.getStringExtra("Seats");


        if (getTheatreName == null || getMovieName == null || getShowTime == null || getShowDate == null || getSeats == null) {
            throw new Error("No available viewing times for the chosen movie");

        } else {
            viewingTime = new ViewingTime(getTheatreName, getMovieName, getShowTime, getShowDate, getSeats);

            bookedSeats = new ArrayList<>();//list that contains the booked seats.
            accessSeats = new AccessSeats();
            seatEncoding = new SeatEncoding();

            seatString = viewingTime.getSeatString();
            seatingList = seatEncoding.decodeSeatList(viewingTime.getSeatString());//data that will be passed to the CustomAdapter.
        }

    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of seats.
     */
    private void buildRecyclerView(){

        seatRecyclerView = findViewById(R.id.seatRecyclerView);
        customAdapter = new SeatingAdapter(seatingList);
        seatRecyclerView.setAdapter(customAdapter);

        layoutManager = new GridLayoutManager(this,SEAT_COLUMN);
        seatRecyclerView.setLayoutManager(layoutManager);
    }//end buildRecyclerView

    /**
     * bookedSeatsInfo - a method that has the seat number of the chosen seats in string.
     * @return it will return the seat numbers in string.
     */
    private String bookedSeatsInfo(){

        String chosenSeats = "";
        for(int i =0; i < bookedSeats.size(); i++){
            chosenSeats += bookedSeats.get(i).getSeatNumber() + ", ";
        }

        int lastCommaPosition = chosenSeats.lastIndexOf(", "); //removes the last comma
        chosenSeats = chosenSeats.substring(0, lastCommaPosition);

        return chosenSeats;

    }//end bookedSeatsInfo

    /**
     * addSeat - a method that adds the chosen seat in the bookedSeats. (Used in SeatingAdapter)
     * @param seat is the object that is going to be added.
     */
    private void addSeat( Seat seat ){
        bookedSeats.add( seat );
    }//end addSeat

    /**
     * removeSeat - a method that removes the chosen seat in the bookedList. (Used in SeatingAdapter)
     * @param seat is the object that is going to be removed.
     */
    private void removeSeat( Seat seat ){
        bookedSeats.remove(seat);
    }//end removeSeat
    

    /**
     * SeatingAdapter class - a class that displays a list of Seat objects in the recycler view.
     */
    private class SeatingAdapter extends CustomAdapter {

        /**
         * SeatingAdapter Constructor
         * @param itemList contains the list of Seats.
         */
        public SeatingAdapter(List itemList) {
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

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_seat, parent, false);
            customViewHolder = new SeatViewHolder(view);

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

            if(super.getItemList().get(position) instanceof Seat){
                final Seat item = (Seat) super.getItemList().get(position);
                final SeatViewHolder seatViewHolder = (SeatViewHolder)holder;

                seatViewHolder.seatNumberTextView.setText("#" + item.getSeatNumber());

                //Check to see if the seat (item) is booked or not.
                if(item.isBooked()){
                    seatViewHolder.seatImageView.setImageResource(item.getSeatImage());
                    seatViewHolder.relativeLayout.setClickable(false);//make the seat non-clickable since the seat is already booked!

                }else{
                    //seat is available since it is not booked yet.
                    seatViewHolder.seatImageView.setImageResource(item.getSeatImage());

                    //When you click the red seat, it changes color to yellow indicating that the seat has been selected.
                    //When you click the yellow seat, it changed color to red indicating that the seat is available again.
                    seatViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(item.getSeatImage() == R.drawable.seat) {
                                item.setSeatImage(R.drawable.seat_selected);
                                seatViewHolder.seatImageView.setImageResource(item.getSeatImage());

                                //we add the seat that has been selected to the bookedSeats from the SeatingActivity.
                                addSeat(item);

                            }else if(item.getSeatImage() == R.drawable.seat_selected){
                                item.setSeatImage(R.drawable.seat);
                                seatViewHolder.seatImageView.setImageResource(item.getSeatImage());

                                //we remove the seat that has been selected to the bookedSeats from the SeatingActivity
                                removeSeat(item);
                            }
                        }
                    });

                }

            }else {
                throw new Error("an item from the list is expected to be a Seat object.");
            }

        }//end onBindViewHolder

        /**
         * SeatViewHolder class - a class that assigns the widgets from activity_seat xml so that it
         *          could display each Seat object from the list.
         */
        private class SeatViewHolder extends CustomViewHolder {

            private RelativeLayout relativeLayout;//used for the a click event
            private ImageView seatImageView;
            private TextView seatNumberTextView;

            public SeatViewHolder(@NonNull View itemView) {
                super(itemView);
                seatImageView = itemView.findViewById(R.id.seatImageView);
                seatNumberTextView = itemView.findViewById(R.id.seatNumTextView);
                relativeLayout = itemView.findViewById(R.id.seatRelativeLayout);
            }//end constructor

        }//end SeatViewHolder class

    }//end SeatingAdapter class

}//end SeatActivity class
