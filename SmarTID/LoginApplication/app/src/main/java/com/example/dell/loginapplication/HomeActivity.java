package com.example.dell.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    private TextView textV1;// , textV2;

    private EditText etshop;

    String fseid;
    String shopname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fseid=getIntent().getExtras().getString("fseid");

        etshop=findViewById(R.id.etshop);

        textV1=(TextView)findViewById(R.id.testV);
        //extV2=(TextView)findViewById(R.id.);

        textV1.setText(fseid);
    }

    public void onNext(View view){

        shopname=etshop.getText().toString();

        Intent intent = new Intent("com.example.dell.loginapplication.ShopDisActivity");
        intent.putExtra("fseid",fseid);
        intent.putExtra("shopname",shopname);
        startActivity(intent);

    }
}
