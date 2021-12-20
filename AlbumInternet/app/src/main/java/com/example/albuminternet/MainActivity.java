package com.example.albuminternet;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button btnTai;
    CheckBox chkAuto;
    ImageView imgHinh;
    ArrayList<String>dsHinh;
    String link1="https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/140583066_472270690845019_1530172539950251892_o.jpg?_nc_cat=108&ccb=2&_nc_sid=8bfeb9&_nc_ohc=9SW6avTidaMAX99Riyt&_nc_ht=scontent.fhan4-1.fna&oh=6ffff873fa84c062dc2775748e5a72db&oe=6045B6FC";
    String link2="https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/133728554_247930446681891_8920792622739484154_o.jpg?_nc_cat=108&ccb=2&_nc_sid=8bfeb9&_nc_ohc=CnYBZwPhupIAX-Acy01&_nc_ht=scontent.fhan4-1.fna&oh=40a64f1dd0799ba57b3f74b2de7dd07f&oe=6043D07A";
    int currentPosition=-1;
    Timer timer=null;
    TimerTask timerTask=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTai();
            }
        });
        chkAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true)
                {
                    btnTai.setEnabled(false);
                    tuDongChay();
                }
                else
                {
                    btnTai.setEnabled(true);
                    if(timer!=null)
                        timer.cancel();
                }

            }
        });
    }

    private void tuDongChay() {
        timerTask=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        currentPosition++;
                        if(currentPosition==dsHinh.size())
                            currentPosition=0;
                        ImageTask imageTask=new ImageTask();
                        imageTask.execute(dsHinh.get(currentPosition));
                    }
                });
            }
        };
        timer=new Timer();
        timer.schedule(timerTask,0,5000);
    }

    private void xuLyTai() {
        currentPosition++;
        if(currentPosition==dsHinh.size())
            currentPosition=0;
        ImageTask imageTask=new ImageTask();
        imageTask.execute(dsHinh.get(currentPosition));
    }
    class ImageTask extends AsyncTask<String,Void,Bitmap>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgHinh.setImageBitmap(bitmap);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try{
                String link=strings[0];
                Bitmap bitmap= BitmapFactory.decodeStream((InputStream) new URL(link).getContent());
                return bitmap;
            }catch (Exception ex)
            {
                Log.e("LOI",ex.toString());
            }
            return null;
        }
    }
    private void addControls() {
        btnTai=findViewById(R.id.btnTai);
        chkAuto=findViewById(R.id.chkAuto);
        imgHinh=findViewById(R.id.imgHinh);
        dsHinh=new ArrayList<String>();
        dsHinh.add(link1);
        dsHinh.add(link2);
        currentPosition=0;
        ImageTask imageTask=new ImageTask();
        imageTask.execute(dsHinh.get(currentPosition));

    }
}