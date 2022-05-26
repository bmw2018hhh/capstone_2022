package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CakeAdapter extends ArrayAdapter<Cake> {

    public CakeAdapter(Context context, int resource, List<Cake> animalList){
        super(context, resource, animalList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Cake animal = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.animal_item, parent, false);
        }
        TextView tv = convertView.findViewById(R.id.animal_name);
        tv.setText(animal.getName());
        return convertView;
    }
}

