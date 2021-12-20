package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.chungkhoan.R;
import com.example.model.TiGia;

import java.util.List;

public class TiGiaAdapter extends ArrayAdapter<TiGia> {
    @NonNull Activity context;
    int resource;
    @NonNull List<TiGia> objects;
    public TiGiaAdapter(@NonNull Activity context, int resource, @NonNull List<TiGia> objects) {
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
        TiGia tiGia=this.objects.get(position);
        ImageView imgHinh=row.findViewById(R.id.imgHinh);
        TextView txtDonVi=row.findViewById(R.id.txtDonVi);
        TextView txtMuaTM=row.findViewById(R.id.txtMuaTM);
        TextView txtBanTM=row.findViewById(R.id.txtBanTM);
        TextView txtMuaCK=row.findViewById(R.id.txtMuaCK);
        TextView txtBanCK=row.findViewById(R.id.txtBanCK);
        imgHinh.setImageBitmap(tiGia.getBitmap());
        txtDonVi.setText(tiGia.getType());
        txtBanCK.setText("Ban ck: "+tiGia.getBanck());
        txtBanTM.setText("Ban tm: "+tiGia.getBantienmat());
        txtMuaCK.setText("Mua ck: "+tiGia.getMuack());
        txtMuaTM.setText("Mua tm"+tiGia.getMuatienmat());
        return row;
    }
}
