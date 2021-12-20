package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.AdapterList;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView lvDSThu;
    String []arrThu;
    ArrayAdapter<String>adapterThu;
    AdapterList adapterList;
    boolean adapterViewList=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvDSThu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Ban chon: "+i,Toast.LENGTH_LONG).show();
            }
        });
        lvDSThu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterViewList)
                {
                    lvDSThu.setAdapter(adapterList);
                    adapterViewList=false;
                }
                else {
                    lvDSThu.setAdapter(adapterThu);
                    adapterViewList=true;
                }
                return false;
            }
        });
    }

    private void addControls() {
        lvDSThu=findViewById(R.id.lvDSThu);
        arrThu=getResources().getStringArray(R.array.arrThu);
        adapterThu=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,arrThu);
        adapterList=new AdapterList(MainActivity.this,R.layout.item, Arrays.asList(arrThu));
        lvDSThu.setAdapter(adapterThu);
    }
}