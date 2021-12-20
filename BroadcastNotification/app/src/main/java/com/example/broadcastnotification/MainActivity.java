package com.example.broadcastnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "default";
    Button btnTao,btnDong;
    int notificationId=113;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taoNotification();
            }
        });
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dongNotification();
            }
        });
    }

    private void dongNotification() {
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(notificationId);
        //notificationManager.cancelAll();
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = /*getString(R.string.channel_name);*/"djs";
            String description = /*getString(R.string.channel_description);*/"sjd";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void taoNotification() {
        createNotificationChannel();
        //tao builder
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Thong bao")
                .setContentText("Mo ra xem di")
                //.setWhen()hien thoi gian thong bao
                //.setLargeIcon()bieu tuong lon
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        //tao peding intent
        Intent intent=new Intent(this,UpdateActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        //gan thanh phan cho builder
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);
        /*Uri sound=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.TEN_FILE_NHAC);
        builder.setSound(sound);*/
        //kich hoat notification

        NotificationManagerCompat notificationManager= NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId,builder.build());
    }

    private void addControls() {
        btnTao=findViewById(R.id.btnTao);
        btnDong=findViewById(R.id.btnDong);
    }
}