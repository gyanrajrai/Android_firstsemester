package com.example.admin_gyan.myfirstproject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Pattern;


public class Calculator extends Activity {
    private EditText screen;
    private String currentOperator = "", display = "";
    private String result = "";
    private android.util.Log log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        screen = (EditText) findViewById(R.id.txtscreen);
         screen.setText(display);
        screen.setGravity(Gravity.RIGHT);
    }

    public void updateScreen() {
        screen.setText(display);
    }


    public void onClickNumber(View v) {
       /* if (result != "") {
            clear();
            updateScreen();

       }*/
        Button btn1Number = (Button) v;
        display += btn1Number.getText();
        updateScreen();

    }
//for returning operator
    public boolean isOperator(char op) {
        switch (op) {
            case '+':
            case '-':
            case '/':
            case '*':
            case '(':
            case ')':

                return true;
            default:
                return false;


        }
    }

    public void onClickOperator(View v) {
        if (display == "") return;
        Button btnOperator = (Button) v;

        if (result != "") {
            String _display = result;

            display = result;
            clear();
            display = _display;


        }
        if (currentOperator != "") {
          //  log.d("i am here ", "" + display.charAt(display.length() - 1));
            if (isOperator(display.charAt(display.length() - 1))) {
                display.replace(display.charAt(display.length() - 1), btnOperator.getText().charAt(0));
                updateScreen();

            } else
                getResult();
            display = result;
            result = "";
        }
        display += btnOperator.getText();
        currentOperator = btnOperator.getText().toString();
        updateScreen();

    }

    public void clear() {
        display = "";
        currentOperator = "";
        result = "";
    }

    public void onClickClear(View v) {
        clear();
        updateScreen();

    }
//to delete one by one character
    public void delete(View v) {
        switch (v.getId()) {
            case R.id.btndelete:


                updateScreen();


        }
    }

    public double operateCalculation(String a, String b, String op) {
        switch (op) {
            case "+":
                return Double.valueOf(a) + Double.valueOf(b);
            case "-":
                return Double.valueOf(a) - Double.valueOf(b);
            case "/":
                return Double.valueOf(a) / Double.valueOf(b);
            case "(": return Double.valueOf(a)*Double.valueOf(b);
            case ")": return Double.valueOf(a)*Double.valueOf(b);
            case "*":
                try {
                    return Float.valueOf(a) * Float.valueOf(b);
                } catch (Exception e) {

                    log.e("cale", e.getMessage());

                }

            default:
                return 0;

        }

    }

    private boolean getResult() {
        if (currentOperator == "") return false;
        String[] operation = display.split(Pattern.quote(currentOperator));
        if (operation.length < 2) {
            return false;
        }
        //result store and return calculated by passing in to  the iperatecalculation
        result = String.valueOf(operateCalculation(operation[0], operation[1], currentOperator));
        return true;

    }

    public void onClickEqual(View v) {
        if (display == "") return;
        if (!getResult()) return;

        screen.setText(String.valueOf(result)+ "\n" +display);


    }


}



