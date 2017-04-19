package com.example.genix.calculator;


 class MathFunctions {

    private double number1 = 0;
    private double number2 = 0;
    private char sign = 'a';

    //Assign values of variables
    private void setVariables(String textViewOutput){

        char[] ourArr = textViewOutput.toCharArray();

        String number1 = "";
        String number2 = "";

        sign = 'a';

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

        this.number1 = Double.parseDouble(number1);
        this.number2 = Double.parseDouble(number2);


    }

    //Change value of result(static from MainActivity)
    void calculations(String textViewOutput){

        setVariables(textViewOutput);

        switch (sign){
            case '+': MainActivity.result = number1 + number2;
                break;
            case '-': MainActivity.result = number1 - number2;
                break;
            case '/': MainActivity.result = number1 / number2;
                break;
            case '*': MainActivity.result = number1 * number2;
                break;
        }

    }

}
