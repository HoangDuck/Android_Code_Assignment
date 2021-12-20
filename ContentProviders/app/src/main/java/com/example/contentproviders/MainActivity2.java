package com.example.contentproviders;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView lvDanhBa;
    ArrayList<String>dsDanhBa;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvents();
        readAllContactsFromPhone();
    }

    private void addEvents() {
        lvDanhBa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity2.this,"Chon: "+dsDanhBa.get(i),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addControls() {
        lvDanhBa=findViewById(R.id.lvDanhBa);
        dsDanhBa=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_list_item_1,dsDanhBa);
        lvDanhBa.setAdapter(adapter);

    }

    private void readAllContactsFromPhone() {
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        dsDanhBa.clear();
        while (cursor.moveToNext())
        {
            String idName=ContactsContract.Contacts.DISPLAY_NAME;
            int colNameIndex=cursor.getColumnIndex(idName);
            String name=cursor.getString(colNameIndex);
            String idPhone=ContactsContract.CommonDataKinds.Phone.NUMBER;
            int colPhoneIndex=cursor.getColumnIndex(idPhone);
            String phone=cursor.getString(colPhoneIndex);
            String info=name+" - "+phone;
            dsDanhBa.add(info);
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }
}