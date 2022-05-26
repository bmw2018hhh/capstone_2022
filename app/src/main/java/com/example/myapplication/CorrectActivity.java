package org.techtown.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CorrectActivity extends AppCompatActivity {

    private Button btn_ok;
    private ImageButton btn_pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        btn_pre = findViewById(R.id.btn_pre);
        btn_ok = findViewById(R.id.btn_ok);

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CorrectActivity.this, PageFragment.class);
                startActivity(intent);
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CorrectActivity.this, PageFragment.class);
                startActivity(intent);
            }
        });
    }
}