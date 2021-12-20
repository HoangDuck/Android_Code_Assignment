package com.example.truyendlcokq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtNhan;
    Button btnTinh;
    Intent intent;
    int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTinh();
            }
        });
    }

    private void xuLyTinh() {
        int min;
        if(a<=b)
        {
            min=a;
        }
        else
        {
            min=b;
        }
        intent.putExtra("Min",min);
        setResult(33,intent);
        finish();
    }

    private void addControls() {
        txtNhan=findViewById(R.id.txtNhan);
        btnTinh=findViewById(R.id.btnTinh);
        intent=getIntent();
        a=intent.getIntExtra("A",0);
        b=intent.getIntExtra("B",0);
        txtNhan.setText("A= "+a+";"+"B= "+b);
    }
}