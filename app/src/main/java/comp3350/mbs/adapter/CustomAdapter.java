package comp3350.mbs.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.presentation.MovieActivity;
import comp3350.mbs.presentation.MovieInfoActivity;
import comp3350.mbs.presentation.SeatingActivity;
import comp3350.mbs.presentation.TheatreActivity;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.CustomViewHolder> {

    private Context context;
    private List itemLists;

    /**
     * Constructor
     * @param context is the context that the CustomAdapter is currently using. (i.e. MovieActivity, MovieInfoActivity or TheatreActivity).
     * @param itemLists is the data stored in a list which could be a list of theatres, movies or viewing time.
     */
    public CustomAdapter(Context context, List itemLists) {
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
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CustomAdapter.CustomViewHolder cvh = null;
        View view = null;

        //get the layout activity depending on the type of the context.
        if(context instanceof TheatreActivity){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_theatre,parent,false);

        }else if(context instanceof MovieActivity){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movie,parent,false);

        }else if(context instanceof MovieInfoActivity) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_viewing_time, parent, false);

        }else{
            throw new Error("given context is neither Theatre, Movie, or MovieInfo Activity.");
        }//end if-else
        cvh = new CustomViewHolder(view);

        return cvh;

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
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        //first is to check which context (Activity) is being used.
        if(context instanceof TheatreActivity){

            if(itemLists.get(position) instanceof Theatre){
                final Theatre item = (Theatre) itemLists.get(position);//get the item using the given position.
                //set the following info about the theatre to the textviews
                holder.theatreNameTxtView.setText(item.getName());
                holder.theatreAddressTxtView.setText(item.getAddress());
                holder.theatreDistTxtView.setText(item.getDistance());

                //Moves to the MovieActivity when a theatre is selected.
                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, MovieActivity.class);
                        intent.putExtra("Theatre MovieLists", item);
                        context.startActivity(intent);
                    }
                });
            }else{
                throw new Error("an item from the list is expected to be a Theatre object.");
            }//end nested if-else

        }else if(context instanceof MovieActivity){

            if(itemLists.get(position) instanceof Movie){
                final Movie item = (Movie)itemLists.get(position); // get the item using the given position.
                //set the following info about Movie to the textviews
                holder.titleTxtVw.setText(item.getTitle());
                holder.movieImgVw.setImageResource(item.getPoster());

                //Moves to the MovieInfoActivity (activity that holds the viewing time of the movie) when a movie is selected.
                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context,MovieInfoActivity.class);
                        intent.putExtra("Movie item", item);
                        context.startActivity(intent);
                    }
                });
            }else{
                throw new Error("an item from the list is expected to be a Movie object.");
            }//end nested if-else

        }else if(context instanceof MovieInfoActivity){

            if(itemLists.get(position) instanceof ViewingTime){
                final ViewingTime item = (ViewingTime)itemLists.get(position);
                holder.viewTimeTextVw.setText(item.getShowTime() + "\n" + item.getShowDate());

                //TODO There should be a new activity here when a show time is selected (activity for Interface 4 where it shows the seats).


                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO start a new activity here

                        Intent intent = new Intent(context,SeatingActivity.class);
                        intent.putExtra("seats", item);
                        context.startActivity(intent);
                    }
                });


            }else{
                throw new Error("an item from the list is expected to be a ViewingTime object.");
            }//end nested if-else

        }else{
            throw new Error("given context is neither Theatre, Movie, or MovieInfo Activity.");
        }//end if-else


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
        private ImageView movieImgVw;
        private TextView titleTxtVw;

        //For viewing time
        private TextView viewTimeTextVw;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            //assign the following widgets according to its context (activity)
            if(context instanceof TheatreActivity){
                theatreNameTxtView = itemView.findViewById(R.id.theatreNameTextView);
                theatreAddressTxtView = itemView.findViewById(R.id.theatreAddressTextView);
                theatreDistTxtView = itemView.findViewById(R.id.theatreDistTextView);
                relativeLayout = itemView.findViewById(R.id.theatreRelativeLayout);

            }else if(context instanceof MovieActivity){
                movieImgVw = itemView.findViewById(R.id.moviePicImageView);
                titleTxtVw = itemView.findViewById(R.id.movieTitleTxtView);
                relativeLayout = itemView.findViewById(R.id.movieRelativeLayout);


            }else if(context instanceof MovieInfoActivity){
                viewTimeTextVw = itemView.findViewById(R.id.viewTimeTextView);
                relativeLayout = itemView.findViewById(R.id.viewingTimeRelativeLayout);
            }else{
                throw new Error("given context is neither Theatre, Movie, or MovieInfo Activity.");
            }//end if-else


        }//end constructor
    }//end CustomViewHolder class
}//end CustomAdapter class