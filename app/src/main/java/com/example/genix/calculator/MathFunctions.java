package com.example.genix.calculator;


import java.util.ArrayList;

class MathFunctions {

    ArrayList <Double> ourNumbers;
    ArrayList <Character> ourSigns;
    double result;

    MathFunctions(CharSequence ourText){
        this.ourNumbers = new ArrayList(0);
        this.ourSigns = new ArrayList(0);
        result = 0;

        String tempNum = "";

        for (int i = 0 ; i < ourText.length() ; ++i) {

            if(Character.isDigit(ourText.charAt(i)) || ourText.charAt(i) == '.')
                tempNum += ourText.charAt(i);
            else {
                if("".equals(tempNum))
                    ourNumbers.add((double) 0);
                else
                    ourNumbers.add(Double.parseDouble(tempNum));
                tempNum = "";
                ourSigns.add(ourText.charAt(i));
            }
            //if there is nothing more
            if (i + 1 == ourText.length())
                if("".equals(tempNum))
                    ourNumbers.add((double) 0);
                else
                    ourNumbers.add(Double.parseDouble(tempNum));
        }
    }

    //Change value of result(static from MainActivity)
    void changeResult(){
        MainActivity.result = result;
    }
}
