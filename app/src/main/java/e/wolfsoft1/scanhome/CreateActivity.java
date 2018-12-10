package e.wolfsoft1.scanhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class CreateActivity extends AppCompatActivity {

    LinearLayout layoutMyOrder, layoutForm, layoutHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        layoutMyOrder = findViewById(R.id.layoutOrder);
        layoutForm = findViewById(R.id.layoutForm);
        layoutHome = findViewById(R.id.layoutHome);

        layoutMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateActivity.this, MyOrderActivity.class);
                finish();
                startActivity(intent);
            }
        });

        layoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateActivity.this, HomeActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
