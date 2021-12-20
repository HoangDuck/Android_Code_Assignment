package com.example.contentproviders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDoc,btnDocTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyDoc();
            }
        });
    }

    private void xuLyDoc() {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);

    }

    private void addControls() {
        btnDoc=findViewById(R.id.btnDoc);
    }

    public void xuLyDocTinNhan(View view) {
        Intent intent=new Intent(MainActivity.this,MainActivity3.class);
        startActivity(intent);
    }
}