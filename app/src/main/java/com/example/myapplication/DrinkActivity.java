package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {

    public static ArrayList<Drink> drinkList = new ArrayList<Drink>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        searchDrink();
        setUpData();
        setUpList();
        setUpOnClickListener();
    }

    private void setUpData() {
       Drink elephant = new Drink("0", "방어회");
       drinkList.add(elephant);

        Drink lion = new Drink("1", "엽기떡볶이");
        drinkList.add(lion);

        Drink monkey = new Drink("2", "나가사끼짬뽕탕");
        drinkList.add(monkey);

        Drink mouse = new Drink("3", "야채곱창볶음");
        drinkList.add(mouse);

        Drink rabbit = new Drink("4", "대창구이");
        drinkList.add(rabbit );

        Drink elephant2 = new Drink("5", "삼겹살");
        drinkList.add(elephant2);

        Drink lion2 = new Drink("6", "치즈돈까스");
        drinkList.add(lion2);

        Drink monkey2 = new Drink("7", "해물찜");
        drinkList.add(monkey2);

        Drink mouse2 = new Drink("8", "돼지김치찌개");
        drinkList.add(mouse2);

        Drink rabbit2 = new Drink("9", "양꼬치");
        drinkList.add(rabbit2);
    }
    private void setUpList() {
        listView = findViewById(R.id.animal_listView);
        DrinkAdapter adapter = new DrinkAdapter(getApplicationContext(), 0, drinkList);
        listView.setAdapter(adapter);
    }

    private void setUpOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent showDetail = new Intent(DrinkActivity.this, AnzooCal.class);
                startActivity(showDetail);
            }
        });
    }


    private void searchDrink(){
        SearchView searchView = findViewById(R.id.animal_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            public boolean onQueryTextChange(String newText){

                ArrayList<Drink> filterDrink = new ArrayList<>();
                for(int i = 0; i < drinkList.size(); i++){
                    Drink drink = drinkList.get(i);

                    //데이터와 비교해서 내가 쓴 동물 이름이 있다면
                    if(drink.getName().toLowerCase().contains(newText.toLowerCase())){
                        filterDrink.add(drink);
                    }
                }
                DrinkAdapter adapter = new DrinkAdapter(getApplicationContext(), 0, filterDrink);
                listView.setAdapter(adapter);

                return false;
            } }); }

}
