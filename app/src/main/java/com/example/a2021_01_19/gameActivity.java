package com.example.a2021_01_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//egg 라는 이미지뷰와 텍스트뷰 연결하는 변수 선언
// find view by로 연결
// egg는 setonclick 필요 그 안에서 click에 대한 로직 필요
// 터치할때마다 count, 계속 초기화 해야함
// 그럼 전역변수로써 해야함 처음에 0으로 초기화해야 겠다.
// if문을 통해 만약 달성할경우 토스트를 띄운다

public class gameActivity extends AppCompatActivity {
    TextView hit_text;
    ImageView egg_image;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamago);
        hit_text = (TextView) findViewById(R.id.text);
        egg_image = (ImageView) findViewById(R.id.egg);

        egg_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_egg();
            }
        });
    }
    private void click_egg(){
        count+=1;
        hit_text.setText(String.valueOf(count));
        if (count==20)
        {
                Toast.makeText(getApplicationContext(), "알 부시기 완료!",Toast.LENGTH_LONG).show();
            hit_text.setText("Hit!");
            count=0;

        }
    }
}