package com.example.truyendlkokqtv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.model.SinhVien;

public class MainActivity2 extends AppCompatActivity {
    TextView txtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
    }

    private void addControls() {
        txtKQ=findViewById(R.id.txtKQ);
        Intent intent=getIntent();
        boolean kieuBool=intent.getBooleanExtra("kieu bool",false);//doi so 2 la gia tri mac dinh
        char kieuChar=intent.getCharExtra("kieu char",'u');
        int kieuInt=intent.getIntExtra("kieu int",0);
        double kieuDouble=intent.getDoubleExtra("kieu double",0.00);
        String kieuchuoi=intent.getStringExtra("kieu chuoi");
        SinhVien kieuSV= (SinhVien) intent.getSerializableExtra("kieu sinh vien");

        txtKQ.setText("Kieu bool "+kieuBool+"\n"+
                "kieu char "+kieuChar+"\n"+
                "kieu int "+kieuInt+"\n"+
                "kieu double "+kieuDouble+"\n"+
                "kieu chuoi "+kieuchuoi+"\n"+
                "kieu sinh vien "+kieuSV);

    }
}