package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    EditText txtA,txtB;//co quyen dat ten khac nhung nen dat giong copy cho nhanh
    Button btnTru;
    Button btnNhan,btnChia;
    Button btnAn;
    Button btnExit;
    View.OnClickListener suKienChiaSe=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }//day la ham khoi taoview ctrl nen moi lenh deu viet sau ham nay

    private void addEvents() {
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyPhepTru();
            }
        });
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
        btnChia.setOnClickListener(suKienChiaSe);
        btnAn.setOnLongClickListener(this);
        btnExit.setOnClickListener(new MyEvent());
    }

    private void xuLyPhepChia() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a/b;
        Toast.makeText(MainActivity.this,"Chia ="+c,Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepNhan() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a*b;
        Toast.makeText(MainActivity.this,"Nhan ="+c,Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepTru() {
        int a=Integer.parseInt(txtA.getText().toString());
        int b=Integer.parseInt(txtB.getText().toString());
        int c=a-b;
        Toast.makeText(MainActivity.this,"Tru ="+c,Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        txtA= (EditText) findViewById(R.id.txtA);
        txtB= (EditText) findViewById(R.id.txtB);
        btnTru= (Button) findViewById(R.id.btnTru);
        btnNhan=(Button)findViewById(R.id.btnNhan);
        btnChia= (Button) findViewById(R.id.btnChia);
        btnAn= (Button) findViewById(R.id.btnAn);
        btnExit= (Button) findViewById(R.id.btnExit);
    }//ham khoi tao control

    public void xuLyPhepCong(View v)//dat ten bien j cx dc
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
    public class MyEvent implements View.OnClickListener, View.OnLongClickListener
    {

        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnExit)
            {
                finish();
            }
        }
    public void xuLyDoiManHinh (View view)
    {
        Button btnMoi=new Button(MainActivity.this)
        {
            @Override
            public boolean performClick() {
                setContentView(R.layout.activity_main);
                addControls();
                addEvents();
                return super.performClick();
            }
        };
        btnMoi.setText("quay ve");
        btnMoi.setWidth(200);
        btnMoi.setHeight(200);
        setContentView(btnMoi);
    }
}