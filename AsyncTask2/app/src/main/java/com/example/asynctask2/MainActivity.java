package com.example.asynctask2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnTai;
    ImageView imgHinh;
    ProgressDialog progressDialog;
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
    }

    private void xuLyTai() {
        String link1="https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/140583066_472270690845019_1530172539950251892_o.jpg?_nc_cat=108&ccb=2&_nc_sid=8bfeb9&_nc_ohc=9SW6avTidaMAX99Riyt&_nc_ht=scontent.fhan4-1.fna&oh=6ffff873fa84c062dc2775748e5a72db&oe=6045B6FC";
        String link2="https://scontent.fhan4-1.fna.fbcdn.net/v/t1.0-9/133728554_247930446681891_8920792622739484154_o.jpg?_nc_cat=108&ccb=2&_nc_sid=8bfeb9&_nc_ohc=CnYBZwPhupIAX-Acy01&_nc_ht=scontent.fhan4-1.fna&oh=40a64f1dd0799ba57b3f74b2de7dd07f&oe=6043D07A";
        ImageTask imageTask=new ImageTask();
        imageTask.execute(link1,link2);
    }
    class ImageTask extends AsyncTask<String, Void,Bitmap>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgHinh.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                Random random=new Random();
                int i=random.nextInt(2);
                String link=strings[i];
                Bitmap bitmap=BitmapFactory.decodeStream((InputStream) new URL(link).getContent());
                return  bitmap;
            }
            catch(Exception ex)
            {
                Log.e("LOI",ex.toString());
            }
            return null;
        }
    }
    private void addControls() {
        btnTai=findViewById(R.id.btnTai);
        imgHinh=findViewById(R.id.imgHinh);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Thong bao");
        progressDialog.setMessage("Dang tai");
        progressDialog.setCanceledOnTouchOutside(false);
    }
}