package com.example.truyendlkokqtv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import com.example.model.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyMoVaGui(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("Kieu bool",true);
        intent.putExtra("kieu char",'x');
        intent.putExtra("kieu int",100);
        intent.putExtra("kieu double",15.99);
        intent.putExtra("kieu chuoi","hoang huu duc");
        SinhVien sv=new SinhVien("Hoang Huu Duc","19110349");
        /*ArrayList<SinhVien>dsSV=new ArrayList<SinhVien>();
        dsSV.add(sv);
        intent.putParcelableArrayListExtra("DS", (ArrayList<? extends Parcelable>) dsSV);
        Bundle bundle=new Bundle();
        bundle.putStringArrayList("DS");*/
        //dua danh sach contact vao lop co array list r them intent
        intent.putExtra("kieu sinh vien",sv);
        startActivity(intent);
    }
}