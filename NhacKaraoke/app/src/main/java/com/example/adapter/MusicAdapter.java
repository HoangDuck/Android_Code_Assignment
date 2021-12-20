package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mucsic.Music;
import com.example.nhackaraoke.MainActivity;
import com.example.nhackaraoke.R;

import java.util.List;

public class MusicAdapter extends ArrayAdapter<Music> {
    @NonNull Activity context;
    int resource;
    @NonNull List<Music> objects;
    public MusicAdapter(@NonNull Activity context, int resource, @NonNull List<Music> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView txtMa=(TextView)row.findViewById(R.id.txtMa);
        TextView txtTen=(TextView)row.findViewById(R.id.txtTen);
        TextView txtCaSi=(TextView)row.findViewById(R.id.txtCaSi);
        ImageButton btnLike=(ImageButton) row.findViewById(R.id.btnLike);
        final Music music=this.objects.get(position);
        txtTen.setText(music.getTen());
        txtMa.setText(music.getMa());
        txtCaSi.setText(music.getCaSi());
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThich(music);
            }
        });
        return row;
    }

    private void xuLyThich(Music music) {
        if(music.isLike())
        {
            music.setLike(false);
            //Toast.makeText(Activity.this,"Bỏ ra khỏi yêu thích",Toast.LENGTH_SHORT).show();
        }
        else
        {
            music.setLike(true);
            //Toast.makeText(Activity.this,"Thêm vào yêu thích",Toast.LENGTH_SHORT).show();
        }
    }


}
