package com.example.tab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    ImageView imgHinh,imgHinh2,imgHinh3,imgHinh4,imgHinh5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                switch (s)
                {
                    case "t1":{
                        Toast.makeText(MainActivity.this,"I love you",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "t2":{
                        Toast.makeText(MainActivity.this,"I love you babe",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "t3":{
                        Toast.makeText(MainActivity.this,"I love you my little girl",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "t4":{
                        Toast.makeText(MainActivity.this,"I love you my love",Toast.LENGTH_LONG).show();
                        break;
                    }
                    case "t5":{
                        Toast.makeText(MainActivity.this,"I love you forever",Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });
    }

    private void addControls() {
        tabHost=findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tab1=tabHost.newTabSpec("t1");
        tab1.setIndicator("Love");
        //tab1.setIndicator("",getResource().getDrawable(R.id.music));music là tên file ảnh
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2=tabHost.newTabSpec("t2");
        tab2.setIndicator("LoveU");
        //tab1.setIndicator("",getResource().getDrawable(R.id.music));music là tên file ảnh
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);
        TabHost.TabSpec tab3=tabHost.newTabSpec("t3");
        tab3.setIndicator("LoveH");
        //tab1.setIndicator("",getResource().getDrawable(R.id.music));music là tên file ảnh
        tab3.setContent(R.id.tab3);
        tabHost.addTab(tab3);
        TabHost.TabSpec tab4=tabHost.newTabSpec("t4");
        tab4.setIndicator("Love");
        //tab1.setIndicator("",getResource().getDrawable(R.id.music));music là tên file ảnh
        tab4.setContent(R.id.tab4);
        tabHost.addTab(tab4);
        TabHost.TabSpec tab5=tabHost.newTabSpec("t5");
        tab5.setIndicator("Love");
        //tab1.setIndicator("",getResource().getDrawable(R.id.music));music là tên file ảnh
        tab5.setContent(R.id.tab5);
        tabHost.addTab(tab5);
        imgHinh=findViewById(R.id.imgHinh);
        imgHinh.setImageResource(R.drawable.avatar);
        imgHinh2=findViewById(R.id.imgHinh2);
        imgHinh2.setImageResource(R.drawable.qp);
        imgHinh3=findViewById(R.id.imgHinh3);
        imgHinh3.setImageResource(R.drawable.hoa);
        imgHinh4=findViewById(R.id.imgHinh4);
        imgHinh4.setImageResource(R.drawable.cntt);
        imgHinh5=findViewById(R.id.imgHinh5);
        imgHinh5.setImageResource(R.drawable.phuong);
    }
}