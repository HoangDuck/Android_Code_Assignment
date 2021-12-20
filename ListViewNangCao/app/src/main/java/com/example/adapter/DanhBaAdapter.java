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

import com.example.listviewnangcao.MainActivity;
import com.example.listviewnangcao.R;
import com.example.model.DanhBa;

import java.util.List;

public class DanhBaAdapter extends ArrayAdapter<DanhBa> {
    @NonNull Activity context;
    int resource;
    @NonNull List<DanhBa> objects;
    public DanhBaAdapter(@NonNull Activity context, int resource, @NonNull List<DanhBa> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=this.context.getLayoutInflater();//build layout thanh java de android su dung
        View row=layoutInflater.inflate(this.resource,null);
        TextView txtTen=row.findViewById(R.id.txtTen);
        TextView txtPhone=row.findViewById(R.id.txtPhone);
        ImageButton btnCall=row.findViewById(R.id.btnCall);
        ImageButton btnSms=row.findViewById(R.id.btnSms);
        ImageButton btnDetail=row.findViewById(R.id.btnDetail);
        final DanhBa db=this.objects.get(position);
        txtTen.setText(db.getTen());
        txtPhone.setText(db.getPhone());
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXemChiTiet(db);
            }
        });
        return row;
    }

    private void xuLyXemChiTiet(DanhBa db) {
        Toast.makeText(this.context,"Họ tên: "+db.getTen(),Toast.LENGTH_LONG).show();
    }
}
