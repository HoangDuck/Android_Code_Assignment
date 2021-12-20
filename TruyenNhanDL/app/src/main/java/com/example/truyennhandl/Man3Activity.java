package com.example.truyennhandl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.model.SinhVien;

public class Man3Activity extends AppCompatActivity {
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man3);
        addControls();
    }
    private void addControls() {
        txtKetQua=(TextView) findViewById(R.id.txtKetQua);
        Intent intent=getIntent();
        boolean kieuBoolean=intent.getBooleanExtra("KIEU_BOOL",false);
        char kieuChar=intent.getCharExtra("KIEU_CHAR",'w');
        int kieuInt=intent.getIntExtra("KIEU_INT",0);
        double kieuDouble=intent.getDoubleExtra("KIEU_DOUBLE",0.00);
        String kieuChuoi=intent.getStringExtra("KIEU_CHUOI");
        SinhVien sv=(SinhVien) intent.getSerializableExtra("SINHVIEN");
        txtKetQua.setText(kieuBoolean+"\n"+kieuChar+"\n"+kieuInt+"\n"+kieuDouble+"\n"+kieuChuoi+"\n"+sv);
    }
}