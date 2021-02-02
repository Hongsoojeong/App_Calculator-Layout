package com.example.a2021_01_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MemoActivity extends AppCompatActivity {
    EditText editTitle;
    EditText editContent;
    TextView buttonMemo;
    SharedPreferences sf; // 앱 내 데이터를 저장할 객체
    SharedPreferences.Editor editor; // 앱 내 데이터를 수정할 객체


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        sf=getSharedPreferences("sFile", MODE_PRIVATE);
        editor= sf.edit();

        editTitle = findViewById(R.id.edit_title);
        editContent = findViewById(R.id.content_text);
        buttonMemo = findViewById(R.id.button_text);

        String title= sf.getString("memoTitle","");
        String content = sf.getString("memoContent", "");

        editTitle.setText(title);
        editContent.setText(content);

        buttonMemo.setOnClickListener(view -> {
            String titleTrim = editTitle.getText().toString().trim();
            String contentTrim = editContent.getText().toString().trim();

            if (!titleTrim.equals("") && !contentTrim.equals("")) {
                memo(titleTrim, contentTrim);
            }
            else {
                Toast.makeText(getApplicationContext(), "Please Enter All value", Toast.LENGTH_LONG).show();
            }

        });
    }
    private void memo (String title, String content){

    String toastText="제목 : " +title + "\n 본문: " +content;

    editor.putString("memoTitle", title).commit();
    editor.putString("memoContent", content).commit();
    Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();
    }
}