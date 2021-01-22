package com.example.a2021_01_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    enum Operation {
        MINUS, PLUS, MULTIPLE, DIVIDE
    };

    int num1;
    int num2;
    Operation operation;
    boolean isOperated=false;

   //코드에서 사용할 뷰 선언
    TextView result;
    TextView C;
    TextView MC;
    TextView MR;
    TextView M;
    ImageView Backspace;
    TextView Plus_minus;
    TextView Percent;
    TextView Divide;
    TextView Seven;
    TextView Eight;
    TextView Nine;
    TextView Mul;
    TextView Four;
    TextView Five;
    TextView Six;
    TextView Minus;
    TextView One;
    TextView Two;
    TextView Three;
    TextView Plus;
    TextView Zero;
    TextView Point;
    TextView Cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        result = (TextView) findViewById(R.id.text1);
        C = (TextView) findViewById(R.id.text2);
        MC = (TextView) findViewById(R.id.text3);
        MR = (TextView) findViewById(R.id.text4);
        M = (TextView) findViewById(R.id.text5);
        Backspace = (ImageView) findViewById(R.id.text6);
        Plus_minus = (TextView) findViewById(R.id.text7);
        Percent = (TextView) findViewById(R.id.text8);
        Divide = (TextView) findViewById(R.id.text9);
        Seven = (TextView) findViewById(R.id.text10);
        Eight = (TextView) findViewById(R.id.text11);
        Nine = (TextView) findViewById(R.id.text12);
        Mul = (TextView) findViewById(R.id.text13);
        Four = (TextView) findViewById(R.id.text14);
        Five = (TextView) findViewById(R.id.text15);
        Six = (TextView) findViewById(R.id.text16);
        Minus = (TextView) findViewById(R.id.text17);
        One = (TextView) findViewById(R.id.text18);
        Two = (TextView) findViewById(R.id.text19);
        Three = (TextView) findViewById(R.id.text20);
        Plus = (TextView) findViewById(R.id.text21);
        Zero = (TextView) findViewById(R.id.text22);
        Point = (TextView) findViewById(R.id.text23);
        Cal = (TextView) findViewById(R.id.text24);

        result.setOnClickListener(view -> {
        });
        C.setOnClickListener(view -> {
        });
        MC.setOnClickListener(view -> {
        });
        MR.setOnClickListener(view -> {
        });
        M.setOnClickListener(view -> {
        });
        Backspace.setOnClickListener(view -> {
        });
        Plus_minus.setOnClickListener(view -> {
        });
        Percent.setOnClickListener(view -> {
        });
        Divide.setOnClickListener(view -> {
            operateButton(Operation.DIVIDE);
        });
        Seven.setOnClickListener(view -> {
            pressNumView(7);
        });
        Eight.setOnClickListener(view -> {
            pressNumView(8);
        });
        Nine.setOnClickListener(view -> {
            pressNumView(9);
        });
        Mul.setOnClickListener(view -> {
            operateButton(Operation.MULTIPLE);
        });
        Four.setOnClickListener(view -> {
            pressNumView(4);
        });
        Five.setOnClickListener(view -> {
            pressNumView(5);
        });
        Six.setOnClickListener(view -> {
            pressNumView(6);
        });
        Minus.setOnClickListener(view -> {
            operateButton(Operation.MINUS);
        });
        One.setOnClickListener(view -> {
            pressNumView(1);
        });
        Two.setOnClickListener(view -> {
            pressNumView(2);
        });
        Three.setOnClickListener(view -> {
            pressNumView(3);
        });
        Plus.setOnClickListener(view -> {
            operateButton(Operation.PLUS);
        });
        Zero.setOnClickListener(view -> {
            pressNumView(0);
        });
        Point.setOnClickListener(view -> {
        });
        Cal.setOnClickListener(view -> {
            result();
        });

        setContentView(R.layout.activity_main);



    }

    private void pressNumView (int num){
    //  num 이 하나 생긴다.
    if (isOperated){
        result.setText(String.valueOf(num));
    }
    else{
        String Result = result.getText().toString();
        Result+=String.valueOf(num);
        result.setText(String.valueOf(num));
    }
        isOperated=false;
    }

    private void operateButton(Operation operate){
        operation=operate;
        isOperated=true;
    }

    private void result(){
        switch (operation){
            case PLUS:
                num1+=num2;
                result.setText(String.valueOf(num1));
                break;
            case MINUS:
                num1-=num2;
                result.setText(String.valueOf(num1));
                break;
            case MULTIPLE:
                num1*=num2;
                result.setText(String.valueOf(num1));
                break;
            case DIVIDE:
                num1/=num2;
                result.setText(String.valueOf(num1));
                break;
        }
    }



}