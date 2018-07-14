package com.example.dell.smartid1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    //private EditText tuser,tpswrd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //tuser.findViewById(R.id.tUserName);
        //tpswrd.findViewById(R.id.tPassword);

        OnClickButtonLogin();
    }

    public void OnClickButtonLogin(){
        btnLogin =(Button)findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(
                new View.OnClickListener(){

                    public void onClick(View v){

                        //String username=tuser.getText().toString();

                        Intent intent = new Intent("com.example.dell.smartid1.RechargeActivity");
                        //intent.putExtra("fseid",username);
                        startActivity(intent);
                    }
                }
        );
    }
}
