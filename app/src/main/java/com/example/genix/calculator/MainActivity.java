package com.example.genix.calculator;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



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
    }
}
