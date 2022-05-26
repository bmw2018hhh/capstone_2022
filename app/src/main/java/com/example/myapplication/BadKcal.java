package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BadKcal extends Fragment {
    private View view;
    private ImageButton anzoo,gansick,yasick;
    private Button betterbutton;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity) {
            Activity  activity = (Activity) context;
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_badcal, container,false);

        yasick = view.findViewById(R.id.yasick);
        yasick.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), Yasick.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });

        anzoo = view.findViewById(R.id.anzoo);
        anzoo.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), Anzoo.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });

        gansick = view.findViewById(R.id.gansick);
        gansick.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), Gansick.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });

        betterbutton = view.findViewById(R.id.betterbutton);
        betterbutton.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), BetterKcal.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });

        return view;
    }
}
