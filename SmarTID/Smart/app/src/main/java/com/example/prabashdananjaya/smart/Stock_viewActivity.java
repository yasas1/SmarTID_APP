package com.example.prabashdananjaya.smart;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Stock_viewActivity extends AppCompatActivity{

    private TextView textView20,textView50,textView100,textView500,textView1000,textViewamt;

    String JSON_STRING;

    private String fseid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_view);

        textView20 =(TextView)findViewById(R.id.tcount20);
        textView50 =(TextView)findViewById(R.id.tcount50);
        textView100 =(TextView)findViewById(R.id.tcount100);
        textView500 =(TextView)findViewById(R.id.tcount500);
        textView1000 =(TextView)findViewById(R.id.tcount1000);

        textViewamt =(TextView)findViewById(R.id.tcountamt);

        fseid=getIntent().getExtras().getString("fseid");

        new BackgroundStock().execute();
    }

    public class BackgroundStock extends AsyncTask<Void,Void,String> {

        String json_url;

        @Override
        protected void onPreExecute() {

            json_url="http://192.168.1.4/smartid/jsonStocks.php"; //192.168.131.52  192.168.1.3
        }

        @Override
        protected String doInBackground(Void... params) {

            //String fseid="fse1";

            try{
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream= httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                //set posting data
                String post_data = URLEncoder.encode("fseid","UTF-8")+"="+URLEncoder.encode(fseid,"UTF-8");

                bufferedWriter.write(post_data); //post the data
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1")); //iso-8859-1 expected type
                StringBuilder result= new StringBuilder();
                while((JSON_STRING=bufferedReader.readLine())!=null){
                    result.append(JSON_STRING+"\n");
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

            //textView1.setText(result);


            try {

                JSONObject reader= new JSONObject(result);

                JSONObject jsonObject = reader.getJSONObject("server_response");

                String amt = jsonObject.getString("reload");

                String count20 = jsonObject.getString("count20");
                String count50 = jsonObject.getString("count50");
                String count100 = jsonObject.getString("count100");
                String count500 = jsonObject.getString("count500");
                String count1000 = jsonObject.getString("count1000");

                textView20.setText(count20);
                textView50.setText(count50);
                textView100.setText(count100);
                textView500.setText(count500);
                textView1000.setText(count1000);

                textViewamt.setText(amt);


            }catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    /*public void onBackPressed() {
        Intent intent = new Intent(Stock_viewActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }*/

}
