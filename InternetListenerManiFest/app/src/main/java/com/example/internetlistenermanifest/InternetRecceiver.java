package com.example.internetlistenermanifest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class InternetRecceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "default";
    int notificationId=113;
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo()!=null)
        {
            Toast.makeText(context, "Co internet", Toast.LENGTH_SHORT).show();
            taoThongBao(context);
        }
    }

    private void taoThongBao(Context context) {
        createNotificationChannel(context);
        //tao builder
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Thong bao")
                .setContentText("Mo ra xem di")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        //tao peding intent
        Intent intent=new Intent(context,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
        //gan thanh phan cho builder
        builder.setContentIntent(pendingIntent);
        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);
        /*Uri sound=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.TEN_FILE_NHAC);
        builder.setSound(sound);*/
        //kich hoat notification

        NotificationManagerCompat notificationManager= NotificationManagerCompat.from(context);
        notificationManager.notify(notificationId,builder.build());
    }

    private void createNotificationChannel(Context context) {
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
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
