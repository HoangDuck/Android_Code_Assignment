package com.example.asynctask1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText txtNhapSL;
    Button btnNhap;
    ProgressBar progressBarPercent;
    LinearLayout layoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyVeButton();
            }
        });
    }

    private void xuLyVeButton() {
        int n=Integer.parseInt(txtNhapSL.getText().toString());
        ButtonTask buttonTask=new ButtonTask();
        buttonTask.execute(n);
    }
    class ButtonTask extends AsyncTask<Integer,Integer,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            layoutButton.removeAllViews();
            progressBarPercent.setProgress(0);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressBarPercent.setProgress(100);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int value=values[1];
            int percent=values[0];
            progressBarPercent.setProgress(percent);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
            ,LinearLayout.LayoutParams.WRAP_CONTENT);
            Button btn=new Button(MainActivity.this);
            btn.setLayoutParams(params);
            btn.setText(value+"");
            layoutButton.addView(btn);
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int n=integers[0];
            Random random=new Random();
            for(int i=0;i<n;i++)
            {
                int percent=i*100/n;
                int value=random.nextInt(500);
                publishProgress(percent,value);
                SystemClock.sleep(100);
            }
            return null;
        }
    }
    private void addControls() {
        txtNhapSL=findViewById(R.id.txtNhapSL);
        btnNhap=findViewById(R.id.btnNhap);
        progressBarPercent=findViewById(R.id.progressBarPecent);
        layoutButton=findViewById(R.id.layoutButton);
    }
}