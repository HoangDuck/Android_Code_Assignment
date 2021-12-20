package com.example.listcbdldong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtTen;
    Button btnLuu;
    ListView lvTen;
    ArrayList<String>arrTen;
    ArrayAdapter<String>adapterTen;
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
                xuLyLuu();
            }
        });
        lvTen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Ban chon "+i,Toast.LENGTH_LONG).show();
            }
        });
    }

    private void xuLyLuu() {
        String ten=txtTen.getText().toString();
        arrTen.add(ten);
        adapterTen.notifyDataSetChanged();
        txtTen.setText("");
        txtTen.requestFocus();
    }

    private void addControls() {
        txtTen=findViewById(R.id.txtTen);
        btnLuu=findViewById(R.id.btnLuu);
        lvTen=findViewById(R.id.lvTen);
        arrTen=new ArrayList<String>();
        adapterTen=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,arrTen);
        lvTen.setAdapter(adapterTen);
    }
}