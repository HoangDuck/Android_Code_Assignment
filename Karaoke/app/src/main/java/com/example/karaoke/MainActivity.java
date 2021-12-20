package com.example.karaoke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.adapter.AdapterMusic;
import com.example.model.Music;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvBaiGoc,lvBaiThich;
    ArrayList<Music>dsBaiGoc,dsBaiThich;
    AdapterMusic adapterBaiGoc,adapterBaiThich;
    TabHost tabHost;
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
                if(s.equalsIgnoreCase("t1"))
                {
                    xuLyHienThiBaiGoc();
                }
                else
                {
                    xuLyHienThiBaiThich();
                }
            }
        });
    }

    private void xuLyHienThiBaiThich() {
        dsBaiThich.clear();
        for(Music music:dsBaiGoc)
        {
            if(music.isLike())
                dsBaiThich.add(music);
        }
        adapterBaiThich.notifyDataSetChanged();
    }

    private void xuLyHienThiBaiGoc() {
        adapterBaiGoc.notifyDataSetChanged();
    }

    private void addControls() {
        lvBaiGoc=findViewById(R.id.lvBaiGoc);
        lvBaiThich=findViewById(R.id.lvBaiThich);
        dsBaiGoc=new ArrayList<Music>();
        dsBaiThich=new ArrayList<Music>();
        adapterBaiGoc=new AdapterMusic(MainActivity.this,R.layout.item,dsBaiGoc);
        adapterBaiThich=new AdapterMusic(MainActivity.this,R.layout.item,dsBaiThich);
        lvBaiGoc.setAdapter(adapterBaiGoc);
        lvBaiThich.setAdapter(adapterBaiThich);
        tabHost=findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tab1=tabHost.newTabSpec("t1");
        tab1.setIndicator("Bai hat");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2=tabHost.newTabSpec("t2");
        tab2.setIndicator("Yeu thich");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);
        giaLapDuLieu();
    }

    private void giaLapDuLieu() {
        dsBaiGoc.add(new Music("1","Còn Lại Một Mình","Đan Trường",false));
        dsBaiGoc.add(new Music("2","Đợi Chờ Phố Xưa","Đan Trường",false));
        dsBaiGoc.add(new Music("3","Những Mùa Dấu Yêu","Đan Trường",false));
        dsBaiGoc.add(new Music("4","Chờ Trên Tháng Năm","Đan Trường",false));
        dsBaiGoc.add(new Music("5","Hát Cho Mùa Yêu Xưa","Đan Trường",false));
        adapterBaiGoc.notifyDataSetChanged();
    }
}
