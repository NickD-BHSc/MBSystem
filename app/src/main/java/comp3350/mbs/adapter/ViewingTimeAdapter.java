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

    private List<ViewingTime> viewingTimeList;

    public ViewingTimeAdapter(List<ViewingTime> viewingTimes){
        viewingTimeList = viewingTimes;
    }//end constructor

    @NonNull
    @Override
    public ViewingTimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_viewing_time,parent,false);
        ViewingTimeHolder vth = new ViewingTimeHolder(view);
        return vth;
    }//end onCreateViewHolder

    @Override
    public void onBindViewHolder(@NonNull ViewingTimeHolder holder, int position) {
        ViewingTime item = viewingTimeList.get(position);
        holder.viewTimeTextVw.setText(item.getShowTime() + "\n" + item.getShowDate());
    }//end onBindViewHolder

    @Override
    public int getItemCount() {
        return viewingTimeList.size();
    }//end getItemCount


    public static class ViewingTimeHolder extends RecyclerView.ViewHolder{
        private TextView viewTimeTextVw;
        public ViewingTimeHolder(@NonNull View itemView) {
            super(itemView);
            viewTimeTextVw = itemView.findViewById(R.id.viewTimeTextView);
        }//end ViewingTimeHolder

    }//end ViewingTimeHolder

}//end ViewingTimeAdapter
