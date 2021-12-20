package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listview.R;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterList extends ArrayAdapter<String> {
    @NonNull Activity context;
    int resource;
    @NonNull List<String> objects;
    public AdapterList(@NonNull Activity context, int resource, @NonNull List<String> objects) {
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
        TextView txtA=row.findViewById(R.id.txtA);
        String t=this.objects.get(position);
        txtA.setText(t);
        return row;
    }
}
