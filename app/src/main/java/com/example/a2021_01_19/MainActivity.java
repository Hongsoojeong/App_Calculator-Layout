package com.example.a2021_01_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Operation {
        MINUS, PLUS, MULTIPLE, DIVIDE
    };
    enum Page{
        TAMAGO, MEMO,Recyclear
    };
    double num1;
    double num2;
    Operation operation;
    boolean isOperated=false;

   //코드에서 사용할 뷰 선언
    TextView result_text;
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
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        result_text = (TextView) findViewById(R.id.text1);
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

        result_text.setOnClickListener(view -> {
        });
        C.setOnClickListener(view -> {
            clear();
        });
        MC.setOnClickListener(view -> {
            goTopage(Page.MEMO);
        });
        MR.setOnClickListener(view -> {
            goTopage(Page.TAMAGO);
        });
        M.setOnClickListener(view -> {
            goTopage(Page.Recyclear);
        });
        Backspace.setOnClickListener(view -> {
            back();
        });
        Plus_minus.setOnClickListener(view -> {
            setPlus_minus();
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
            dot();
        });
        Cal.setOnClickListener(view -> {
            result();
        });



    }
    private void goToGAME(){
    Intent intent = new Intent (getApplicationContext(), gameActivity.class);
    startActivity(intent);
    }

    private void back(){
        String nowNum = result_text.getText().toString();
        StringBuffer sb= new StringBuffer(nowNum);
        if (sb.length()-1>=0) sb.deleteCharAt(sb.length()-1);
        else Toast.makeText(getApplicationContext(), "No more num to erase", Toast.LENGTH_LONG).show();
        result_text.setText(sb.toString());
    }

    private void clear(){
        result_text.setText("");
        isOperated=false;
        num1=0;
        num2=0;
    }


    private void dot(){
        String result = result_text.getText().toString();
        if (!result.contains(".")){
            result+=".";
            result_text.setText(result);
        }
    }

    private void setPlus_minus(){
        num1=Double.parseDouble(result_text.getText().toString());
        result_text.setText(String.valueOf((-1)*num1));
    }

    private void pressNumView (int num){
    //  num 이 하나 생긴다.
    if (isOperated){
        result_text.setText(String.valueOf(num));
    }
    else{
        String Result = result_text.getText().toString();
        if (result_text.equals("0"))
            Result = String.valueOf(num);
        else Result+=String.valueOf(num);
        result_text.setText(String.valueOf(Result));
    }
        isOperated=false;
    }

    private void operateButton(Operation operate){
        num1=Double.parseDouble(result_text.getText().toString());
        operation=operate;
        isOperated=true;
    }
    
    private void goTopage(Page page){
        Intent intent; // Intent 선언
        switch (page){ //switch case를 이용해 어떤 Intent로 정의해줄지 정함
            case TAMAGO: // goToPage 함수의 인자로 Page.TAMGO가 들어왔을때
                intent=new Intent(getApplicationContext(),gameActivity.class);
                break;
            case MEMO: // goToPage 함수의 인자로 Page.MEMO가 들어왔을 때
                intent=new Intent (getApplicationContext(), MemoActivity.class);
                break;
            case Recyclear:
                intent=new Intent (getApplicationContext(), RecyclerActivity.class);
                break;
            default: // 그 외의 상황
                throw new IllegalStateException("Unexpexted value: "+page);
        }
        startActivity(intent); //swithc case에서 정의해준 INTENT로 startActivity 하여 화면 전환
    }

    private void result(){

        num2=Double.parseDouble(result_text.getText().toString());
        switch (operation){
            case PLUS:
                num1+=num2;
                break;
            case MINUS:
                num1-=num2;
                break;
            case MULTIPLE:
                num1*=num2;
                break;
            case DIVIDE:
                num1/=num2;
                break;
        }
        result_text.setText(String.valueOf(num1));
    }
}