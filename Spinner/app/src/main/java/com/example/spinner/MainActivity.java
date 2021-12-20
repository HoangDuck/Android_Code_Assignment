package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spDS;
    ArrayList<String>dsTen;
    ArrayAdapter<String>adapter;
    int lastSelect=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        spDS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(lastSelect!=-1)
                {
                    Toast.makeText(MainActivity.this,dsTen.get(i),Toast.LENGTH_LONG).show();
                }
                lastSelect=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addControls() {
        spDS=findViewById(R.id.spDS);
        dsTen=new ArrayList<String>();
        dsTen.add(new String("sja"));
        dsTen.add(new String("dfa"));
        dsTen.add(new String("sha"));
        dsTen.add(new String("tra"));
        adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,dsTen);
        spDS.setAdapter(adapter);
    }
}