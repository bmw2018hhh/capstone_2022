package org.techtown.betterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class RegisterActivity3 extends AppCompatActivity {

    private Button btn_next;
    private ImageButton btn_pre;
    private ToggleButton check_1, check_2, check_3, check_4, check_5, check_6;
    private RadioButton check_1hour, check_3hour, check_5hour, check_8hour;
    private RadioGroup r_group;

    private Integer user_exp, user_fre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        btn_pre = findViewById(R.id.btn_pre);
        btn_next = findViewById(R.id.btn_next);
        check_1hour = findViewById(R.id.check_1hour);
        check_3hour = findViewById(R.id.check_3hour);
        check_5hour = findViewById(R.id.check_5hour);
        check_8hour = findViewById(R.id.check_8hour);
        check_1 = findViewById(R.id.check_1);
        check_2 = findViewById(R.id.check_2);
        check_3 = findViewById(R.id.check_3);
        check_4 = findViewById(R.id.check_4);
        check_5 = findViewById(R.id.check_5);
        check_6 = findViewById(R.id.check_6);

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity3.this, RegisterActivity2.class);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity3.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}