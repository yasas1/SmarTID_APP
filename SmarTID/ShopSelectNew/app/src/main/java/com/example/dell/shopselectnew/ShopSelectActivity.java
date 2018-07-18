package com.example.dell.shopselectnew;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
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
import java.util.ArrayList;

public class ShopSelectActivity extends AppCompatActivity {

    private EditText eshop;
    private TextView tshopname,tshop;

    private AutoCompleteTextView actv1;

    String JSON_STRING;

    String [] shopnames;//={"shop1","shop2","shop3"};

    String [] shopnames1={"shop1","shop2","shop3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_select);

        eshop=(EditText)findViewById(R.id.atcshop);
        tshopname=(TextView) findViewById(R.id.tshop);

        tshop=(TextView) findViewById(R.id.textView3);

        new BackgroundShop().execute();

        actv1 = (AutoCompleteTextView)findViewById(R.id.atcshop);
        ImageView image = (ImageView)findViewById(R.id.image);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,shopnames1);
        actv1.setAdapter(adapter);
        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                actv1.showDropDown();}

        });


    }

    public void OnCheck(View view){

        String s=actv1.getText().toString();

        tshop.setText(s);

    }

    public class BackgroundShop extends AsyncTask<Void,Void,String> {

        String json_url;

        @Override
        protected void onPreExecute() {

            json_url = "http://192.168.1.4/smartid/jasonShopArray.php"; //192.168.131.52  192.168.1.3
        }

        @Override
        protected String doInBackground(Void... params) {



            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

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

            //shopnames=new String[]{result};

            tshopname.setText(result);

            //String[] arr =result.toString().replace("},{", " ,").split(" ");;

            //tshop.setText(shopnames);

            /*try {
                JSONArray arrj = new JSONArray(result);

                shopnames=toStringArray(arrj);

            } catch (JSONException e) {
                e.printStackTrace();
            }*/

        }

    }
   /* public String[] toStringArray(JSONArray array) {
        if(array==null)
            return null;

        String[] arr=new String[array.length()];
        for(int i=0; i<arr.length; i++) {
            arr[i]=array.optString(i);
        }
        return arr;
    }*/

   /* ArrayList<String> jsonStringToArray(String jsonString) throws JSONException {

        ArrayList<String> stringArray = new ArrayList<String>();

        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
            stringArray.add(jsonArray.getString(i));
        }

        return stringArray;
    }*/

}
