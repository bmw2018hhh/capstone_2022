package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Anzoo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anzoo);


        ImageButton anzooplus = findViewById(R.id.anzooplus);
        anzooplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DrinkActivity.class);
                startActivity(intent);
            }
        });

        TextView textview = (TextView) findViewById(R.id.antextView);
        Intent intent  = getIntent();
        int anzookcal = intent.getIntExtra("kcal",0);
        String str = "총 칼로리 : " + anzookcal + "Kcal";
        textview.setText(str);

        TextView atextView = (TextView) findViewById(R.id.atextView);
        //ArrayList<Food> menu = (ArrayList<Food>) intent.getSerializableExtra("menu");
        String str2 =  intent.getStringExtra("menu");
        atextView.setText(str2);


    }
}
