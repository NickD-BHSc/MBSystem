package comp3350.mbs.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import comp3350.mbs.R;
import comp3350.mbs.objects.Movie;

public class MovieAdapter extends RecyclerView.Adapter <MovieAdapter.MovieViewHolder>{

    private List<Movie> listMovies; //data that will be displayed within the recyclerview.
    private OnItemClickListener mListener;//needed when a movie (card view) is clicked.


    public MovieAdapter(List<Movie> listMovies){
        this.listMovies = listMovies;
    }//end constructor

    /**
     * onCreateViewHolder - method used to display the content of the items to the assigned layout activity.
     * @param parent is the ViewGroup into which the new View will be added after it is bounded to an adapter
     *               position.
     * @param viewType is the view type of the new View.
     * @return it will return a new ViewHolder (MovieViewHolder) that holds a View of the given type.
     */
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movie,parent,false);
        MovieViewHolder mvh = new MovieViewHolder(view, mListener);
        return mvh;
    }//end onCreateViewHolder

    /**
     * onBindViewHolder - a method called by the RecyclerView to display the data at the specified position.
     *                  This method should update the contents of the MovieViewHolder (item) to reflect the item
     *                  at the given position.
     * @param holder is the view holder which should be updated to represent the contents of the item at the
     *               given position in the data set.
     * @param position is the position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movieItem = listMovies.get(position); // get the item using the given position.
        holder.titleTxtVw.setText(movieItem.getTitle());
        holder.movieImgVw.setImageResource(movieItem.getPoster());

    }//end onBindViewHolder

    /**
     * getItemCount - a getter method for listMovies' size.
     * @return it will return the number of items in the listMovies.
     */
    @Override
    public int getItemCount() {
        return listMovies.size();
    }//end getItemCount

    /**
     * getListMovies - a getter method for listMovies.
     * @return it will return the field listMovies.
     */
    public List<Movie> getListMovies(){
        return listMovies;
    }//end getListMovies

    /**
     * Class responsible for assigning the widgets (ImageView and TextView) from the layout activity which
     * is activity_movie layout and assigning a click event for the card view (i.e. when a movie picture is clicked)
     */
    public class MovieViewHolder extends RecyclerView.ViewHolder{
        private ImageView movieImgVw;
        private TextView titleTxtVw;

        public MovieViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            movieImgVw = itemView.findViewById(R.id.moviePicImageView);
            titleTxtVw = itemView.findViewById(R.id.movieTitleTxtView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }//end if
                    }//end if
                }
            });

        }//end constructor

    }//end MovieViewHolder class


    //These are for the click events (When a card view is clicked, it will go to a different layout)
    public interface OnItemClickListener{
        void onItemClick(int position);
    }//end onItemClickListener

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }//end setOnItemClickListener

}//end MovieAdapter
