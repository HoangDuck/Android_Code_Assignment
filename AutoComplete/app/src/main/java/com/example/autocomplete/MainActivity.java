package com.example.autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoTinh;
    String []arrTinh;
    ArrayAdapter<String>adapter;
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
        autoTinh=findViewById(R.id.autoTinh);
        arrTinh=getResources().getStringArray(R.array.arrTinh);
        adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,arrTinh);
        autoTinh.setAdapter(adapter);
    }
}