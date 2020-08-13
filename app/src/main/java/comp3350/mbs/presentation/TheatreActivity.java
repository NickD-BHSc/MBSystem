package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessTheatres;
import comp3350.mbs.objects.Theatre;

public class TheatreActivity extends AppCompatActivity {

    private RecyclerView theatreRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private AccessTheatres accessTheatres;
    private List<Theatre> theatreList;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre_list);

        init();

    }//end onCreate

    /**
     * init - a method that gets the sample data from the database (located at AccessTheatres) and
     *          assign it to the field theatreList. It will then create a recycler view to display
     *          the sample data to the layout activity.
     */
    private void init(){

        accessTheatres = new AccessTheatres();
        theatreList = accessTheatres.getTheatreList();

        if(theatreList == null){
                throw new Error("No list of theatres available.");
        }else{
            buildRecyclerView();
        }

    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of Theatres.
     */
    private void buildRecyclerView(){

        theatreRecyclerView = findViewById(R.id.theatreRecyclerView);

        customAdapter = new TheatreAdapter(theatreList);
        theatreRecyclerView.setAdapter(customAdapter);

        layoutManager = new LinearLayoutManager(this);
        theatreRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView

    /**
     * TheatreAdapter class - a class that displays a list of Theatre objects in the recycler view.
     */
    private class TheatreAdapter extends CustomAdapter {

        /**
         * TheatreAdapter Constructor
         * @param itemList contains the list of theatres.
         */
        public TheatreAdapter(List itemList) {
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

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_theatre, parent, false);
            customViewHolder = new TheatreViewHolder(view);

            return customViewHolder;
        }//end CustomViewHolder

        /**
         * onBindViewHolder - a method called by the RecyclerView to display the data at the specified position.
         *          This method should update the contents of the CustomViewHolder (item) to reflect the item
         *          at the given position.
         * @param holder   is the view holder which should be updated to represent the contents of the item at the
         *                 given position in the data set.
         * @param position is the position of the item within the adapter's data set.
         */
        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

            if(super.getItemList().get(position) instanceof Theatre) {

                    final Theatre item = (Theatre) super.getItemList().get(position);//get the item using the given position.
                    TheatreViewHolder theatreViewHolder = (TheatreViewHolder)holder;

                    //set the following info about the theatre to the TextViews.
                    theatreViewHolder.theatreNameTxtView.setText(item.getName());
                    theatreViewHolder.theatreAddressTxtView.setText(item.getAddress());

                    //Moves to the MovieActivity when a theatre is selected.
                    theatreViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(TheatreActivity.this, MovieActivity.class);
                            intent.putExtra("Chosen_Theatre_Name",item.getName());
                            TheatreActivity.this.startActivity(intent);
                        }
                    });

            } else {
                throw new Error("an item from the list is expected to be a Theatre object.");
            }


        }//end onBindViewHolder

        /**
         * TheatreViewHolder class - a class that assigns the widgets from activity_theatre xml so that it
         *          could display each Theatre object from the list.
         */
        private class TheatreViewHolder extends CustomViewHolder {

            private RelativeLayout relativeLayout;//used for the a click event
            private TextView theatreNameTxtView;
            private TextView theatreAddressTxtView;

            public TheatreViewHolder(@NonNull View itemView) {
                super(itemView);
                theatreNameTxtView = itemView.findViewById(R.id.theatreNameTextView);
                theatreAddressTxtView = itemView.findViewById(R.id.theatreAddressTextView);
                relativeLayout = itemView.findViewById(R.id.theatreRelativeLayout);
            }//end constructor

        }//end TheatreViewHolder class

    }//end TheatreAdapter class

}//end TheatreActivity class