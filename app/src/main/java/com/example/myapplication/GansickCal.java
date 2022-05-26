package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GansickCal extends AppCompatActivity {

    TextView mealTotalText;
    ArrayList<Food> orders;
    public static Context context_cal; //추가부분

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context_cal = this; //추가부분
        ListView storedOrders = (ListView)findViewById(R.id.selected_food_list);

        orders = getListItemData();
        mealTotalText = (TextView)findViewById(R.id.meal_total);
        OrderAdapter adapter = new OrderAdapter(this, orders);

        storedOrders.setAdapter(adapter);
        adapter.registerDataSetObserver(observer);

        Button subActivity_btn = (Button)findViewById(R.id.subActivity_btn);
        subActivity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GansickCal.this, Gansick.class);
                intent.putExtra("kcal", calculateMealTotal());
                intent.putExtra("menu", "망고스무디");
                startActivity(intent);

            }
        });

    }

    public int calculateMealTotal(){
        int mealTotal = 0;
        for(Food order : orders){
            mealTotal += order.getmAmount() * order.getmQuantity();
        }
        return mealTotal;
    }

    DataSetObserver observer = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            setMealTotal();
        }
    };

    private ArrayList<Food> getListItemData(){
        ArrayList<Food> listViewItems = new ArrayList<Food>();
        listViewItems.add(new Food("망고스무디",260));

        return listViewItems;
    }

    public void setMealTotal(){
        mealTotalText.setText(calculateMealTotal() + "Kcal");
    }


}




