package com.example.bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.model.SanPham;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyBundle(View view) {
        Intent intent=new Intent(MainActivity.this,Man2Activity.class);
        Bundle bundle=new Bundle();
        bundle.putInt("X",113);
        bundle.putDouble("D",114.115);
        SanPham sp=new SanPham(1,"Coca",15.58);
        bundle.putSerializable("SANPHAM",sp);
        intent.putExtra("MY_Bundle",bundle);
        startActivity(intent);
    }
}