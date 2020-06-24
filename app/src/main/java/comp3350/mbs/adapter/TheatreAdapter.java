package comp3350.mbs.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import comp3350.mbs.R;
import comp3350.mbs.objects.Theatre;

public class TheatreAdapter extends RecyclerView.Adapter<TheatreAdapter.TheatreViewHolder> {

    private List<Theatre> theatreList; //data that will be displayed in the recyclerview.
    private TheatreAdapter.OnItemClickListener mListener;//needed when a theatre (card view) is clicked.

    public TheatreAdapter(List<Theatre> theatres){
        theatreList = theatres;
    }//end Constructor


    /**
     * onCreateViewHolder - method used to display the content of the items to the assigned layout activity.
     *
     * @param parent   is the ViewGroup into which the new View will be added after it is bounded to an adapter
     *                 position.
     * @param viewType is the view type of the new View.
     * @return it will return a new ViewHolder (TheatreViewHolder) that holds a View of the given type.
     */
    @NonNull
    @Override
    public TheatreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_theatre,parent,false);
        TheatreViewHolder tvh = new TheatreViewHolder(view, mListener);
        return tvh;
    }//end onCreateViewHolder


    /**
     * onBindViewHolder - a method called by the RecyclerView to display the data at the specified position.
     * This method should update the contents of the TheatreViewHolder (item) to reflect the item
     * at the given position.
     *
     * @param holder   is the view holder which should be updated to represent the contents of the item at the
     *                 given position in the data set.
     * @param position is the position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull TheatreViewHolder holder, int position) {
        Theatre item = theatreList.get(position);
        holder.theatreNameTxtView.setText(item.getName());
        holder.theatreAddressTxtView.setText(item.getAddress());
        holder.theatreDistTxtView.setText(item.getDistance());
    }//end onBindViewHolder


    /**
     * getItemCount - a getter method for theatreList' size.
     *
     * @return it will return the number of items in the theatreList.
     */
    @Override
    public int getItemCount() {
        return theatreList.size();
    }//end getItemCount


    /**
     * Class responsible for assigning the widgets (3 TextViews) from the layout activity which
     * is activity_theatre layout.
     */
    public class TheatreViewHolder extends RecyclerView.ViewHolder{
        private TextView theatreNameTxtView;
        private TextView theatreAddressTxtView;
        private TextView theatreDistTxtView;

        public TheatreViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            theatreNameTxtView = itemView.findViewById(R.id.theatreNameTextView);
            theatreAddressTxtView = itemView.findViewById(R.id.theatreAddressTextView);
            theatreDistTxtView = itemView.findViewById(R.id.theatreDistTextView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }//end if
                    }//end if
                }//end onClick
            });
        }//end Constructor

    }//end TheatreViewHolder Class

    //These are for the click events (When a card view is clicked, it will go to a different layout)
    public interface OnItemClickListener{
        void onItemClick(int position);
    }//end onItemClickListener

    public void setOnItemClickListener(TheatreAdapter.OnItemClickListener listener){
        mListener = listener;
    }//end setOnItemClickListener


}//end TheatreAdapter
