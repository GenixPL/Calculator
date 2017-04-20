package com.example.genix.calculator;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TextFunctions {

    private ArrayList <Character> ourText;

    TextFunctions(CharSequence ourText){
        this.ourText = new ArrayList(0);

        for (int i = 0 ; i < ourText.length() ; i++){
            this.ourText.add(ourText.charAt(i));
        }

    }

    //Return ourText without last 3 indexes with are representing sign
    String returnWithoutSigh(){
        ourText.remove(ourText.size() - 1);
        return returnString();
    }

    //checks if last char is digit or ourText is empty
    boolean isDigitLastOrEmpty(){
        if(!ourText.isEmpty()) {
            if (Character.isDigit(ourText.get(ourText.size() - 1)))
                return true;
            else
                return false;
        }
        else
            return true;
    }

    String returnString(){
        String temp = "";
        for (char sign: ourText) {
            temp += sign;
        }
        return temp;
    }

}
