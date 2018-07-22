package com.example.prabashdananjaya.smart;

import android.content.Intent;
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

public class LogActivity extends AppCompatActivity {

    String JSON_STRING;

    private EditText etus;
    private EditText etpass;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_main);

        etus=(EditText)findViewById(R.id.tUserName);
        etpass=(EditText)findViewById(R.id.tPassword);

        //textView=(TextView)findViewById(R.id.textView2);

        //new BackgroundLogin().execute(uname,pass);
    }
    private boolean isEmpty(EditText etText) {

        return etText.getText().toString().trim().length() == 0;
    }

    public void onLogin(View view){

        /*if(isEmpty(etus)){
            Toast.makeText(getApplicationContext(), "Please enter a valid username", Toast.LENGTH_LONG).show();

        }
        else{
            if(isEmpty(etpass)) {
                Toast.makeText(getApplicationContext(), "Please enter a valid password", Toast.LENGTH_LONG).show();
            }
            else{*/
                String uname=etus.getText().toString();
                String pass=etpass.getText().toString();

                new BackgroundLogin().execute(uname,pass);

           // }

        //}

    }

    public class BackgroundLogin extends AsyncTask<String,Void,String> {

        String json_url;

        @Override
        protected void onPreExecute() {

            json_url="http://192.168.1.4/smartid/jasonLogin.php"; //192.168.131.52  192.168.1.3
        }

        @Override
        protected String doInBackground(String... params) {

            //String fseid="fse1";

            String username=params[0];
            String password=params[1];

            try{
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream= httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                //set posting data
                String post_data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

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

            //textView.setText(result);


            try {

                JSONObject reader= new JSONObject(result);

                JSONObject jsonObject = reader.getJSONObject("server_response");

                String fseid="1";

                fseid = jsonObject.getString("id");

                int check=Integer.parseInt(fseid);

                //textView.setText(fseid);

                if(check==0){
                    Toast.makeText(getApplicationContext(),"Invalid Login..Try Again..",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent("com.example.prabashdananjaya.smart.HomeActivity");
                    intent.putExtra("fseid",fseid);
                    startActivity(intent);
                }


            }catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
