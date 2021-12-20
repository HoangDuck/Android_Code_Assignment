package com.example.bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Man2Activity extends AppCompatActivity {
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man2);
        addControls();
    }

    private void addControls() {
        txtKetQua=(TextView) findViewById(R.id.txtKetQua);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("MY_Bundle");
        txtKetQua.setText(bundle.getInt("X")+"\n"+bundle.getDouble("D")+"\n"+bundle.getSerializable("SANPHAM"));
    }
}