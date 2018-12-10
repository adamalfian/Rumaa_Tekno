package e.wolfsoft1.scanhome;

import android.content.Intent;
import android.graphics.Bitmap;
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

    private String propertyName[]={"Pakuwon Indah","Citraland","Kendangsari","Rungkut","Darmo Permai","Pondok Tjandra"};
    private String street1[]={"Pakuwon Indah, Surabaya","Surabaya, Citraland","Surabaya, Kendangsari","Surabaya, Rungkut","Surabaya, Darmo permai","Sidoarjo, Pondok Tjandra"};
    private String street2[]={"Super Build-up Area:50m2 Sq.Ft","Super Build-up Area:30 m2","Super Build-up Area:30m2","Super Build-up Area:30m2 Sq.Ft","Super Build-up Area:40m2 Sq.Ft","Super Build-up Area:120 m2"};
    private String amount[]={"Rp1.170.000.000,00","Rp855.000.000,00","Rp900.000.000,00","Rp965.000.000,00","Rp890.000.000,00","Rp1.250.000.000,00"};
    private String bedcount[]={"5","3","3","4","4","6"};
    private String carParking[]={"2","1","1","1","1","3"};
    private String swimmingpool[]={"1","0","0","0","0","1"};
    private static final Integer[] RUMAHIMAGESARRAY={R.drawable.ruma1,R.drawable.ruma2,R.drawable.ruma3,R.drawable.ruma4,R.drawable.ruma5,R.drawable.ruma6};

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
               finish();
               startActivity(intent);
           }
       });

       layoutMyOrder.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this, MyOrderActivity.class);
               finish();
               startActivity(intent);
           }
       });

       layoutForm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this, CreateActivity.class);
               finish();
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