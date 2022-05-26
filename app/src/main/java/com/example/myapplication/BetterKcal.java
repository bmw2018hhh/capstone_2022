package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BetterKcal extends AppCompatActivity {

    public static Context context_sumkcal; //추가부분
    public int sumkcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_better);
        context_sumkcal = this; //추가부분

        TextView bettertextView = (TextView) findViewById(R.id.bettertextView);
        int akcal,gkcal,ykcal=0;
        akcal = ((AnzooCal) AnzooCal.context_cal).calculateMealTotal();
        gkcal = ((GansickCal) GansickCal.context_cal).calculateMealTotal();
        ykcal = ((YasickCal) YasickCal.context_cal).calculateMealTotal();
        sumkcal = akcal + gkcal + ykcal;
        String str = "총 칼로리 : " + sumkcal + "Kcal";
        bettertextView.setText(str);


    }
}
