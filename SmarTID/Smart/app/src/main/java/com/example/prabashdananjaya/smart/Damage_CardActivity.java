package com.example.prabashdananjaya.smart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Damage_CardActivity extends AppCompatActivity {

    private EditText etdamage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damage_card);

        etdamage=(EditText) findViewById(R.id.Enter_txt);

    }
   // public void onBackPressed() {
       // Intent intent = new Intent(Damage_CardActivity.this, HomeActivity.class);
        //startActivity(intent);

   // }

    public void onDamage(View view){

        String serial;
        serial=etdamage.getText().toString();

        String type="check";
        BackgroundDamage backgroundDamage= new BackgroundDamage(this);
        backgroundDamage.execute(type,serial);

    }
}
