package com.example.nhackaraoke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.adapter.MusicAdapter;
import com.example.mucsic.Music;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDsBaiGoc;
    ArrayList<Music>dsBaiGoc;
    MusicAdapter adapterBaiGoc;
    ListView lvLike;
    ArrayList<Music>dsBaiThich;
    MusicAdapter adapterBaiThich;
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
            public void onTabChanged(String tabId) {
                if(tabId.equalsIgnoreCase("t1"))
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

    }

    private void addControls() {
        tabHost=findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tab1=tabHost.newTabSpec("t1");
        tab1.setIndicator("Bài Hát");
        //tab1.setIndicator("",getResource().getDrawable(R.id.music));music là tên file ảnh
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2= tabHost.newTabSpec("t2");
        tab2.setIndicator("Yêu Thích");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);
        lvDsBaiGoc=(ListView)findViewById(R.id.lvDsBaiGoc);
        dsBaiGoc=new ArrayList<>();
        adapterBaiGoc=new MusicAdapter(MainActivity.this,R.layout.item,dsBaiGoc);
        lvDsBaiGoc.setAdapter(adapterBaiGoc);
        lvLike=(ListView) findViewById(R.id.lvLike);
        dsBaiThich=new ArrayList<>();
        adapterBaiThich=new MusicAdapter(MainActivity.this,R.layout.item,dsBaiThich);
        lvLike.setAdapter(adapterBaiThich);
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