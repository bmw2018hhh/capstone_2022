package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Report extends Fragment {

    private View view;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity) {
            Activity  activity = (Activity) context;
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_myreport, container, false);

        final TextView textView = view.findViewById(R.id.cltextView);
        final TextView textView2 = view.findViewById(R.id.menttextView);
        final TextView textView3 = view.findViewById(R.id.todaybad);

        ImageView img = view.findViewById(R.id.sticker);
        ImageView img2 = view.findViewById(R.id.badimageView);
        CalendarView calendarView = view.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @SuppressLint("DefaultLocale")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month += 1;
                textView.setText(String.format("\t%d년 %d월 %d일", year, month, dayOfMonth));
                String goodstr = "\n오늘은 좀 참았네요? \n아주 굿굿굿이에요~♥";
                String badstr = "\n오늘 뭐죠? 밥 안드셨나요? \n아주 안습이에요~♥";
                String sosostr = "\n조금만 더 참았더라면.. \n내일 기대할게요~♥";
                int badkcal = 1144;
                String todaykcal = badkcal + "Kcal";
                textView2.setText(badstr);
                textView3.setText(todaykcal);
                img.setImageResource(R.drawable.hmm);
                img2.setImageResource(R.drawable.todaybadkcal);
            }
        });


        return view;

    }
}
