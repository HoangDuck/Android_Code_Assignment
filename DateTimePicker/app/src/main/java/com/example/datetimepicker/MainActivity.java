package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView txtDate,txtTime;
    ImageButton btnDate,btnTime;
    Calendar calendar=Calendar.getInstance();
    SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2=new SimpleDateFormat("HH/mm");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyHienThiDatePicker();
            }
        });
    }

    private void xuLyHienThiDatePicker() {
        DatePickerDialog datePickerDialog=new DatePickerDialog()
    }

    private void addControls() {
        txtDate=(TextView) findViewById(R.id.txtDate);
        txtTime=(TextView) findViewById(R.id.txtTime);
        btnDate=(ImageButton)findViewById(R.id.btnDate);
        btnTime=(ImageButton)findViewById(R.id.btnTime);
        calendar=Calendar.getInstance();
        txtDate.setText(sdf1.format(calendar.getTime()));
        txtTime.setText(sdf2.format(calendar.getTime()));
    }
}