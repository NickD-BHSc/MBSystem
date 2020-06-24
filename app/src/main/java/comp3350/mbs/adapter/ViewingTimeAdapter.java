package comp3350.mbs.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.objects.ViewingTime;

public class ViewingTimeAdapter extends RecyclerView.Adapter<ViewingTimeAdapter.ViewingTimeHolder> {

    private List<ViewingTime> viewingTimeList; //data that will be displayed within the recyclerview.

    public ViewingTimeAdapter(List<ViewingTime> viewingTimes) {
        viewingTimeList = viewingTimes;
    }//end constructor


    /**
     * onCreateViewHolder - method used to display the content of the items to the assigned layout activity.
     *
     * @param parent   is the ViewGroup into which the new View will be added after it is bounded to an adapter
     *                 position.
     * @param viewType is the view type of the new View.
     * @return it will return a new ViewHolder (ViewingTimeHolder) that holds a View of the given type.
     */
    @NonNull
    @Override
    public ViewingTimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_viewing_time, parent, false);
        ViewingTimeHolder vth = new ViewingTimeHolder(view);
        return vth;
    }//end onCreateViewHolder


    /**
     * onBindViewHolder - a method called by the RecyclerView to display the data at the specified position.
     * This method should update the contents of the ViewingTimeHolder (item) to reflect the item
     * at the given position.
     *
     * @param holder   is the view holder which should be updated to represent the contents of the item at the
     *                 given position in the data set.
     * @param position is the position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewingTimeHolder holder, int position) {
        ViewingTime item = viewingTimeList.get(position);
        holder.viewTimeTextVw.setText(item.getShowTime() + "\n" + item.getShowDate());
    }//end onBindViewHolder


    /**
     * getItemCount - a getter method for viewingTimeList' size.
     *
     * @return it will return the number of items in the viewingTimeList.
     */
    @Override
    public int getItemCount() {
        return viewingTimeList.size();
    }//end getItemCount

    public List<ViewingTime> getViewingTimeList(){
        return viewingTimeList;
    }//end getViewingTimeList


    /**
     * Class responsible for assigning the widgets (TextView) from the layout activity which
     * is activity_viewing_time layout.
     */
    public class ViewingTimeHolder extends RecyclerView.ViewHolder {
        private TextView viewTimeTextVw;

        public ViewingTimeHolder(@NonNull View itemView) {
            super(itemView);
            viewTimeTextVw = itemView.findViewById(R.id.viewTimeTextView);
        }//end ViewingTimeHolder

    }//end ViewingTimeHolder

}//end ViewingTimeAdapter
