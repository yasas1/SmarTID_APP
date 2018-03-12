package com.example.prabashdananjaya.smart;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ShopActivity extends AppCompatActivity {
    private Button btnreload;
    private Button btnrecharge;
    private EditText eshop;
    private TextView tvcheckstate;

    private String fseid;//="1";
    private String shopn;//="Naduli Communication";

    //String[] shoparray={"Naduli Communication","Thilak Stores","Pubudu Co Ltd"};

    String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        fseid= getIntent().getStringExtra("fseid");

        eshop=(EditText)findViewById(R.id.entershop);
        tvcheckstate=(TextView) findViewById(R.id.tvcheck);

        shopn = eshop.getText().toString();

        //test1=(EditText)findViewById(R.id.ed1);

       /* final AutoCompleteTextView actv1 = (AutoCompleteTextView)findViewById(R.id.enter_shop);
        ImageView image = (ImageView)findViewById(R.id.imageView_arrowdown);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,shoparray);
        actv1.setAdapter(adapter);
        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                actv1.showDropDown();}

        });*/
        onClickButtonReload();
        onClickButtonRecharge();
    }

    public void onCheck(View view){

        shopn=eshop.getText().toString();

        new BackgroundShop().execute(shopn);

    }

    public void onClickButtonReload(){
        btnreload = (Button)findViewById(R.id.but_reload);

        btnreload.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String checkstatus;

                checkstatus=tvcheckstate.getText().toString();

                if(checkstatus=="True"){

                    shopn = eshop.getText().toString();

                    Intent intent = new Intent("com.example.prabashdananjaya.smart.ReloadActivity");
                    intent.putExtra("shopn",shopn);
                    intent.putExtra("fseid",fseid);
                    startActivity(intent);

                    tvcheckstate.setText("checkStatus");

                }
                else{
                    Toast.makeText(getApplicationContext(),"Please Enter a Valid Shop Name",Toast.LENGTH_LONG).show();
                }



            }
        }
        );
    }
    public void onClickButtonRecharge(){
        btnrecharge = (Button)findViewById(R.id.but_recharge);

        btnrecharge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String checkstatus;

                checkstatus=tvcheckstate.getText().toString();

                if(checkstatus=="True"){

                    shopn = eshop.getText().toString();

                    Intent intent = new Intent("com.example.prabashdananjaya.smart.CardActivity");
                    intent.putExtra("shopn",shopn);
                    intent.putExtra("fseid",fseid);

                    startActivity(intent);

                    tvcheckstate.setText("checkStatus");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please Enter a Valid Shop Name",Toast.LENGTH_LONG).show();
                }



            }
        }
        );
    }
    /*public void onBackPressed() {
        Intent intent = new Intent(ShopActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }*/

    public class BackgroundShop extends AsyncTask<String,Void,String> {

        String json_url;

        @Override
        protected void onPreExecute() {

            json_url = "http://192.168.43.45/smartid/jsonshops.php"; //192.168.131.52  192.168.1.3
        }

        @Override
        protected String doInBackground(String... params) {

            String shopname=params[0];

            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream= httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                //set posting data
                String post_data = URLEncoder.encode("shop","UTF-8")+"="+URLEncoder.encode(shopname,"UTF-8");

                bufferedWriter.write(post_data); //post the data
                bufferedWriter.flush();
                bufferedWriter.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")); //iso-8859-1 expected type
                StringBuilder result = new StringBuilder();
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    result.append(JSON_STRING + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            try {

                JSONObject reader = new JSONObject(result);

                JSONObject jsonObject = reader.getJSONObject("server_response");

                int checkshop = Integer.parseInt(jsonObject.getString("shop"));

                if(checkshop==1){
                    tvcheckstate.setText("True");
                }else{
                    tvcheckstate.setText("False");
                }




            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }
}
