package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnInDam,btnToDo,btnXoa;
    Button btnLastedSelected=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnInDam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyInDam();
            }
        });
        btnToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyToDo();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXoa();
            }
        });
        btnInDam.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                btnLastedSelected=btnInDam;
                return false;
            }
        });
        btnToDo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                btnLastedSelected=btnToDo;
                return false;
            }
        });
        btnXoa.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                btnLastedSelected=btnXoa;
                return false;
            }
        });
    }

    private void xuLyXoa() {

    }

    private void xuLyToDo() {

    }

    private void xuLyInDam() {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.contextmenu_main,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnuInDam)
        {
            btnLastedSelected.setTypeface(Typeface.DEFAULT_BOLD);
        }else if(item.getItemId()==R.id.mnuMauDo)
        {
            btnLastedSelected.setTextColor(Color.RED);
        }else if(item.getItemId()==R.id.mnuXoa)
        {
            btnLastedSelected.setVisibility(View.INVISIBLE);
        }
        return super.onContextItemSelected(item);
    }

    private void addControls() {
        btnInDam=findViewById(R.id.btnInDam);
        btnToDo=findViewById(R.id.btnToDo);
        btnXoa=findViewById(R.id.btnXoa);
        registerForContextMenu(btnInDam);
        registerForContextMenu(btnToDo);
        registerForContextMenu(btnXoa);
    }
}