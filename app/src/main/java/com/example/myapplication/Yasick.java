package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Yasick extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yasick);

        ImageButton yasickplus = findViewById(R.id.yasickplus);
        yasickplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NightActivity.class);
                startActivity(intent);
            }
        });

        TextView textview = (TextView) findViewById(R.id.ytextView);
        Intent intent  = getIntent();
        int yasickkcal = intent.getIntExtra("kcal",0);
        String str = "총 칼로리 : " + yasickkcal + "Kcal";
        textview.setText(str);


        TextView menutextView = (TextView) findViewById(R.id.menutextView);
        //ArrayList<Food> menu = (ArrayList<Food>) intent.getSerializableExtra("menu");
        String str2 =  intent.getStringExtra("menu");
        menutextView.setText(str2);


    }
}
