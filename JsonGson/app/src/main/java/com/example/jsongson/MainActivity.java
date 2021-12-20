package com.example.jsongson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.model.GoogleData;
import com.example.model.Result;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtNhap;
    Button btnNhap;
    ListView lvKQ;
    ArrayList<Result>ds;
    ArrayAdapter<Result>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleDataTask googleDataTask=new GoogleDataTask();
                googleDataTask.execute(txtNhap.getText().toString());
            }
        });
    }
    class GoogleDataTask extends AsyncTask<String,Void,ArrayList<Result>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            arrayAdapter.clear();
        }

        @Override
        protected void onPostExecute(ArrayList<Result> results) {
            super.onPostExecute(results);
            arrayAdapter.clear();
            arrayAdapter.addAll(results);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Result> doInBackground(String... strings) {
            ArrayList<Result>dsTim=new ArrayList<Result>();
            try{
                String keyword=strings[0];
                String link="http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
                String address=link+ URLEncoder.encode(keyword,"UTF-8")+"&start="+1+"&rsz=8";
                URL url=new URL(address);
                InputStreamReader inputStreamReader=new InputStreamReader(url.openStream(),"UTF-8");
                GoogleData googleData=new Gson().fromJson(inputStreamReader,GoogleData.class);
                return googleData.getResponseData().getResults();
            }catch (Exception exception)
            {
                Log.e("LOI",exception.toString());
            }
            return dsTim;
        }
    }
    private void addControls() {
        txtNhap=findViewById(R.id.txtNhap);
        btnNhap=findViewById(R.id.btnNhap);
        lvKQ=findViewById(R.id.lvKQ);
        ds=new ArrayList<Result>();
        arrayAdapter=new ArrayAdapter<Result>(MainActivity.this, android.R.layout.simple_list_item_1,ds);
        lvKQ.setAdapter(arrayAdapter);
    }
}