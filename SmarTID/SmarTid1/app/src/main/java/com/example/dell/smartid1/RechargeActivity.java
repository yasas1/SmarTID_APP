package com.example.dell.smartid1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class RechargeActivity extends AppCompatActivity {

    private Button btnGet,btnReset;

    String JSON_STRING;

    private CheckBox check20,check50,check100,check500,check1000;
    private EditText etq20,etq50,etq100,etq500,etq1000;
    private TextView tvPrice20,tvPrice50,tvPrice100,tvPrice500,tvPrice1000,tvPriceTot;
    private  TextView textView1,textView2,textView3,textView4,textView5;
    private  TextView textView1end,textView2end,textView3end,textView4end,textView5end;

    private  TextView tcount20,tcount50,tcount100,tcount500,tcount1000;

    private String fseid="1";

    private String shopname="shop1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        //fseid=getIntent().getExtras().getString("fseid");

        check20=(CheckBox)findViewById(R.id.cb20);
        check50=(CheckBox)findViewById(R.id.cb50);
        check100=(CheckBox)findViewById(R.id.cb100);
        check500=(CheckBox)findViewById(R.id.cb500);
        check1000=(CheckBox)findViewById(R.id.cb1000);

        etq20=(EditText)findViewById(R.id.eq20);
        etq50=(EditText)findViewById(R.id.eq50);
        etq100=(EditText)findViewById(R.id.eq100);
        etq500=(EditText)findViewById(R.id.eq500);
        etq1000=(EditText)findViewById(R.id.eq1000);

        tcount20 =(TextView)findViewById(R.id.tc20);
        tcount50 =(TextView)findViewById(R.id.tc50);
        tcount100 =(TextView)findViewById(R.id.tc100);
        tcount500 =(TextView)findViewById(R.id.tc500);
        tcount1000 =(TextView)findViewById(R.id.tc1000);

        textView1 =(TextView)findViewById(R.id.t1);
        textView2 =(TextView)findViewById(R.id.t2);
        textView3 =(TextView)findViewById(R.id.t3);
        textView4 =(TextView)findViewById(R.id.t4);
        textView5 =(TextView)findViewById(R.id.t5);

        textView1end =(TextView)findViewById(R.id.t1end);
        textView2end =(TextView)findViewById(R.id.t2end);
        textView3end =(TextView)findViewById(R.id.t3end);
        textView4end =(TextView)findViewById(R.id.t4end);
        textView5end =(TextView)findViewById(R.id.t5end);

        tvPrice20=(TextView)findViewById(R.id.tprice20);
        tvPrice50=(TextView)findViewById(R.id.tprice50);
        tvPrice100=(TextView)findViewById(R.id.tprice100);
        tvPrice500=(TextView)findViewById(R.id.tprice500);
        tvPrice1000=(TextView)findViewById(R.id.tprice1000);

        tvPriceTot=(TextView)findViewById(R.id.tpricetot);


        OnClickButtonGet();
        OnClickButtonReset();

        new BackgroundTask().execute();

    }



    private boolean isEmpty(EditText etText) {

        return etText.getText().toString().trim().length() == 0;
    }

    public boolean isEnough(double stock,double qty){
        boolean result=false;
        if(stock>=qty){
            result=true;
        }
        return result;
    }

    public void OnClickButtonGet(){
        btnGet =(Button)findViewById(R.id.btnget);
        btnGet.setOnClickListener(
                new View.OnClickListener(){

                    public void onClick(View v){

                        Double price20=0.0,price50=0.0,price100=0.0,price500=0.0,price1000=0.0,priceTot=0.0;
                        Double rate=0.96;
                        int count=0;

                        Double stock20=Double.parseDouble(tcount20.getText().toString());

                        if(check20.isChecked()){


                            if (isEmpty(etq20)){
                                Toast.makeText(getApplicationContext(),"Enter qty of card20",Toast.LENGTH_LONG).show();
                                check20.toggle();
                            }
                            else{

                                double q20=Double.parseDouble(etq20.getText().toString());
                                if(isEnough(stock20,q20)) {

                                    price20 = q20 * (20 * rate);

                                    tvPrice20.setText(Double.toString(price20));
                                }else{
                                    Toast.makeText(getApplicationContext(),"Stock is not Enough",Toast.LENGTH_LONG).show();
                                }
                            }
                            count++;
                        }else if (isEmpty(etq20)==false){
                            Toast.makeText(getApplicationContext(),"Select card20",Toast.LENGTH_LONG).show();
                        }
                        if(check50.isChecked()){


                            if (isEmpty(etq50)){
                                Toast.makeText(getApplicationContext(),"Enter the quantity of card50",Toast.LENGTH_LONG).show();
                                check50.toggle();
                            }
                            else{
                                double q50=Double.parseDouble(etq50.getText().toString());

                                price50=q50*(50*rate);

                                tvPrice50.setText(Double.toString(price50));
                            }
                            count++;
                        }else if(isEmpty(etq50)==false){
                            Toast.makeText(getApplicationContext(),"Select card50",Toast.LENGTH_LONG).show();
                        }
                        if(check100.isChecked()){

                            if (isEmpty(etq100)){
                                Toast.makeText(getApplicationContext(),"Enter the quantity of card100",Toast.LENGTH_LONG).show();
                                check100.toggle();
                            }
                            else{
                                double q100=Double.parseDouble(etq100.getText().toString());

                                price100=q100*(100*rate);

                                tvPrice100.setText(Double.toString(price100));
                            }
                            count++;
                        }else if (isEmpty(etq100)==false){
                            Toast.makeText(getApplicationContext(),"Select card100",Toast.LENGTH_LONG).show();
                        }

                        if(check500.isChecked()){


                            if (isEmpty(etq500)){
                                Toast.makeText(getApplicationContext(),"Enter the quantity of card500",Toast.LENGTH_LONG).show();
                                check500.toggle();
                            }
                            else{
                                double q500=Double.parseDouble(etq500.getText().toString());

                                price500=q500*(500*rate);

                                tvPrice500.setText(Double.toString(price500));

                            }
                            count++;
                        }else if (isEmpty(etq500)==false){
                            Toast.makeText(getApplicationContext(),"Select card500",Toast.LENGTH_LONG).show();
                        }

                        if(check1000.isChecked()){


                            if (isEmpty(etq1000)){
                                Toast.makeText(getApplicationContext(),"Enter the quantity of card1000",Toast.LENGTH_LONG).show();
                                check1000.toggle();
                            }
                            else{
                                double q1000=Double.parseDouble(etq1000.getText().toString());

                                price1000=q1000*(1000*rate);

                                tvPrice1000.setText(Double.toString(price1000));
                            }
                            count++;
                        }else if (isEmpty(etq1000)==false){
                            Toast.makeText(getApplicationContext(),"Select card1000",Toast.LENGTH_LONG).show();
                        }

                        if(count==0) {
                            Toast.makeText(getApplicationContext(),"Select the Card Types", Toast.LENGTH_LONG).show();
                        }
                        else{
                            priceTot=price20+price50+price100+price500+price1000;
                            tvPriceTot.setText(Double.toString(priceTot));
                        }
                    }
                }
        );
    }

    public void OnDisplaycard(View view){

        String q20;
        String q50;
        String q100;
        String q500;
        String q1000;

        q20=etq20.getText().toString();
        q50=etq50.getText().toString();
        q100=etq100.getText().toString();
        q500=etq500.getText().toString();
        q1000=etq1000.getText().toString();

        int count=0;

        if((tvPriceTot.getText().toString()=="")||tvPriceTot.getText().toString()=="0"){
            Toast.makeText(getApplicationContext(),"first press GET_PRICE",Toast.LENGTH_LONG).show();
        }
        else {
            if (check20.isChecked()) {

                if (isEmpty(etq20)) {
                    Toast.makeText(getApplicationContext(), "Enter the quantity of card20", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(q20) == 0) {
                    Toast.makeText(getApplicationContext(), "can't enter quantity 0  ", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(q20) == 1) {
                    textView1end.setText("only start card");
                }
                else if(tvPrice20.getText().toString()==""){
                    Toast.makeText(getApplicationContext(),"first press GET_PRICE",Toast.LENGTH_LONG).show();
                }
                else {

                    int num = Integer.parseInt(q20);
                    int start20 = Integer.parseInt(textView1.getText().toString());
                    int end20 = start20 + num - 1;

                    textView1end.setText(Integer.toString(end20));
                }
                count++;
            }
            if (check50.isChecked()) {

                if (isEmpty(etq50)) {
                    Toast.makeText(getApplicationContext(), "Enter the quantity of card50", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(q50) == 0) {
                    Toast.makeText(getApplicationContext(), "can't enter quantity 0  ", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(q50) == 1) {
                    textView2end.setText("only start card");
                }
                else if(tvPrice50.getText().toString()==""){
                    Toast.makeText(getApplicationContext(),"first press GET_PRICE",Toast.LENGTH_LONG).show();
                }
                else {

                    int num = Integer.parseInt(q50);
                    int start50 = Integer.parseInt(textView2.getText().toString());
                    int end50 = start50 + num - 1;

                    textView2end.setText(Integer.toString(end50));
                }
                count++;
            }
            if (check100.isChecked()) {

                if (isEmpty(etq100)) {
                    Toast.makeText(getApplicationContext(), "Enter the quantity of card100", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(q100) == 0) {
                    Toast.makeText(getApplicationContext(), "can't enter quantity 0  ", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(q100) == 1) {
                    textView3end.setText("only start card");
                }
                else if(tvPrice100.getText().toString()==""){
                    Toast.makeText(getApplicationContext(),"first press GET_PRICE",Toast.LENGTH_LONG).show();
                }
                else {

                    int num = Integer.parseInt(q100);
                    int start100 = Integer.parseInt(textView3.getText().toString());
                    int end100 = start100 + num - 1;

                    textView3end.setText(Integer.toString(end100));
                }
                count++;
            }
            if (check500.isChecked()) {

                if (isEmpty(etq500)) {
                    Toast.makeText(getApplicationContext(), "Enter the quantity of card500", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(q500) == 0) {
                    Toast.makeText(getApplicationContext(), "can't enter quantity 0  ", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(q500) == 1) {
                    textView4end.setText("only start card");
                }
                else if(tvPrice500.getText().toString()==""){
                    Toast.makeText(getApplicationContext(),"first press GET_PRICE",Toast.LENGTH_LONG).show();
                }
                else {
                    int num = Integer.parseInt(q500);
                    int start500 = Integer.parseInt(textView4.getText().toString());
                    int end500 = start500 + num - 1;

                    textView4end.setText(Integer.toString(end500));
                }
                count++;
            }
            if (check1000.isChecked()) {

                if (isEmpty(etq1000)) {
                    Toast.makeText(getApplicationContext(), "Enter the quantity of card1000", Toast.LENGTH_LONG).show();
                }else if (Integer.parseInt(q1000) == 0) {
                    Toast.makeText(getApplicationContext(), "can't enter quantity 0  ", Toast.LENGTH_LONG).show();
                }else if (Integer.parseInt(q1000) == 1) {
                    textView5end.setText("only start card");
                }
                else if(tvPrice1000.getText().toString()==""){
                    Toast.makeText(getApplicationContext(),"first press GET_PRICE",Toast.LENGTH_LONG).show();
                }
                else {
                    int num = Integer.parseInt(q1000);
                    int start1000 = Integer.parseInt(textView5.getText().toString());
                    int end1000 = start1000 + num - 1;

                    textView5end.setText(Integer.toString(end1000));
                }
                count++;
            }
            if (count == 0) {
                Toast.makeText(getApplicationContext(), "Select the Card Types", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void OnSellBtn(View view){

        //String fseid="fse1";

        String qty20;
        String qty50;
        String qty100;
        String qty500;
        String qty1000;

        qty20=etq20.getText().toString();
        qty50=etq50.getText().toString();
        qty100=etq100.getText().toString();
        qty500=etq500.getText().toString();
        qty1000=etq1000.getText().toString();

        String start20="0";
        String start50="0";
        String start100="0";
        String start500="0";
        String start1000="0";

        int count=0;

        if((tvPriceTot.getText().toString()=="")||tvPriceTot.getText().toString()=="0"){
            Toast.makeText(getApplicationContext(),"first press GET_PRICE",Toast.LENGTH_LONG).show();
        }
        else {

            if (check20.isChecked()) {

                if (isEmpty(etq20)) {
                    qty20 = "0";
                    Toast.makeText(getApplicationContext(), "Enter the quantity of card20", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(qty20) == 0) {
                    Toast.makeText(getApplicationContext(), "can't enter quantity 0  ", Toast.LENGTH_LONG).show();
                } else if (tvPrice20.getText().toString() == "") {
                    Toast.makeText(getApplicationContext(), "first press GET_PRICE", Toast.LENGTH_LONG).show();
                } else {
                    //String price20=tvPrice20.getText().toString();
                    start20 = textView1.getText().toString();
                    //int end20 = start20 + num - 1;
                }
                count++;
            }else{qty20 = "0";}
            if (check50.isChecked()) {

                if (isEmpty(etq50)) {
                    qty50 = "0";
                    Toast.makeText(getApplicationContext(), "Enter the quantity of card50", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(qty50) == 0) {
                    Toast.makeText(getApplicationContext(), "can't enter quantity 0  ", Toast.LENGTH_LONG).show();
                } else if (tvPrice50.getText().toString() == "") {
                    Toast.makeText(getApplicationContext(), "first press GET_PRICE", Toast.LENGTH_LONG).show();
                } else {
                    //String price50=tvPrice50.getText().toString();
                    start50 = textView2.getText().toString();
                    //int end50 = start50 + num - 1;
                }
                count++;
            }else{qty50 = "0";}
            if (check100.isChecked()) {

                if (isEmpty(etq100)) {
                    qty100 = "0";
                    Toast.makeText(getApplicationContext(), "Enter the quantity of card100", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(qty100) == 0) {
                    Toast.makeText(getApplicationContext(), "can't enter quantity 0  ", Toast.LENGTH_LONG).show();
                } else if (tvPrice100.getText().toString() == "") {
                    Toast.makeText(getApplicationContext(), "first press GET_PRICE", Toast.LENGTH_LONG).show();
                } else {
                    //String price100=tvPrice100.getText().toString();
                    start100 = textView3.getText().toString();
                    //int end100 = start100 + num - 1;
                }
                count++;
            }else{qty100 = "0";}
            if (check500.isChecked()) {

                if (isEmpty(etq500)) {
                    qty500 = "0";
                    Toast.makeText(getApplicationContext(), "Enter the quantity of card500", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(qty500) == 0) {
                    Toast.makeText(getApplicationContext(), "can't enter quantity 0  ", Toast.LENGTH_LONG).show();
                } else if (tvPrice500.getText().toString() == "") {
                    Toast.makeText(getApplicationContext(), "first press GET_PRICE", Toast.LENGTH_LONG).show();
                } else {
                    //String price500=tvPrice500.getText().toString();
                    start500 = textView4.getText().toString();
                    //int end500 = start500 + num - 1;
                }
                count++;
            }else{qty500 = "0";}
            if (check1000.isChecked()) {

                if (isEmpty(etq1000)) {
                    qty1000 = "0";
                    Toast.makeText(getApplicationContext(), "Enter the quantity of card1000", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(qty1000) == 0) {
                    Toast.makeText(getApplicationContext(), "can't enter quantity 0  ", Toast.LENGTH_LONG).show();
                } else if (tvPrice1000.getText().toString() == "") {
                    Toast.makeText(getApplicationContext(), "first press GET_PRICE", Toast.LENGTH_LONG).show();
                } else {
                    //String price1000=tvPrice100.getText().toString();
                    start1000 = textView5.getText().toString();
                    //int end1000 = start100 + num - 1;
                }
                count++;
            }else{qty1000 = "0";}
            if (count == 0) {
                Toast.makeText(getApplicationContext(), "Select the Card Types", Toast.LENGTH_LONG).show();
            } else{
                String type="sell";
                BackgroundWorker backgroundWorker = new BackgroundWorker(this);
                backgroundWorker.execute(type,fseid,shopname,qty20,start20,qty50,start50,qty100,start100,qty500,start500,qty1000,start1000);
            }
        }
    }

    public void OnClickButtonReset(){
        btnReset =(Button)findViewById(R.id.btnreset);
        btnReset.setOnClickListener(
                new View.OnClickListener(){

                    public void onClick(View v){

                        tvPrice20.setText("");
                        tvPrice50.setText("");
                        tvPrice100.setText("");
                        tvPrice500.setText("");
                        tvPrice1000.setText("");
                        tvPriceTot.setText("0");

                        textView1end.setText("");
                        textView2end.setText("");
                        textView3end.setText("");
                        textView4end.setText("");
                        textView5end.setText("");

                        etq20.setText("");
                        etq50.setText("");
                        etq100.setText("");
                        etq500.setText("");
                        etq1000.setText("");

                        new BackgroundTask().execute();

                        if(check20.isChecked()){
                            check20.toggle();
                        }
                        if(check50.isChecked()){
                            check50.toggle();
                        }
                        if(check100.isChecked()){
                            check100.toggle();
                        }
                        if(check500.isChecked()){
                            check500.toggle();
                        }
                        if(check1000.isChecked()){
                            check1000.toggle();
                        }

                        new BackgroundTask().execute();
                    }
                }
        );
    }

    public class BackgroundTask extends AsyncTask<Void,Void,String> {

        String json_url;

        @Override
        protected void onPreExecute() {

            json_url="http://192.168.1.4/smartid/jasonCards.php"; //192.168.131.52  192.168.1.3
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

                String c20 = jsonObject.getString("card20");
                String c50 = jsonObject.getString("card50");
                String c100 = jsonObject.getString("card100");
                String c500 = jsonObject.getString("card500");
                String c1000 = jsonObject.getString("card1000");

                String count20 = jsonObject.getString("count20");
                String count50 = jsonObject.getString("count50");
                String count100 = jsonObject.getString("count100");
                String count500 = jsonObject.getString("count500");
                String count1000 = jsonObject.getString("count1000");

                textView1.setText(c20);
                textView2.setText(c50);
                textView3.setText(c100);
                textView4.setText(c500);
                textView5.setText(c1000);

                tcount20.setText(count20);
                tcount50.setText(count50);
                tcount100.setText(count100);
                tcount500.setText(count500);
                tcount1000.setText(count1000);

            }catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
