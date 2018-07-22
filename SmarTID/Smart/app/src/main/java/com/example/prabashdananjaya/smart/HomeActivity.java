package com.example.prabashdananjaya.smart;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {
    private Button btnSale;
    private Button btncheck_card;
    private Button btnview_stock;

    private String fseid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView fseidprint = (TextView)findViewById(R.id.welcome_view);

        fseid= getIntent().getStringExtra("fseid");

        fseidprint.setText(fseid);

        onClickButtonSale();
        onClickButtonCheckCard();
        onClickButtonViewStock();

    }
    public void onClickButtonSale(){
        btnSale = (Button)findViewById(R.id.btn_sale);
        btnSale.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ShopActivity.class);
                intent.putExtra("fseid",fseid);
                startActivity(intent);
                //finish();
            }
        }
        );
    }
    public void onClickButtonCheckCard() {
        btncheck_card = (Button) findViewById(R.id.btn_check_card);
        btncheck_card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Damage_CardActivity.class);
                startActivity(intent);
                //finish();
            }
        }
        );
    }
    public void onClickButtonViewStock() {
        btnview_stock = (Button) findViewById(R.id.but_view_card);
        btnview_stock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Stock_viewActivity.class);
                intent.putExtra("fseid",fseid);
                startActivity(intent);
                //finish();
            }
        });
    }

    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setTitle("User Logout")
                .setMessage("Are you sure you want to logout?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

        public void onClick(DialogInterface arg0, int arg1) {
            Intent intent1 = new Intent(HomeActivity.this,LogActivity.class);
            startActivity(intent1);
            finish();
        }

    })
                .create().show();
    }

}
