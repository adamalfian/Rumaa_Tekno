package e.wolfsoft1.scanhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import e.wolfsoft1.scanhome.Adapters.PropertyRecyclerAdapter;
import e.wolfsoft1.scanhome.ModelClasses.PropertyRecyclerModel;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<PropertyRecyclerModel> homeListModelClassArrayList;
    private RecyclerView recyclerView;
    private PropertyRecyclerAdapter mAdapter;
    TextView refine;
    LinearLayout layoutMyOrder, layoutForm, layoutHome;

    private String propertyName[]={"Property Name","Property Name","Property Name","Property Name","Property Name","Property Name"};
    private String street1[]={"14 Street/3rd Block","14 Street/3rd Block","14 Street/3rd Block","14 Street/3rd Block","14 Street/3rd Block","14 Street/3rd Block"};
    private String street2[]={"Super Build-up Area:1060 Sq.Ft","Super Build-up Area:1060 Sq.Ft","Super Build-up Area:1060 Sq.Ft","Super Build-up Area:1060 Sq.Ft","Super Build-up Area:1060 Sq.Ft","Super Build-up Area:1060 Sq.Ft"};
    private String amount[]={"$2200","$2200","$2200","$2200","$2200","$2200"};
    private String bedcount[]={"3","3","3","3","3","3"};
    private String carParking[]={"1","1","1","1","1","1"};
    private String swimmingpool[]={"1","1","1","1","1","1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        HomeActivity.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

       refine=(TextView)findViewById(R.id.refine);
       recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
       layoutMyOrder = findViewById(R.id.layoutOrder);
       layoutForm = findViewById(R.id.layoutForm);
       layoutHome = findViewById(R.id.layoutHome);

       refine.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this,PropertyDetailsActivity.class);
               startActivity(intent);
           }
       });

       layoutMyOrder.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this, MyOrderActivity.class);
               startActivity(intent);
           }
       });

       layoutForm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this, CreateActivity.class);
               startActivity(intent);
           }
       });

        homeListModelClassArrayList = new ArrayList<>();

        for (int i = 0; i < propertyName.length; i++) {
            PropertyRecyclerModel beanClassForRecyclerView_contacts = new PropertyRecyclerModel(propertyName[i], street1[i],street2[i],amount[i],bedcount[i],carParking[i],swimmingpool[i]);

            homeListModelClassArrayList.add(beanClassForRecyclerView_contacts);
        }
        mAdapter = new PropertyRecyclerAdapter(HomeActivity.this,homeListModelClassArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(HomeActivity.this
        );
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
}