package com.example.saochepdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String DATABASE_NAME="Arirang.sqlite";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database=null;
    ListView lvBaiHat;
    ArrayList<String>baiHat;
    ArrayAdapter<String>adapter;
    Button btnThem,btnSua,btnXoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xuLySaoChepDataBase();
        addControls();
        addEvents();
        showAllSongs();
    }

    private void showAllSongs() {
        //b1 mo csdl
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor=database.query("ArirangSongList",null,null,null,null,null,null);
        //Cursor cursor1=database.rawQuery("select*from ArirangSongList",null);
        baiHat.clear();
        while(cursor.moveToNext())
        {
            String mabh=cursor.getString(0);
            String tenbh=cursor.getString(1);
            baiHat.add(mabh+" - "+tenbh);
        }
        cursor.close();//dong ket noi
        adapter.notifyDataSetChanged();
    }

    private void addEvents() {
        lvBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,baiHat.get(i)+"",Toast.LENGTH_LONG).show();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyThem();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLySua();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXoa();
            }
        });
    }

    private void xuLyXoa() {
        //database.delete("ArirangSongList",null,null); thao tac nay la xoa het
        database.delete("ArirangSongList","MABH=?",new String[]{"52931"});
        showAllSongs();
    }

    private void xuLySua() {
        ContentValues row=new ContentValues();
        row.put("TENBH","Con lai mot minh");
        database.update("ArirangSongList",row,"MABH=?",new String[]{"52931"});
        showAllSongs();
    }

    private void xuLyThem() {
        ContentValues row= new ContentValues();
        row.put("MABH","52931");
        row.put("TENBH","CONLAIMOTMINH");
        int r= (int) database.insert("ArirangSongList",null,row);
        Toast.makeText(MainActivity.this,"Da them "+r,Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        lvBaiHat=findViewById(R.id.lvBaiHat);
        baiHat=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,baiHat);
        lvBaiHat.setAdapter(adapter);
        btnThem=findViewById(R.id.btnThem);
        btnSua=findViewById(R.id.btnSua);
        btnXoa=findViewById(R.id.btnXoa);
    }

    private void xuLySaoChepDataBase() {
        File dbFile = getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists())
        {
            try{
                CopyDataBaseFromAssets();
                Toast.makeText(this, "Copying sucess from Assets folder", Toast.LENGTH_LONG).show();
            }catch (Exception ex)
            {
                Log.e(
                        "LOI",ex.toString()
                );
            }
        }
    }

    private void CopyDataBaseFromAssets() {
        try{
            InputStream myInput;
            myInput=getAssets().open(DATABASE_NAME);
            String outFileName=layDuongDan();
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if(!f.exists())
            {
                f.mkdir();
            }
            OutputStream myOutput=new FileOutputStream(outFileName);
            byte[] buffer=new byte[1024];
            int length;
            while ((length=myInput.read(buffer))>0)
            {
                myOutput.write(buffer,0,length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }catch (Exception ex)
        {
            Log.e("LOI",ex.toString());
        }
    }

    private String layDuongDan()
    {
        return getApplicationInfo().dataDir+DB_PATH_SUFFIX+DATABASE_NAME;
    }
}