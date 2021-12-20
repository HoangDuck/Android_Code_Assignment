package com.example.goint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtPhone,txtTN;
    Button btnSo,btnGoi,btnNT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyQuaySo();
            }
        });
        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyGoi();
            }
        });
        btnNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNT();
            }
        });
    }

    private void xuLyNT() {
        final SmsManager smsManager=SmsManager.getDefault();
        Intent intent=new Intent(Intent.ACTION_SEND);
        //Intent intent=new Intent("ACTION_MSG_SENT");
        final PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result=getResultCode();
                String msg="Send OK";
                if(result!= Activity.RESULT_OK)
                {
                    msg="Send failed";
                }
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        },new IntentFilter("ACTION_MSG_SENT)"));
        smsManager.sendTextMessage(txtPhone.getText().toString(),null,txtTN.getText()+"",pendingIntent,null);
    }

    private void xuLyGoi() {
        Uri uri=Uri.parse("tel:"+txtPhone.getText().toString());
        Intent intent=new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        startActivity(intent);
    }

    private void xuLyQuaySo() {
        Uri uri=Uri.parse("tel:"+txtPhone.getText().toString());
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }

    private void addControls() {
        txtPhone=findViewById(R.id.txtPhone);
        txtTN=findViewById(R.id.txtTN);
        btnSo=findViewById(R.id.btnSo);
        btnGoi=findViewById(R.id.btnGoi);
        btnNT=findViewById(R.id.btnNT);
    }
}