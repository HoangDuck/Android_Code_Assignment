package com.example.autocompletetext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtTen;
    AutoCompleteTextView autoMa;
    Button btnXacNhan;
    TextView txtThongTin;
    String []arrMa;
    ArrayAdapter<String>adapterMa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXacNhan();
            }
        });
    }

    private void xuLyXacNhan() {
        String s=txtTen.getText().toString()+"\n"+autoMa.getText().toString();
        txtTen.setText(s);
    }

    private void addControls() {
        txtTen=(EditText) findViewById(R.id.txtTen);
        btnXacNhan=(Button)findViewById(R.id.btnXacNhan);
        txtThongTin=(TextView)findViewById(R.id.txtThongTin);
        autoMa=(AutoCompleteTextView) findViewById(R.id.autoMa);
        arrMa=getResources().getStringArray(R.array.arrMa);
        adapterMa=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arrMa);
        autoMa.setAdapter(adapterMa);
    }
}