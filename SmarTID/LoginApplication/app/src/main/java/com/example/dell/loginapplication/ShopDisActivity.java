package com.example.dell.loginapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShopDisActivity extends AppCompatActivity {

    private TextView tv1,tv2;

    String fseid;
    String shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_dis);

        tv1=(TextView)findViewById(R.id.t1);
        tv2=(TextView)findViewById(R.id.t2);

        fseid=getIntent().getExtras().getString("fseid");
        shop=getIntent().getExtras().getString("shopname");

        tv1.setText(fseid);
        tv2.setText(shop);

    }
}
