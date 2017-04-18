package com.example.genix.calculator;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    static double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void write(View view) {

        TextView mainText = (TextView) findViewById(R.id.mainView);

        Button tempBut = (Button) view;
        mainText.setText(mainText.getText() + tempBut.getText().toString());

    }

    public void clear(View view) {
        TextView mainText = (TextView) findViewById(R.id.mainView);
        mainText.setText("");
        result = 0;
    }

    public void getResult(View view) {

        TextView mainText = (TextView) findViewById(R.id.mainView);
        calculations();
        DecimalFormat df = new DecimalFormat("#.#####");
        mainText.setText(String.valueOf(df.format(result)));

    }

    public void calculations(){


        TextView mainText = (TextView) findViewById(R.id.mainView);
        String string = mainText.getText().toString();
        char[] ourArr = string.toCharArray();

        String number1 = "";
        String number2 = "";

        char sign = 'a';

        for(int i = 0 ; i < ourArr.length ; ++i){
            if(Character.isDigit(ourArr[i]) || ourArr[i] == '.') {
                if (sign == 'a') {
                    number1 += ourArr[i];
                } else
                    number2 += ourArr[i];
            } else if(ourArr[i] != ' '){
                sign = ourArr[i];
            }
        }

        switch (sign){
            case '+': result = Double.parseDouble(number1) + Double.parseDouble(number2);
                break;
            case '-': result = Double.parseDouble(number1) - Double.parseDouble(number2);
                break;
            case '/': result = Double.parseDouble(number1) / Double.parseDouble(number2);
                break;
            case '*': result = Double.parseDouble(number1) * Double.parseDouble(number2);
                break;
        }

    }

}
