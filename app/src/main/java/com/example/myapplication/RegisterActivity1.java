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

public class RegisterActivity1 extends AppCompatActivity {

    private EditText et_id, et_pass, et_word;
    private Button btn_next;
    private ImageButton btn_pre;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_word = findViewById(R.id.et_word);
        btn_pre = findViewById(R.id.btn_pre);
        btn_next = findViewById(R.id.btn_next);

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity1.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String user_id = et_id.getText().toString();
                final String user_pass = et_pass.getText().toString();
                final String user_word = et_word.getText().toString();

                if (user_id.equals("")||user_pass.equals("")||user_word.equals("")) {
                    AlertDialog.Builder dialog=new AlertDialog.Builder(RegisterActivity1.this);
                    dialog.setIcon(R.mipmap.ic_launcher);
                    dialog.setTitle("알림");
                    dialog.setMessage("모두 입력하세요.");
                    dialog.setNegativeButton("확인",null);
                    dialog.show();
                }
                /**
                else if (user_pass != user_word) {
                    AlertDialog.Builder dialog=new AlertDialog.Builder(RegisterActivity1.this);
                    dialog.setIcon(R.mipmap.ic_launcher);
                    dialog.setTitle("알림");
                    dialog.setMessage("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                    dialog.setNegativeButton("확인",null);
                    dialog.show();
                }
                 */
                else {
                    Intent intent=new Intent(getApplicationContext(),RegisterActivity2.class);
                    intent.putExtra("et_id",user_id);
                    intent.putExtra("et_pass",user_pass);
                    intent.putExtra("et_word",user_word);
                    startActivity(intent);
                }
            }
        });
    }
}