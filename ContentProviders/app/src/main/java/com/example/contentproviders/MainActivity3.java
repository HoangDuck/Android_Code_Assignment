package com.example.contentproviders;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ListView lvTinNhan;
    ArrayList<String>dsTinNhan;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        addControls();
        addEvents();
        readSMSFromPhone();
    }

    private void readSMSFromPhone() {
        Uri uri=Uri.parse("content://sms/inboxcontent://sms/inbox");
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        dsTinNhan.clear();
        while(cursor.moveToNext())
        {
            int indexPhoneNumber = cursor.getColumnIndex("address");
            int indexTimeStamp = cursor.getColumnIndex("date");
            int indexBody = cursor.getColumnIndex("body");
            String phonenumber=cursor.getString( indexPhoneNumber );
            String timeStamp=cursor.getString(indexTimeStamp);
            String body= cursor.getString( indexBody );
            dsTinNhan.add(/*phonenumber+" - "+timeStamp+" - "+*/body);
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvTinNhan=findViewById(R.id.lvTinNhan);
        dsTinNhan=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(MainActivity3.this, android.R.layout.simple_list_item_1,dsTinNhan);
        lvTinNhan.setAdapter(adapter);
    }
}