package comp3350.mbs.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.ParcelableFactory;
import comp3350.mbs.objects.Order;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.ViewingTime;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.CustomViewHolder> {

    private Context context;
    private List itemLists;

    /**
     * CustomAdapter Constructor
     * @param context is the context that the CustomAdapter is currently using. (i.e. MovieActivity, MovieInfoActivity or TheatreActivity etc).
     * @param itemLists is the data stored in a list which could be a list of theatres, TheatreMovies, ViewingTime etc.
     */
    public CustomAdapter(Context context, List itemLists){
        this.context = context;
        this.itemLists = itemLists;
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
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        CustomAdapter.CustomViewHolder customViewHolder;
        View view;

        if(context instanceof TheatreActivity){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_theatre,parent,false);

        }else if(context instanceof MovieActivity){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movie,parent,false);

        }else if(context instanceof MovieInfoActivity){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_viewing_time, parent, false);

        }else if(context instanceof SeatingActivity){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_seat, parent, false);

        }else if(context instanceof OrderActivity){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order, parent, false);

        }else{
            throw new Error("given context is neither Theatre, Movie, or Seating Activity.");
        }

        customViewHolder = new CustomViewHolder(view);
        return customViewHolder;

    }//end onCreateViewHolder

    /**
     * onBindViewHolder - a method called by the RecyclerView to display the data at the specified position.
     * This method should update the contents of the CustomViewHolder (item) to reflect the item
     * at the given position.
     * @param holder   is the view holder which should be updated to represent the contents of the item at the
     *                 given position in the data set.
     * @param position is the position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {
        //first is to check which context (Activity) is being used.
        if(context instanceof TheatreActivity){

            if(itemLists.get(position) instanceof Theatre){
                final Theatre item = (Theatre) itemLists.get(position);//get the item using the given position.
                //set the following info about the theatre to the TextViews.
                holder.theatreNameTxtView.setText(item.getName());
                holder.theatreAddressTxtView.setText(item.getAddress());
                holder.theatreDistTxtView.setText(item.getDistance());

                //Moves to the MovieActivity when a theatre is selected.
                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, MovieActivity.class);
                        Parcelable parcTheatre  = ParcelableFactory.createParcelableObject(item);
                        intent.putExtra("Chosen_Theatre", parcTheatre);
                        context.startActivity(intent);
                    }
                });

            }else{
                throw new Error("an item from the list is expected to be a Theatre object.");
            }

        }else if(context instanceof MovieActivity){

            if(itemLists.get(position) instanceof TheatreMovies){
                final TheatreMovies item = (TheatreMovies)itemLists.get(position); // get the item using the given position.
                //set the following info about Movie to the TextViews.
                holder.titleTxtView.setText(item.getMovieName());
                holder.movieImageView.setImageResource(item.getMoviePoster());

                //Moves to the MovieInfoActivity (activity that holds the viewing time of the movie) when a movie is selected.
                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context,MovieInfoActivity.class);
                        Parcelable parcTheatreMovie = ParcelableFactory.createParcelableObject(item);
                        intent.putExtra("Movie_Selected", parcTheatreMovie);//the item also contains the theatre name since it is a TheatreMovies object.
                        context.startActivity(intent);
                    }
                });

            }else{
                throw new Error("an item from the list is expected to be a Movie object.");
            }

        }else if(context instanceof MovieInfoActivity){

            if(itemLists.get(position) instanceof ViewingTime){
                //set the following info about the ViewingTime to the TextViews.
                final ViewingTime item = (ViewingTime)itemLists.get(position);
                holder.viewTimeTextView.setText(item.getShowTime() + "\n" + item.getShowDate());


                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context,SeatingActivity.class);
                        Parcelable parcViewingTime = ParcelableFactory.createParcelableObject(item);

                        TheatreMovies theatreMovie = ((MovieInfoActivity)context).getTheatreMovieItem();
                        Parcelable parcTheatreMovie = ParcelableFactory.createParcelableObject(theatreMovie);

                        intent.putExtra( "ViewingTime_Selected", parcViewingTime);
                        intent.putExtra("TheatreMovie_Selected", parcTheatreMovie);
                        context.startActivity(intent);
                    }
                });


            }else{
                throw new Error("an item from the list is expected to be a ViewingTime object.");
            }

        }else if(context instanceof SeatingActivity){

            if(itemLists.get(position) instanceof Seat){
                final Seat item = (Seat) itemLists.get(position);

                holder.seatNumberTextView.setText("#" + item.getSeatNumber());

                //Check to see if the seat (item) is booked or not.
                if(item.isBooked()){
                    holder.seatImageView.setImageResource(item.getSeatImage());
                    holder.relativeLayout.setClickable(false);//make the seat non-clickable since the seat is already booked!

                }else{
                    //seat is available since it is not booked yet.
                    holder.seatImageView.setImageResource(item.getSeatImage());

                    //When you click the red seat, it changes color to yellow indicating that the seat has been selected.
                    //When you click the yellow seat, it changed color to red indicating that the seat is available again.
                    holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(item.getSeatImage() == R.drawable.seat) {
                                item.setSeatImage(R.drawable.seat_selected);
                                holder.seatImageView.setImageResource(item.getSeatImage());

                                //we add the seat that has been selected to the bookedSeats from the SeatingActivity.
                                ((SeatingActivity)context).addSeat( item );

                            }else if(item.getSeatImage() == R.drawable.seat_selected){
                                item.setSeatImage(R.drawable.seat);
                                holder.seatImageView.setImageResource(item.getSeatImage());

                                //we remove the seat that has been selected to the bookedSeats from the SeatingActivity.
                                ((SeatingActivity)context).removeSeat( item );
                            }
                        }
                    });

                }

            }
        }else if(context instanceof OrderActivity){

            if(itemLists.get(position) instanceof Order){
                final Order item = (Order) itemLists.get(position);

                holder.movieNameTextView.setText(item.getMovieName());
                holder.theatreNameTextView.setText(item.getTheatreName());
                holder.showTimeTextView.setText(item.getShowTime());
                holder.showDateTextView.setText(item.getShowDate());
                holder.quantityTextView.setText("Tickets: " + Integer.toString(item.getTicketQuantity()));

            }else{
                throw new Error("an item from the list is expected to be a Order object.");
            }

        }else{
            throw new Error("given context is neither Theatre, Movie, MovieInfo, or Seating Activity.");
        }

    }//end onBindViewHolder

    /**
     * getItemCount - is a getter method for the size of the itemLists.
     * @return it will return the number of items in the itemlists.
     */
    @Override
    public int getItemCount() {
        return itemLists.size();
    }//end getItemCount

    /**
     * Class responsible for assigning the widgets depending on the given context (activity).
     */
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout relativeLayout;//layout for each activity (used for the a click event)

        //for TheatreActivity
        private TextView theatreNameTxtView;
        private TextView theatreAddressTxtView;
        private TextView theatreDistTxtView;

        //for MovieActivity
        private ImageView movieImageView;
        private TextView titleTxtView;

        //For viewing time (MovieInfoActivity)
        private TextView viewTimeTextView;

        //For SeatActivity
        private ImageView seatImageView;
        private TextView seatNumberTextView;

        //For OrderActivity
        private TextView movieNameTextView;
        private TextView theatreNameTextView;
        private TextView showTimeTextView;
        private TextView showDateTextView;
        private TextView quantityTextView;

        /**
         * CustomViewHolder Constructor - assign the widgets depending on the context.
         * @param itemView
         */
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            //assign the following widgets according to its context (activity)
            if(context instanceof TheatreActivity){
                theatreNameTxtView = itemView.findViewById(R.id.theatreNameTextView);
                theatreAddressTxtView = itemView.findViewById(R.id.theatreAddressTextView);
                theatreDistTxtView = itemView.findViewById(R.id.theatreDistTextView);
                relativeLayout = itemView.findViewById(R.id.theatreRelativeLayout);

            }else if(context instanceof MovieActivity){
                movieImageView = itemView.findViewById(R.id.moviePicImageView);
                titleTxtView = itemView.findViewById(R.id.movieTitleTxtView);
                relativeLayout = itemView.findViewById(R.id.movieRelativeLayout);


            }else if(context instanceof MovieInfoActivity){
                viewTimeTextView = itemView.findViewById(R.id.viewTimeTextView);
                relativeLayout = itemView.findViewById(R.id.viewingTimeRelativeLayout);

            }else if(context instanceof SeatingActivity){
                seatImageView = itemView.findViewById(R.id.seatImageView);
                seatNumberTextView = itemView.findViewById(R.id.seatNumTextView);
                relativeLayout = itemView.findViewById(R.id.seatRelativeLayout);

            }else if(context instanceof OrderActivity){
                movieNameTextView = itemView.findViewById(R.id.movieNametextView);
                theatreNameTextView = itemView.findViewById(R.id.theatreNameTextView);
                showTimeTextView = itemView.findViewById(R.id.showTimeTextView);
                showDateTextView = itemView.findViewById(R.id.showDateTextView);
                quantityTextView = itemView.findViewById(R.id.quantityTextView);
                //relativeLayout = itemView.findViewById(R.id.orderRelativeLayout);

            }else{
                throw new Error("given context is neither Theatre, Movie, MovieInfo, or Seating Activity.");
            }

        }//end constructor

    }//end CustomViewHolder class

}//end CustomAdapter class
