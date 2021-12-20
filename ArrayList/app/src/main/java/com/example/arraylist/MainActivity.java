package com.example.arraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>arrTen;
    ArrayAdapter<String>adapterTen;
    ListView lvTen;
    EditText txtTen;
    Button btnLuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLuuDuLieu();
            }
        });
    }

    private void xuLyLuuDuLieu() {
        String ten=txtTen.getText().toString();
        arrTen.add(ten);
        adapterTen.notifyDataSetChanged();
        txtTen.setText("");
        txtTen.requestFocus();
    }

    private void addControls() {
        arrTen=new ArrayList<String>();
        adapterTen=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arrTen);
        lvTen=(ListView)findViewById(R.id.lvTen);
        lvTen.setAdapter(adapterTen);
        txtTen=(EditText)findViewById(R.id.txtTen);
        btnLuu=(Button)findViewById(R.id.btnLuu);
    }
}