package com.example.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.DanhBaAdapter;
import com.example.model.DanhBa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhBa;
    ArrayList<DanhBa>danhBa;
    DanhBaAdapter danhBaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvDanhBa=findViewById(R.id.lvDanhBa);
        danhBa=new ArrayList<DanhBa>();
        danhBa.add(new DanhBa("Hoàng Hữu Đức","19110349"));
        danhBa.add(new DanhBa("Nguyễn Văn Tèo","19110340"));
        danhBa.add(new DanhBa("Trần Thị Tý","19110341"));
        danhBaAdapter=new DanhBaAdapter(MainActivity.this,R.layout.item,danhBa);
        lvDanhBa.setAdapter(danhBaAdapter);
    }
}