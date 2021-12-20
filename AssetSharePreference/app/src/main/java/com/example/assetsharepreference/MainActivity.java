package com.example.assetsharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView lvView;
    ArrayList<String>ds;
    ArrayAdapter<String>adapter;
    ImageView imgHinh;
    String ten="TrangThai";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                xuLyChon(i);
            }
        });
    }

    private void xuLyChon(int i) {
        Typeface typeface=Typeface.createFromAsset(getAssets(),"picture/"+ds.get(i));
        Drawable drawable=Drawable.createFromPath("assets/picture/"+ds.get(i));
        
        imgHinh.setImageDrawable(drawable);
        SharedPreferences sharedPreferences=getSharedPreferences(ten,MODE_PRIVATE);//luon khac null
        SharedPreferences.Editor editor=sharedPreferences.edit();//luu file
        editor.putString("Anh","picture/"+ds.get(i));
        editor.commit();
    }

    private void addControls() {
        lvView=findViewById(R.id.lvView);
        ds=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,ds);
        imgHinh=findViewById(R.id.imgHinh);
        lvView.setAdapter(adapter);
        AssetManager assetManager=getAssets();
        try{
            String []arr=assetManager.list("music");
            ds.addAll(Arrays.asList(arr));
            String[] dsHinh=assetManager.list("picture");
            ds.addAll(Arrays.asList(dsHinh));
            SharedPreferences sharedPreferences=getSharedPreferences(ten,MODE_PRIVATE);//luon khac null
            String anh=sharedPreferences.getString("Anh","");
            if(anh.length()!=0)
            {
                Typeface typeface=Typeface.createFromAsset(getAssets(),anh);
                //setTypeface
            }
        }catch (Exception exception)
        {
            Log.e("Loi",exception.toString());
        }

    }
}