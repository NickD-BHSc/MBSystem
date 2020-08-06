package comp3350.mbs.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

        if(orderList.size() == 0){
            noOrdersAvailable = findViewById(R.id.noOrderstextView);
            noOrdersAvailable.setVisibility(View.VISIBLE);
        }else{
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

        customAdapter = new CustomAdapter(OrderActivity.this, orderList);
        orderRecyclerView.setAdapter(customAdapter);

        layoutManager = new LinearLayoutManager(this);
        orderRecyclerView.setLayoutManager(layoutManager);

    }//end buildRecyclerView

}
