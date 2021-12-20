package com.example.internetlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnYes,btnNo;
    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if(connectivityManager.getActiveNetworkInfo()!=null)
            {
                btnYes.setEnabled(true);
                btnNo.setEnabled(false);
                Toast.makeText(context,"Co internet",Toast.LENGTH_LONG).show();
            }
            else
            {
                btnYes.setEnabled(false);
                btnNo.setEnabled(true);
                Toast.makeText(context,"Khong co internet",Toast.LENGTH_LONG).show();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        btnYes=findViewById(R.id.btnYes);
        btnNo=findViewById(R.id.btnNo);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(broadcastReceiver!=null)
        {
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        //intentFilter.addAction(); muon lang nghe them su kien khac
        registerReceiver(broadcastReceiver,intentFilter);
    }
}