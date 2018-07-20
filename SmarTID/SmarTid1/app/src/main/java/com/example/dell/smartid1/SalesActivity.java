package com.example.dell.smartid1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SalesActivity extends AppCompatActivity {

    private Button btnCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
    }

    /*public void onCard(View view){

        btnCard =(Button)findViewById(R.id.btnlogin);
        Intent intentcard = new Intent("com.example.dell.smartid1.RechargeActivity");
        startActivity(intentcard);

    }*/
}
