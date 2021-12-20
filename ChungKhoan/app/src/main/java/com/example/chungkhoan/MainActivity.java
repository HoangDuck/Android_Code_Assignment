package com.example.chungkhoan;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.adapter.TiGiaAdapter;
import com.example.model.TiGia;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTiGia;
    ArrayList<TiGia>dsTiGia;
    TiGiaAdapter tiGiaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {

    }
    class TiGiaTask extends AsyncTask<Void,Void,ArrayList<TiGia>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tiGiaAdapter.clear();
        }

        @Override
        protected void onPostExecute(ArrayList<TiGia> tiGias) {
            super.onPostExecute(tiGias);
            tiGiaAdapter.clear();
            tiGiaAdapter.addAll(tiGias);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<TiGia> doInBackground(Void... voids) {
            ArrayList<TiGia>ds=new ArrayList<TiGia>();
            try{
                URL url=new URL("http://dongabank.com.vn/exchange/export");
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type","application/json;charset=utf-8");
                connection.setRequestProperty("User-Agent","Mozilla/5.0 (compitable)");
                connection.setRequestProperty("Accept","*/*");
                InputStream inputStream=connection.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String line=bufferedReader.readLine();
                StringBuilder stringBuilder=new StringBuilder();
                while (line!=null)
                {
                    stringBuilder.append(line);
                    line=bufferedReader.readLine();
                }
                String json=stringBuilder.toString();
                json=json.replace("(","");
                json=json.replace(")","");
                JSONObject jsonObject=new JSONObject(json);
                JSONArray jsonArray=jsonObject.getJSONArray("item");
                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject item=jsonArray.getJSONObject(i);
                    TiGia tiGia=new TiGia();
                    if(item.has("type"))
                    {
                        tiGia.setType(item.getString("type"));
                    }
                    if(item.has("imageurl"))
                    {
                        tiGia.setImageurl(item.getString("imageurl"));
                        url=new URL(tiGia.getImageurl());
                        connection= (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("Content-type","application/json;charset=utf-8");
                        connection.setRequestProperty("User-Agent","Mozilla/5.0 (compitable)");
                        connection.setRequestProperty("Accept","*/*");
                        Bitmap bitmap= BitmapFactory.decodeStream(connection.getInputStream());
                        tiGia.setBitmap(bitmap);
                        tiGia.setBanck(item.getString("banck"));
                        tiGia.setBantienmat(item.getString("bantienmat"));
                        tiGia.setMuack(item.getString("muack"));
                        tiGia.setMuatienmat(item.getString("muatienmat"));
                        ds.add(tiGia);
                    }

                }
            }catch (Exception exception)
            {
                Log.e("LOI",exception.toString());
            }
            return ds;
        }
    }
    private void addControls() {
        lvTiGia=findViewById(R.id.lvTiGia);
        dsTiGia=new ArrayList<TiGia>();
        tiGiaAdapter=new TiGiaAdapter(MainActivity.this,R.layout.item,dsTiGia);
        lvTiGia.setAdapter(tiGiaAdapter);
        TiGiaTask tiGiaTask=new TiGiaTask();
        tiGiaTask.execute();
    }
}