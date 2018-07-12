package com.example.dell.selectshop;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

public class SelecetShopActivity extends AppCompatActivity {

    private EditText eshop;
    private TextView tvcheckstate;

    String shop;
    String JSON_STRING;

    //private String fseid="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecet_shop);

        eshop=(EditText)findViewById(R.id.entershop);
        tvcheckstate=(TextView) findViewById(R.id.tvcheck);




    }

    public void onCheck(View view){
        shop=eshop.getText().toString();
        new BackgroundShop().execute(shop);

    }

   public class BackgroundShop extends AsyncTask<String,Void,String> {

       String json_url;

       @Override
       protected void onPreExecute() {

           json_url = "http://192.168.1.4/smartid/jsonshops.php"; //192.168.131.52  192.168.1.3
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
