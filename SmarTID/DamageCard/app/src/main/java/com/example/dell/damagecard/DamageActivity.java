package com.example.dell.damagecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DamageActivity extends AppCompatActivity {

    private EditText etCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damage);

        etCheck.findViewById(R.id.etcheck1);
    }

    public void ButtonDamage(View view){

        String serial=etCheck.getText().toString();

        String type="check";
        BackgroundDamage backgroundDamage= new BackgroundDamage(this);
        backgroundDamage.execute(type,serial);

        //etserial.setText("");

    }
}
