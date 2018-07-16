package com.example.dell.reload;

import android.app.AlertDialog;
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
 * Created by Dell on 12/10/2017.
 */

public class BackgroundReloads extends AsyncTask<String,Void,String> {
    Context context;

    AlertDialog alertDialog;
    HttpURLConnection httpURLConnection;

    BackgroundReloads(Context ctx) {

        this.context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        //String type = params[0];
        String cardurl="http://192.168.1.4/smartid/reloadsales.php"; //192.168.1.3   //127.0.0.1 18.217.208.126/JSP

        //if(type.equals("sell")){
            try {

                String fseid = params[0];
                String shopname = params[1];
                String ammount = params[2];
                String exist = params[3];

                URL url=new URL(cardurl);
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream= httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                //set posting data
                String post_data = URLEncoder.encode("fseid","UTF-8")+"="+URLEncoder.encode(fseid,"UTF-8")+"&"+
                        URLEncoder.encode("shopname","UTF-8")+"="+URLEncoder.encode(shopname,"UTF-8")+"&"+
                        URLEncoder.encode("ammount","UTF-8")+"="+URLEncoder.encode(ammount,"UTF-8")+"&"+
                        URLEncoder.encode("exist","UTF-8")+"="+URLEncoder.encode(exist,"UTF-8");


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


        //}

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
