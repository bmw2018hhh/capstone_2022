package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;

public class NightActivity extends AppCompatActivity {

    public static ArrayList<Night> nightList = new ArrayList<Night>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night);
        searchNight();
        setUpData();
        setUpList();
        setUpOnClickListener();
    }

    private void setUpData() {
        Night elephant = new Night("0", "국물무뼈닭발");
        nightList.add(elephant);

        Night lion = new Night("1", "BHC 뿌링클");
        nightList.add(lion);

        Night monkey = new Night("2", "푸라닭 고추마요");
        nightList.add(monkey);

        Night mouse = new Night("3", "엽기떡볶이");
        nightList.add(mouse);

        Night rabbit = new Night("4", "배떡 로제떡볶이");
        nightList.add(rabbit );

        Night elephant2 = new Night("5", "명랑 감자핫도그");
        nightList.add(elephant2);

        Night lion2 = new Night("6", "야채곱창볶음");
        nightList.add(lion2);

        Night monkey2 = new Night("7", "열라면");
        nightList.add(monkey2);

        Night mouse2 = new Night("8", "마라탕");
        nightList.add(mouse2);

        Night rabbit2 = new Night("9", "노랑통닭 마늘치킨");
        nightList.add(rabbit2);
    }
    private void setUpList() {
        listView = findViewById(R.id.night_listView);
        NightAdapter adapter = new NightAdapter(getApplicationContext(), 0, nightList);
        listView.setAdapter(adapter);
    }

    private void setUpOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent showDetail = new Intent(NightActivity.this, YasickCal.class);
                startActivity(showDetail);
            }
        });
    }


    private void searchNight(){
        SearchView searchView = findViewById(R.id.night_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            public boolean onQueryTextChange(String newText){

                ArrayList<Night> filterNight = new ArrayList<>();
                for(int i = 0; i < nightList.size(); i++){
                    Night night = nightList.get(i);

                    if(night.getName().toLowerCase().contains(newText.toLowerCase())){
                        filterNight.add(night);
                    }
                }
                NightAdapter adapter = new NightAdapter(getApplicationContext(), 0, filterNight);
                listView.setAdapter(adapter);
                return false;
            } }); }

}
