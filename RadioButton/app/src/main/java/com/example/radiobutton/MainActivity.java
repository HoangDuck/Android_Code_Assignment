package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton radTot,radKha,radBt,radTe;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvents();
    }

    private void addEvents() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyBinhChon();
            }
        });
    }

    private void xuLyBinhChon() {
        String s="";
        if(radTot.isChecked())
        {
            s+=radTot.getText().toString();
        }
        else if(radKha.isChecked())
        {
            s+=radKha.getText().toString();
        }
        else if(radBt.isChecked())
        {
            s+=radBt.getText().toString();
        }
        else if(radTe.isChecked())
        {
            s+=radTe.getText().toString();
        }
        Toast.makeText(MainActivity.this,"ban chon "+s,Toast.LENGTH_LONG).show();
    }

    private void addControl() {
        radTot=(RadioButton) findViewById(R.id.radTot);
        radKha=(RadioButton) findViewById(R.id.radKha);
        radBt=(RadioButton) findViewById(R.id.radBt);
        radTe=(RadioButton) findViewById(R.id.radTe);
        btnSubmit=(Button) findViewById(R.id.btnSubmit);
    }
}