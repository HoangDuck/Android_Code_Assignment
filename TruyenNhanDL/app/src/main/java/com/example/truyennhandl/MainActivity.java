package com.example.truyennhandl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.model.SinhVien;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyMoManHinh(View view) {
        Intent intent=new Intent(MainActivity.this,Man2Activity.class);
        startActivity(intent);
    }

    public void xuLyMoGui(View view) {
        Intent intent=new Intent(MainActivity.this,Man3Activity.class);
        intent.putExtra("KIEU_BOOL",true);
        intent.putExtra("KIEU_CHAR",'x');
        intent.putExtra("KIEU_INT",100);
        intent.putExtra("KIEU_DOUBLE",100.15);
        intent.putExtra("KIEU_CHUOI","HELLO");
        SinhVien sv=new SinhVien(19110349,"Hoang Huu Duc");
        intent.putExtra("SINHVIEN",sv);
        startActivity(intent);
    }
}