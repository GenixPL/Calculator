package com.example.genix.calculator;


import java.util.ArrayList;

class MathFunctions {

    private ArrayList <Double> ourNumbers;
    private ArrayList <Character> ourSigns;
    private double result;

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
        if (ourSigns.indexOf('(') == -1)
            basicCalculations();
        MainActivity.result = result;
    }

    void basicCalculations(){
        boolean greaterSignExists = false; //greater sign - with bigger priority
        int curIndex;

        for ( int i = (ourSigns.size() - 1) ; i >= 0 ; --i){
            if(ourSigns.contains('*') || ourSigns.contains('/')) {
                greaterSignExists = true;
                curIndex = earlierSign();
            } else {
                curIndex = ourSigns.size() - 1;
            }

            double firstNum = ourNumbers.get(curIndex);
            double secondNum = ourNumbers.get(curIndex + 1);
            char currSign = ourSigns.get(curIndex);

            if (greaterSignExists){
                ourNumbers.set(curIndex, doCalculation(firstNum, secondNum, currSign));
                ourNumbers.remove(curIndex + 1);
                ourSigns.remove(curIndex);
            } else {
                ourNumbers.set(curIndex, doCalculation(firstNum, secondNum, currSign));
                ourNumbers.remove(curIndex + 1);
                ourSigns.remove(curIndex);
            }

            greaterSignExists = false;
        }
    }

    //does basic calculations between two numbers and return it's result
    double doCalculation(double firstNum, double secondNum, char sign){
        switch (sign){
            case '+': return firstNum + secondNum;
            case '-': return firstNum - secondNum;
            case '*': return firstNum * secondNum;
            case '/': return firstNum / secondNum;
        }
    }

    //returns the index of first sign with bigger priority
    int earlierSign(){
        boolean mulExists = false;
        boolean divExists = false;

        if(ourSigns.contains('*'))
            mulExists = true;
        if(ourSigns.contains('/'))
            divExists = true;

        if (mulExists && divExists)
            return ourSigns.indexOf('*') < ourSigns.indexOf('/') ? ourSigns.indexOf('*') : ourSigns.indexOf('/');
        else if(mulExists)
            return ourSigns.indexOf('*');
        else
            return ourSigns.indexOf('/');

    }
}
