package com.example.codingtown.homeloancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Loan extends AppCompatActivity {
    Button loginbt,clearbt;
    EditText loanamt, interstrate, months;
    TextView mpay, tpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        loanamt = (EditText) findViewById(R.id.editText1);
        interstrate = (EditText) findViewById(R.id.editText2);
        months = (EditText) findViewById(R.id.editText3);
        mpay = (TextView) findViewById(R.id.View1);
        tpay = (TextView) findViewById(R.id.View2);
        loginbt = (Button) findViewById(R.id.button1);
        clearbt = (Button) findViewById(R.id.button2);

        loginbt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                double loanAmount = Integer.parseInt(loanamt.getText().toString());
                double interestRate = (Integer.parseInt(interstrate.getText().toString()));
                double loanPeriod = Integer.parseInt(months.getText().toString());
                double r = interestRate / 1200;
                double r1 = Math.pow(r + 1, loanPeriod);

                double monthlyPayment = (double)((r + (r / (r1 - 1))) * loanAmount);
                double totalPayment = monthlyPayment * loanPeriod;

                mpay.setText(new DecimalFormat("##.##").format(monthlyPayment));
                tpay.setText(new DecimalFormat("##.##").format(totalPayment));
            }
        });

        clearbt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
              loanamt.setText("");
                interstrate.setText("");
                months.setText("");
                mpay.setText("");
                tpay.setText("");


            }
        });
    }
}


