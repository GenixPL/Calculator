package com.example.genix.calculator;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class TextFunctions {

    char[] ourText;
    int len;

    TextFunctions(CharSequence ourText){
        this.ourText = new char[ourText.length()];
        for(int i = 0 ; i < ourText.length() ; ++i){
            this.ourText[i] = ourText.charAt(i);
        }
        len = ourText.length();
    }

    //Return ourText without last 3 indexes with are representing sign
    CharSequence returnWithoutSigh(){
        String temp = "";
        for (int i = 0 ; i < len - 3 ; ++i)
            temp += ourText[i];
        return temp;
    }

    char returnLastChar(){
        return ourText[len - 1];
    }

}
