package com.example.genix.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    static double result = 0;
    TextView mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = (TextView) findViewById(R.id.mainView);  //TO REMEMBER
    }

    public void write(View view) {
        Button tempBut = (Button) view;

        mainText.setText(mainText.getText() + tempBut.getText().toString());

    }

    public void clear(View view) {
        mainText.setText("");
        result = 0;
    }

    //Change value of result and give it to TextView
    public void getResult(View view) {
        MathFunctions functions = new MathFunctions();

        functions.calculations(mainText.getText().toString());
        DecimalFormat df = new DecimalFormat("#.#####");
        mainText.setText(String.valueOf(df.format(result)));
    }

}
