package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Gansick extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gansick);


        ImageButton gansickplus = findViewById(R.id.gansickplus);
        gansickplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CakeActivity.class);
                startActivity(intent);
            }
        });

        TextView textview = (TextView) findViewById(R.id.gtextView);
        Intent intent  = getIntent();
        int gansickkcal = intent.getIntExtra("kcal",0);
        String str = "총 칼로리 : " + gansickkcal + "Kcal";
        textview.setText(str);

        TextView gmtextView = (TextView) findViewById(R.id.gmtextView);
        //ArrayList<Food> menu = (ArrayList<Food>) intent.getSerializableExtra("menu");
        String str2 =  intent.getStringExtra("menu");
        gmtextView.setText(str2);


    }
}
