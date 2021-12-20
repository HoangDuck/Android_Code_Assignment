package com.example.maytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    EditText txtA,txtB;
    Button btnCong,btnTru,btnNhan,btnChia,btnAn,btnExit,btnDoi;
    View.OnClickListener suKienChiaSe=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyPhepTru();
            }
        });//anomous listener
        suKienChiaSe=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.btnNhan)
                {
                    xuLyPhepNhan();
                }
                else
                {
                    if(view.getId()==R.id.btnChia)
                    {
                        xuLyPhepChia();
                    }
                }
            }
        };
        btnNhan.setOnClickListener(suKienChiaSe);
        btnChia.setOnClickListener(suKienChiaSe);//variable listener
        btnAn.setOnLongClickListener(this);//activity listener
        btnExit.setOnClickListener(new MyEvents());//explicit class listener
    }

    private void xuLyPhepChia() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a/b;
        Toast.makeText(MainActivity.this,"Tong ="+c,Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepNhan() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a*b;
        Toast.makeText(MainActivity.this,"Tong ="+c,Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepTru() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a-b;
        Toast.makeText(MainActivity.this,"Tong ="+c,Toast.LENGTH_LONG).show();
    }//anomous listener

    private void addControls() {
        txtA=findViewById(R.id.txtA);
        txtB=findViewById(R.id.txtB);
        btnCong=findViewById(R.id.btnCong);
        btnTru=findViewById(R.id.btnTru);
        btnNhan=findViewById(R.id.btnNhan);
        btnChia=findViewById(R.id.btnChia);
        btnAn=findViewById(R.id.btnAn);
        btnExit=findViewById(R.id.btnExit);
        btnDoi=findViewById(R.id.btnDoi);//view sub classing
    }

    public void xuLyPhepCong(View v)//on click listenerXML
    {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a+b;
        Toast.makeText(MainActivity.this,"Tong ="+c,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId()==R.id.btnAn)
        {
            btnAn.setVisibility(View.INVISIBLE);
        }
        return false;
    }
    public class MyEvents implements View.OnClickListener, View.OnLongClickListener{

        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnExit)
            {
                finish();
            }
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
    public void xuLyDoiManHinh(View view)
    {//Linear
        Button btnMoi=new androidx.appcompat.widget.AppCompatButton(MainActivity.this)
        {
            @Override
            public boolean performClick() {
                setContentView(R.layout.activity_main);
                addControls();
                addEvents();
                return super.performClick();
            }
        };
        btnMoi.setText("Back");
        btnMoi.setWidth(200);
        btnMoi.setHeight(200);
        setContentView(btnMoi);//doi giao dien moi
    }
}