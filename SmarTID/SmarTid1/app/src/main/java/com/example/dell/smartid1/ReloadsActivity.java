package com.example.dell.smartid1;

import android.os.AsyncTask;
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

public class ReloadsActivity extends AppCompatActivity {

    private String fseid="fse1";
    private String shopname="shop1";

    private TextView tvexist;

    private EditText etammount;

    String JSONS_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloads);

        tvexist =(TextView)findViewById(R.id.tvexist);

        etammount=(EditText)findViewById(R.id.etamnt);

        new BackgroundAmmount().execute();
    }

    private boolean isEmpty(EditText etText) {

        return etText.getText().toString().trim().length() == 0;
    }

    public void onButtonTran(View view){

        String ammount=etammount.getText().toString();

        int stock=Integer.parseInt(tvexist.getText().toString());

        if(isEmpty(etammount)){
            Toast.makeText(getApplicationContext(),"Enter Ammount to Transfer",Toast.LENGTH_LONG).show();
        }
        else if(Integer.parseInt(ammount) > stock) {
            Toast.makeText(getApplicationContext(), "Your Stock is not Enough", Toast.LENGTH_LONG).show();
        }
        else if(Integer.parseInt(ammount) == 0) {
            Toast.makeText(getApplicationContext(), "can't enter Ammont 0", Toast.LENGTH_LONG).show();
        }
        else if(Integer.parseInt(ammount) < 100) {
            Toast.makeText(getApplicationContext(), "Should Transfer more than 100 ", Toast.LENGTH_LONG).show();
        }
        else{

            String type="sell";
            BackgroundReload backgroundReload= new BackgroundReload(this);
            backgroundReload.execute(type,fseid,shopname,ammount);

        }

    }

    public class BackgroundAmmount extends AsyncTask<Void,Void,String> {

        String json_url;

        @Override
        protected void onPreExecute() {

            json_url = "http://192.168.1.3/smartid/jasonReload.php";
        }

        @Override
        protected String doInBackground(Void... params) {

            //String fseid="fse1";

            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                //set posting data
                String post_data = URLEncoder.encode("fseid", "UTF-8") + "=" + URLEncoder.encode(fseid, "UTF-8");

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
