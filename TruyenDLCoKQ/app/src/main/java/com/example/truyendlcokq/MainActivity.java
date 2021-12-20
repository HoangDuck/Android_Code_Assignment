package com.example.truyendlcokq;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtA,txtB;
    Button btnXuLy;
    TextView txtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyKQ();
            }
        });
    }

    private void xuLyKQ() {
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("A",Integer.parseInt(txtA.getText().toString()));
        intent.putExtra("B",Integer.parseInt(txtB.getText().toString()));
        startActivityForResult(intent,99);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==99&&resultCode==33)
        {
            txtKQ.setText("KQ= "+data.getIntExtra("Min",-1));
        }
    }

    private void addControls() {
        txtA=findViewById(R.id.txtA);
        txtB=findViewById(R.id.txtB);
        btnXuLy=findViewById(R.id.btnXuLy);
        txtKQ=findViewById(R.id.txtKQ);
    }
}