package com.example.myapplication;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Exercise extends Fragment {

    private View view;
    private ImageButton ActivityButton;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity) {
            Activity  activity = (Activity) context;
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_exercisemain, container, false);


        ActivityButton = view.findViewById(R.id.ActivityButton);
        ActivityButton.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), Youtube.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });


        TextView kcaltext = view.findViewById(R.id.exkcaltext);
           int sumkcal = 1144;
           String str = "오늘의 나쁜 칼로리는" + sumkcal + "kcal이에요";
           kcaltext.setText(str);

        return view;

    }


}