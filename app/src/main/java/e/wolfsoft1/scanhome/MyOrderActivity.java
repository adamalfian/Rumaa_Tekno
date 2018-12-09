package e.wolfsoft1.scanhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MyOrderActivity extends AppCompatActivity {

    LinearLayout layoutMyOrder, layoutForm, layoutHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        layoutMyOrder = findViewById(R.id.layoutOrder);
        layoutForm = findViewById(R.id.layoutForm);
        layoutHome = findViewById(R.id.layoutHome);


        layoutForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyOrderActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        layoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyOrderActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
