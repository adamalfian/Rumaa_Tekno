package e.wolfsoft1.scanhome;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import e.wolfsoft1.scanhome.Adapters.MyCustomPagerAdapter;
import e.wolfsoft1.scanhome.Adapters.PropertyImageAdapter;
import e.wolfsoft1.scanhome.ModelClasses.PropertyImageModel;

public class PropertyDetailsActivity extends AppCompatActivity implements OnMapReadyCallback{
    ViewPager viewPager;
    int images[] = {R.drawable.property,R.drawable.property,R.drawable.property,R.drawable.property};
    MyCustomPagerAdapter myCustomPagerAdapter;

    private TextView imageNo;
    LinearLayout layoutMyOrder, layoutForm, layoutHome;



//
//    private ArrayList<PropertyImageModel> homeListModelClassArrayList;
//    private RecyclerView recyclerView1;
//    private PropertyImageAdapter mAdapter;
//     private Integer image[]={R.drawable.property,R.drawable.property,R.drawable.property,
//             R.drawable.property,R.drawable.property,R.drawable.property};
//     private String imageNo[]={"1","2","3","4","5","6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        imageNo = (TextView)findViewById(R.id.imageNo);
        layoutMyOrder = findViewById(R.id.layoutOrder);
        layoutForm = findViewById(R.id.layoutForm);
        layoutHome = findViewById(R.id.layoutHome);

        myCustomPagerAdapter = new MyCustomPagerAdapter(PropertyDetailsActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);

        layoutMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PropertyDetailsActivity.this, MyOrderActivity.class);
                finish();
                startActivity(intent);
            }
        });

        layoutForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PropertyDetailsActivity.this, CreateActivity.class);
                finish();
                startActivity(intent);
            }
        });

        layoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PropertyDetailsActivity.this, HomeActivity.class);
                finish();
                startActivity(intent);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                imageNo.setText("" + (position +1));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Retrieve the content view that renders the map.

        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
////
//        recyclerView1 = (RecyclerView)findViewById(R.id.recyclerView1);
//        homeListModelClassArrayList = new ArrayList<>();
//
//        for (int i = 0; i < image.length; i++) {
//            PropertyImageModel beanClassForRecyclerView_contacts = new PropertyImageModel(image[i],imageNo[i]);
//
//            homeListModelClassArrayList.add(beanClassForRecyclerView_contacts);
//        }
//        mAdapter = new PropertyImageAdapter(PropertyDetailsActivity.this,homeListModelClassArrayList);
//
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(PropertyDetailsActivity.this,LinearLayoutManager.HORIZONTAL, false);
//        recyclerView1.setLayoutManager(mLayoutManager);
//        recyclerView1.setItemAnimator(new DefaultItemAnimator());
//        recyclerView1.setAdapter(mAdapter);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
