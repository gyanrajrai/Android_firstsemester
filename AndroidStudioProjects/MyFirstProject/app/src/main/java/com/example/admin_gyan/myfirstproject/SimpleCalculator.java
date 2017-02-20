package com.example.admin_gyan.myfirstproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Admin_GYAN on 1/2/2017.
 */

public class SimpleCalculator extends Activity implements View.OnClickListener {
    private EditText screen;
    double num1, num2;
    private String currentOperatorsign = "";
    Button btnadd, btnsub, btnmul, btndivide, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btndot, btnclr,btnequal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplecalculator);
        initialize();
    }

    public void initialize() {
        screen = (EditText) findViewById(R.id.txtscreens);
        (btnadd = (Button) findViewById(R.id.btnAdd)).setOnClickListener(this);
        (btnsub = (Button) findViewById(R.id.btnminuss)).setOnClickListener(this);
        (btnmul = (Button) findViewById(R.id.btnmultiplications)).setOnClickListener(this);
        (btndivide = (Button) findViewById(R.id.btndivides)).setOnClickListener(this);
        (btn0 = (Button) findViewById(R.id.btnzeros)).setOnClickListener(this);

        (btn1 = (Button) findViewById(R.id.btnones)).setOnClickListener(this);

        (btn2 = (Button) findViewById(R.id.btntwos)).setOnClickListener(this);

        (btn3 = (Button) findViewById(R.id.btnthrees)).setOnClickListener(this);
        (btn4 = (Button) findViewById(R.id.btnfours)).setOnClickListener(this);

        (btn5 = (Button) findViewById(R.id.btnfives)).setOnClickListener(this);

        (btn6 = (Button) findViewById(R.id.btnsixs)).setOnClickListener(this);

        (btn7 = (Button) findViewById(R.id.btnsevens)).setOnClickListener(this);
        (btn8 = (Button) findViewById(R.id.btneights)).setOnClickListener(this);
        (btn9 = (Button) findViewById(R.id.btnnines)).setOnClickListener(this);
        (btndot = (Button) findViewById(R.id.btndots)).setOnClickListener(this);
        (btnclr = (Button) findViewById(R.id.btnclears)).setOnClickListener(this);

        (btnequal= (Button) findViewById(R.id.btnequals)).setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnzeros:
                screen.append("0");
                break;
            case R.id.btnones:
                screen.append("1");
                break;
            case R.id.btntwos:
                screen.append("2");
                break;
            case R.id.btnthrees:
                screen.append("3");
                break;
            case R.id.btnfours:
                screen.append("4");
                break;
            case R.id.btnfives:
                screen.append("5");
                break;
            case R.id.btnsixs:
                screen.append("6");
                break;
            case R.id.btnsevens:
                screen.append("7");
                break;
            case R.id.btneights:
                screen.append("8");
                break;
            case R.id.btnnines:
                screen.append("9");
                break;
            case R.id.btndots:
                screen.append(".");
                break;
            case R.id.btnclears:
                screen.setText("");
                break;

            case R.id.btnAdd:

                num1 = Double.parseDouble(screen.getText().toString());
                screen.setText("");
                currentOperatorsign = "+";
                break;
            case R.id.btnminuss:
                num1 = Double.parseDouble(screen.getText().toString());
                screen.setText("");
                currentOperatorsign = "-";
                break;
            case R.id.btnmultiplications:
                num1 = Double.parseDouble(screen.getText().toString());
                screen.setText("");
                currentOperatorsign = "*";
                break;
            case R.id.btndivides:
                num1 = Double.parseDouble(screen.getText().toString());
                screen.setText("");
                currentOperatorsign = "/";
                break;

            case R.id.btnequals:


                num2 = Double.parseDouble(screen.getText().toString());

                Log.e("Test",num1+""+num2);

                if (currentOperatorsign.equals("+")) {
                    screen.setText(Double.toString(num1 + num2));
                    Log.e("Test",num1+""+num2);

                } else if (currentOperatorsign == "-") {
                    screen.setText(Double.toString(num1 - num2));
                } else if (currentOperatorsign == ("*")) {
                    screen.setText(Double.toString(num1 * num2));

                } else if (currentOperatorsign == "/") {
                    if(num2==0){
                        screen.setText("Ma ERROR");
                    }

                    else screen.setText(Double.toString(num1/num2));
                }
                currentOperatorsign = "";


        }


    }
}
