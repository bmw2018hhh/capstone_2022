package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
//import android.widget.SearchView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CakeActivity extends AppCompatActivity {

    public static ArrayList<Cake> cakeList = new ArrayList<Cake>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);
        searchCake();
        setUpData();
        setUpList();
        setUpOnClickListener();
        }

    private void setUpData() {
        Cake elephant = new Cake("0", "팽이팽이");
        cakeList.add(elephant);

        Cake lion = new Cake("1", "핫도그");
        cakeList.add(lion);

        Cake monkey = new Cake("2", "아이스티");
        cakeList.add(monkey);

        Cake mouse = new Cake("3", "망고 스무디");
        cakeList.add(mouse);

        Cake rabbit = new Cake("4", "몰티저스 초콜릿");
        cakeList.add(rabbit );

        Cake elephant2 = new Cake("5", "예감");
        cakeList.add(elephant2);

        Cake lion2 = new Cake("6", "타로 밀크티");
        cakeList.add(lion2);

        Cake monkey2 = new Cake("7", "눈을 감자");
        cakeList.add(monkey2);

        Cake mouse2 = new Cake("8", "매운 새우깡");
        cakeList.add(mouse2);

        Cake rabbit2 = new Cake("9", "민트 초코 우유");
        cakeList.add(rabbit2);

    }
    private void setUpList() {
        listView = findViewById(R.id.cake_listView);
        CakeAdapter adapter = new CakeAdapter(getApplicationContext(), 0, cakeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent showDetail = new Intent(CakeActivity.this, GansickCal.class);
                startActivity(showDetail);
            }
        });
    }


    private void searchCake(){
        SearchView searchView = findViewById(R.id.cake_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                public boolean onQueryTextChange(String newText){

                    ArrayList<Cake> filterCake = new ArrayList<>();
                    for(int i = 0; i < cakeList.size(); i++){
                    Cake cake = cakeList.get(i);

                    //데이터와 비교해서 내가 쓴 간식 이름이 있다면
                    if(cake.getName().toLowerCase().contains(newText.toLowerCase())){
                        filterCake.add(cake);
                    }
                }
                CakeAdapter adapter = new CakeAdapter(getApplicationContext(), 0, filterCake);
                    listView.setAdapter(adapter);

                    return false;
                } }); }


            }