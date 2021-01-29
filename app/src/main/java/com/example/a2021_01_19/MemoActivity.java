package com.example.a2021_01_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {
    EditText editTitle;
    EditText editContent;
    TextView buttonMemo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        editTitle = findViewById(R.id.edit_title);
        editContent = findViewById(R.id.content_text);
        buttonMemo = findViewById(R.id.button_text);

        buttonMemo.setOnClickListener(view -> {
            String title = editTitle.getText().toString().trim();
            String content = editContent.getText().toString().trim();

            if (!title.equals("") && !content.equals("")) {
                memo(title, content);
            }
            else {
                Toast.makeText(getApplicationContext(), "Please Enter All value", Toast.LENGTH_LONG).show();
            }

        });
    }
    private void memo (String title, String content){
    String toastText="제목 : " +title + "\n 본문: " +content;
    Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();
    }
}