package comp3350.mbs.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessOrders;
import comp3350.mbs.objects.Order;

public class OrderActivity extends AppCompatActivity {

    private RecyclerView orderRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView noOrdersAvailable;

    private AccessOrders accessOrders;
    private List<Order> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        init();

    }//end onCreate

    /**
     * init - a method that gets the sample data from the database (located at AccessTheatres) and
     *          assign it to the field theatreList. It will then create a recycler view to display
     *          the sample data to the layout activity.
     */
    private void init(){

        accessOrders = new AccessOrders();
        orderList = accessOrders.getOrderList();

        if(orderList == null){
            throw new Error("No list of orders available.");
        }else if(orderList.size() == 0){
            noOrdersAvailable = findViewById(R.id.noOrderstextView);
            noOrdersAvailable.setVisibility(View.VISIBLE);
        }
        else{
            noOrdersAvailable = findViewById(R.id.noOrderstextView);
            noOrdersAvailable.setVisibility(View.INVISIBLE);
            buildRecyclerView();
        }

    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of Orders.
     */
    private void buildRecyclerView(){

        orderRecyclerView = findViewById(R.id.orderRecyclerView);

        customAdapter = new OrderAdapter( orderList);
        orderRecyclerView.setAdapter(customAdapter);

        layoutManager = new LinearLayoutManager(this);
        orderRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView


    /**
     * OrderAdapter class - a class that displays a list of Order objects in the recycler view.
     */
    private class OrderAdapter extends CustomAdapter {

        /**
         * OrderAdapter Constructor
         * @param itemList contains the list of Order.
         */
        public OrderAdapter(List itemList) {
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

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order, parent, false);
            customViewHolder = new OrderViewHolder(view);

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

            if(super.getItemList().get(position) instanceof Order){
                if(holder instanceof OrderViewHolder) {
                    final Order item = (Order) super.getItemList().get(position);
                    OrderViewHolder orderViewHolder = (OrderViewHolder)holder;

                    orderViewHolder.movieNameTextView.setText(item.getMovieName());
                    orderViewHolder.theatreNameTextView.setText(item.getTheatreName());
                    orderViewHolder.showTimeTextView.setText(item.getShowTime());
                    orderViewHolder.showDateTextView.setText(item.getShowDate());
                    orderViewHolder.quantityTextView.setText("Tickets: " + Integer.toString(item.getTicketQuantity()));
                }

            }else{
                throw new Error("an item from the list is expected to be a Order object.");
            }

        }//end onBindViewHolder

        /**
         * OrderViewHolder class - a class that assigns the widgets from activity_order xml so that it
         *          could display each Seat object from the list.
         */
        private class OrderViewHolder extends CustomViewHolder {

            private TextView movieNameTextView;
            private TextView theatreNameTextView;
            private TextView showTimeTextView;
            private TextView showDateTextView;
            private TextView quantityTextView;

            public OrderViewHolder(@NonNull View itemView) {
                super(itemView);
                movieNameTextView = itemView.findViewById(R.id.movieNametextView);
                theatreNameTextView = itemView.findViewById(R.id.theatreNameTextView);
                showTimeTextView = itemView.findViewById(R.id.showTimeTextView);
                showDateTextView = itemView.findViewById(R.id.showDateTextView);
                quantityTextView = itemView.findViewById(R.id.quantityTextView);
            }//end constructor

        }//end OrderViewHolder class

    }//end OrderAdapter class

}//end OrderActivity class
