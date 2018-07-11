package com.example.prabashdananjaya.smart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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


public class ReloadActivity extends AppCompatActivity {

    //private String fseid=getIntent().getStringExtra("fseid");
    //private String shopname="shop1";

    String fseid;
    String shopname;

    //fseid= getIntent().getStringExtra("fseid");

    private TextView tvexist,tshop;

    private EditText etammount;

    String JSONS_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reload);

        tvexist =(TextView)findViewById(R.id.tvex);

        tshop=(TextView)findViewById(R.id.tshopname);

        etammount=(EditText)findViewById(R.id.etamnt);

        shopname= getIntent().getExtras().getString("shopn");
        fseid= getIntent().getExtras().getString("fseid");

        //shopname="shopname";

        tshop.setText(shopname);

        new BackgroundAmmount().execute();
    }

    private boolean isEmpty(EditText etText) {

        return etText.getText().toString().trim().length() == 0;
    }



    public void onButtonTran(View view){

        String ammount=etammount.getText().toString();
        String exist=tvexist.getText().toString();
        //onButtonReset

        //int stock=Integer.parseInt(exist);
        //int amt =Integer.parseInt(ammount);

        if(isEmpty(etammount)){
            Toast.makeText(getApplicationContext(),"Enter Ammount to Transfer",Toast.LENGTH_LONG).show();
            ammount="0";
        }/*
        else if(amt > stock) {
            Toast.makeText(getApplicationContext(), "Your Stock is not Enough", Toast.LENGTH_LONG).show();
        }
        else if(amt <= 100) {
            Toast.makeText(getApplicationContext(), "Should Transfer more than 100 ", Toast.LENGTH_LONG).show();
        }*/
        else{

            //String type="sell";
            BackgroundReloads backgroundReloads= new BackgroundReloads(this);
            backgroundReloads.execute(fseid,shopname,ammount,exist);
            etammount.setText("");
            new BackgroundAmmount().execute();
        }

    }


    public class BackgroundAmmount extends AsyncTask<Void,Void,String> {

        String jsonurl;

        @Override
        protected void onPreExecute() {

            jsonurl = "http://192.168.43.45/smartid/jasonReload.php";
        }

        @Override
        protected String doInBackground(Void... params) {

            //String fseid="fse1";

            try {
                URL url = new URL(jsonurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                //set posting data
                String post_data = URLEncoder.encode("fseid", "UTF-8")+"="+URLEncoder.encode(fseid,"UTF-8");

                bufferedWriter.write(post_data); //post the data
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")); //iso-8859-1 expected type
                StringBuilder result = new StringBuilder();
                while ((JSONS_STRING = bufferedReader.readLine()) != null) {
                    result.append(JSONS_STRING + "\n");
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

            //tvexist.setText(result);

            try {

                JSONObject reader= new JSONObject(result);

                JSONObject jsonObject = reader.getJSONObject("server_response");

                String existammount = jsonObject.getString("exist");

                tvexist.setText(existammount);

            }catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
