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

    private List<Movie> listMovies;
    public MovieAdapter(List<Movie> listMovies){
        this.listMovies = listMovies;
    }//end constructor


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movie,parent,false);
        MovieViewHolder mvh = new MovieViewHolder(view);
        return mvh;
    }//end onCreateViewHolder

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

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        public ImageView movieImgVw;
        public TextView titleTxtVw;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImgVw = itemView.findViewById(R.id.moviePicImageView);
            titleTxtVw = itemView.findViewById(R.id.movieTitleTxtView);

        }//end constructor

    }//end MovieViewHolder class

}//end MovieAdapter
