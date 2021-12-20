package com.example.imagebuttonimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton radNha,radNguoi;
    ImageView imgHinh;
    ImageButton btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        radNguoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    imgHinh.setImageResource(R.drawable.nguoi);
                }
            }
        });
        radNha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    imgHinh.setImageResource(R.drawable.nha);
                }
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControls() {
        radNha=(RadioButton) findViewById(R.id.radNha);
        radNguoi=(RadioButton) findViewById(R.id.radNguoi);
        imgHinh=(ImageView) findViewById(R.id.imgHinh);
        btnExit=(ImageButton) findViewById(R.id.btnExit);
    }
}