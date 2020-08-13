package comp3350.mbs.presentation;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public abstract class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.CustomViewHolder> {

    private List itemList;

    /**
     * CustomAdapter Constructor
     * @param itemList is the data stored in a list which could be a list of theatres, TheatreMovies, ViewingTime, Seats, or Order.
     */
    public CustomAdapter(List itemList){
        this.itemList = itemList;
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
    public abstract CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    /**
     * onBindViewHolder - a method called by the RecyclerView to display the data at the specified position.
     * This method should update the contents of the CustomViewHolder (item) to reflect the item
     * at the given position.
     * @param holder   is the view holder which should be updated to represent the contents of the item at the
     *                 given position in the data set.
     * @param position is the position of the item within the adapter's data set.
     */
    @Override
    public abstract void onBindViewHolder(@NonNull final CustomViewHolder holder, int position);

    /**
     * getItemCount - is a getter method for the size of the itemList.
     * @return it will return the number of items in the itemlists.
     */
    @Override
    public int getItemCount() {
        return itemList.size();
    }//end getItemCount

    /**
     * getItemLists - is a getter method for the itemList which is mainly used for Theatre,TheatreMovie,ViewingTime,Order Adapter.
     * @return it will return the field itemList.
     */
    protected List getItemList() {
        return itemList;
    }//end getItemList


    /**
     * Class responsible for assigning the widgets depending on the given context (activity).
     */
    public abstract class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
        }//end constructor

    }//end CustomViewHolder class


}//end CustomAdapter class
