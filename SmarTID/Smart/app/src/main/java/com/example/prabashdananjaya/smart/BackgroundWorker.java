package com.example.prabashdananjaya.smart;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

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

/**
 * Created by Dell on 12/4/2017.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;

    AlertDialog alertDialog;
    HttpURLConnection httpURLConnection;

    BackgroundWorker(Context ctx) {
        this.context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String card_url="http://192.168.1.4/smartid/cardsalesdc.php"; //192.168.1.3   //127.0.0.1

        if(type.equals("sell")){
            try {

                String fseid = params[1];
                String shopname = params[2];
                String qty20 = params[3];
                String start20 = params[4];
                String qty50 = params[5];
                String start50 = params[6];
                String qty100 = params[7];
                String start100 = params[8];
                String qty500 = params[9];
                String start500 = params[10];
                String qty1000 = params[11];
                String start1000 = params[12];

                URL url=new URL(card_url);
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream= httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                //set posting data
                String post_data = URLEncoder.encode("fseid","UTF-8")+"="+URLEncoder.encode(fseid,"UTF-8")+"&"+
                        URLEncoder.encode("shopname","UTF-8")+"="+URLEncoder.encode(shopname,"UTF-8")+"&"+
                        URLEncoder.encode("qty20","UTF-8")+"="+URLEncoder.encode(qty20,"UTF-8")+"&"+
                        URLEncoder.encode("start20","UTF-8")+"="+URLEncoder.encode(start20,"UTF-8")+"&"+
                        URLEncoder.encode("qty50","UTF-8")+"="+URLEncoder.encode(qty50,"UTF-8")+"&"+
                        URLEncoder.encode("start50","UTF-8")+"="+URLEncoder.encode(start50,"UTF-8")+"&"+
                        URLEncoder.encode("qty100","UTF-8")+"="+URLEncoder.encode(qty100,"UTF-8")+"&"+
                        URLEncoder.encode("start100","UTF-8")+"="+URLEncoder.encode(start100,"UTF-8")+"&"+
                        URLEncoder.encode("qty500","UTF-8")+"="+URLEncoder.encode(qty500,"UTF-8")+"&"+
                        URLEncoder.encode("start500","UTF-8")+"="+URLEncoder.encode(start500,"UTF-8")+"&"+
                        URLEncoder.encode("qty1000","UTF-8")+"="+URLEncoder.encode(qty1000,"UTF-8")+"&"+
                        URLEncoder.encode("start1000","UTF-8")+"="+URLEncoder.encode(start1000,"UTF-8");



                bufferedWriter.write(post_data); //post the data
                bufferedWriter.flush();
                bufferedWriter.close();



                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1")); //iso-8859-1 expected type

                String result="";
                String line;
                while((line=bufferedReader.readLine())!=null){
                    result = result+ line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            }catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return null;
    }

    @Override
    protected void onPreExecute() {

        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Sales");

    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

}
