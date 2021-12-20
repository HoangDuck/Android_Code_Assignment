package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtMau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        txtMau=findViewById(R.id.txtMau);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnuMauDo)
        {
            txtMau.setBackgroundColor(Color.RED);
        }else{
            if(item.getItemId()==R.id.mnuMauVang)
            {
                txtMau.setBackgroundColor(Color.YELLOW);
            }else
            {
                if(item.getItemId()==R.id.mnuMauXanh)
                {
                    txtMau.setBackgroundColor(Color.BLUE);
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
}