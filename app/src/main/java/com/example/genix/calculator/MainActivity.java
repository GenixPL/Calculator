package com.example.genix.calculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    static double result;
    TextView mainText;
    static private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = (TextView) findViewById(R.id.mainView);   //TO REMEMBER (PLACE OF THAT)
        context = getApplicationContext();
    }

    public void writeNum(View view) {
        Button tempBut = (Button) view;

        if ("0".equals(mainText.getText()))
            mainText.setText("");

        mainText.setText(mainText.getText() + tempBut.getText().toString());
    }

    public void write(View view) {
        Button tempBut = (Button) view;
        TextFunctions text = new TextFunctions(mainText.getText());

        //if empty don't do anything except minus
        if(mainText.getText().toString().isEmpty() && !"-".equals(tempBut.getText().toString()))
            return;

        if(text.isDigitLastOrEmpty())
            mainText.setText(mainText.getText() + tempBut.getText().toString());
        else {
            mainText.setText(text.returnWithoutSigh());
            if(!text.returnString().isEmpty())
                mainText.setText(mainText.getText() + tempBut.getText().toString());
        }

    }

    public void clear(View view) {
        mainText.setText("");
        result = 0;
    }

    //Change value of result and give it to TextView
    public void getResult(View view) {

        //if empty don't do anything
        if(mainText.getText().toString().isEmpty())
            return;

        MathFunctions functions = new MathFunctions(mainText.getText());

        functions.changeResult();
        DecimalFormat df = new DecimalFormat("#.#####");
        mainText.setText(String.valueOf(df.format(result)));
    }
}
