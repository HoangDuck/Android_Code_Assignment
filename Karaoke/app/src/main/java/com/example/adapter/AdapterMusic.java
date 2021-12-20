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

import com.example.karaoke.R;
import com.example.model.Music;

import java.util.List;

public class AdapterMusic extends ArrayAdapter<Music> {
    @NonNull Activity context;
    int resource;
    @NonNull List<Music> objects;
    public AdapterMusic(@NonNull Activity context, int resource, @NonNull List<Music> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=this.context.getLayoutInflater();
        View row=layoutInflater.inflate(this.resource,null);
        TextView txtMa=row.findViewById(R.id.txtMa);
        TextView txtTen=row.findViewById(R.id.txtTen);
        TextView txtCaSi=row.findViewById(R.id.txtCaSi);
        ImageButton btnLike=(ImageButton) row.findViewById(R.id.btnLike);
        ImageButton btnDislike=row.findViewById(R.id.btnDislike);
        final Music music=this.objects.get(position);
        txtTen.setText(music.getTen());
        txtMa.setText(music.getMa());
        txtCaSi.setText(music.getCaSi());
        if(this.objects.get(position).isLike())
        {
            btnDislike.setVisibility(View.VISIBLE);
            btnLike.setVisibility(View.INVISIBLE);
        }
        else
        {
            btnDislike.setVisibility(View.INVISIBLE);
            btnLike.setVisibility(View.VISIBLE);
        }
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThich(music);
                btnDislike.setVisibility(View.VISIBLE);
                btnLike.setVisibility(View.INVISIBLE);
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyKoThich(music);
                btnDislike.setVisibility(View.INVISIBLE);
                btnLike.setVisibility(View.VISIBLE);
            }
        });
        return row;
    }

    private void xuLyKoThich(Music music) {
        music.setLike(false);
        Toast.makeText(this.context,"Bỏ ra khỏi yêu thích",Toast.LENGTH_SHORT).show();
        this.objects.remove(music);
        AdapterMusic.this.notifyDataSetChanged();
    }

    private void xuLyThich(Music music) {
            music.setLike(true);
            Toast.makeText(this.context,"Thêm vào yêu thích",Toast.LENGTH_SHORT).show();
            AdapterMusic.this.notifyDataSetChanged();
    }
}
