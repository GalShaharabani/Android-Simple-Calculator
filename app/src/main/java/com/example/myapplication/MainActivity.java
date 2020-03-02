package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
        EditText editText;
        TextView infoTextView;
        private double valueOne=Double.NaN;
        private double valueTwo;
        private static final char ADDITION = '+';
        private static final char SUBTRACTION = '-';
        private static final char MULTIPLICATION = '*';
        private static final char DIVISION = '/';
        private char CURRENT_ACTION;
        DecimalFormat decimalFormat = new DecimalFormat(getString(R.string.decimalFormat));


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            editText=findViewById(R.id.editTextCalc1);
            infoTextView=findViewById(R.id.infoTextView);

        }


    public void Button1(View view) {
        editText.setText(editText.getText()+getString(R.string.button1));
    }

    public void Button2(View view) {
        editText.setText(editText.getText()+getString(R.string.button2));
    }

    public void Button3(View view) {
        editText.setText(editText.getText()+getString(R.string.button3));
    }

    public void Button4(View view) {
        editText.setText(editText.getText()+getString(R.string.button4));
    }

    public void Button5(View view) {
        editText.setText(editText.getText()+getString(R.string.button5));
    }

    public void Button6(View view) {
        editText.setText(editText.getText()+getString(R.string.button6));
    }

    public void Button7(View view) {
        editText.setText(editText.getText()+getString(R.string.button7));
    }

    public void Button8(View view) {
        editText.setText(editText.getText()+getString(R.string.button8));
    }

    public void Button9(View view) {
        editText.setText(editText.getText()+getString(R.string.button9));
    }

    public void Button0(View view) {
        editText.setText(editText.getText()+getString(R.string.button0));
    }

    public void Decimal(View view){
        editText.setText(editText.getText()+getString(R.string.buttonDec));
    }


    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(editText.getText().toString());
            editText.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(editText.getText().toString());
            }
            catch (Exception e){}
        }

    }


    public void Add(View view) {
        computeCalculation();
        CURRENT_ACTION = ADDITION;
        infoTextView.setText(decimalFormat.format(valueOne) + getString(R.string.buttonAdd));
        editText.setText(null);
    }

    public void Subtract(View view) {
        computeCalculation();
        CURRENT_ACTION = SUBTRACTION;
        infoTextView.setText(decimalFormat.format(valueOne) + getString(R.string.buttonSub));
        editText.setText(null);
    }


    public void Multiply(View view) {
        computeCalculation();
        CURRENT_ACTION = MULTIPLICATION;
        infoTextView.setText(decimalFormat.format(valueOne) + getString(R.string.buttonMulti));
        editText.setText(null);
    }


    public void divide(View view) {
        computeCalculation();
        CURRENT_ACTION = DIVISION;
        infoTextView.setText(decimalFormat.format(valueOne) + getString(R.string.buttonDiv));
        editText.setText(null);
    }


    public void Equal(View view) {
        computeCalculation();
        infoTextView.setText(infoTextView.getText().toString() +
                decimalFormat.format(valueTwo) + getString(R.string.buttonEqual) + decimalFormat.format(valueOne));
        valueOne = Double.NaN;
        CURRENT_ACTION = '0';
    }

    public void Clear(View view){
        infoTextView.setText(null);
    }
}
