package org.techtown.betterapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class RegisterActivity2 extends AppCompatActivity {

    private EditText et_nick, et_age, et_height, et_weight;
    private Button btn_next;
    private ImageButton btn_pre;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        et_nick = findViewById(R.id.et_nick);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        btn_pre = findViewById(R.id.btn_pre);
        btn_next = findViewById(R.id.btn_next);

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity2.this, RegisterActivity1.class);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String user_nick = et_nick.getText().toString();
                final String user_age = et_age.getText().toString();
                final String user_height = et_height.getText().toString();
                final String user_weight = et_weight.getText().toString();

                if (user_nick.equals("")||user_age.equals("")||user_height.equals("")||user_weight.equals("")) {
                    AlertDialog.Builder dialog=new AlertDialog.Builder(RegisterActivity2.this);
                    dialog.setIcon(R.mipmap.ic_launcher);
                    dialog.setTitle("알림");
                    dialog.setMessage("모두 입력하세요.");
                    dialog.setNegativeButton("확인",null);
                    dialog.show();
                }
                else {
                    Intent intent=new Intent(getApplicationContext(),RegisterActivity3.class);
                    intent.putExtra("et_nick",user_nick);
                    intent.putExtra("et_age",user_age);
                    intent.putExtra("et_height",user_height);
                    intent.putExtra("et_weight",user_weight);
                    startActivity(intent);
                }
            }
        });
    }
}