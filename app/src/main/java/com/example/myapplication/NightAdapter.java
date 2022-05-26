package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

public class NightAdapter extends ArrayAdapter<Night> {

    public NightAdapter(Context context, int resource, List<Night> nightList){
        super(context, resource, nightList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Night night = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.animal_item, parent, false);
        }
        TextView tv = convertView.findViewById(R.id.animal_name);
        tv.setText(night.getName());
        return convertView;
    }
}

