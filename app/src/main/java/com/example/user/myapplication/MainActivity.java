package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String LOAN_STATUS = "status";
    public static final String LOAN_REPAYMENT = "repayment";
    private EditText editTextPrice,editTextDown,editTextInterest,editTextRepayment,editTextSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrice=(EditText)findViewById(R.id.priceText);
        editTextDown=(EditText)findViewById(R.id.downText);
        editTextInterest=(EditText)findViewById(R.id.interestText);
        editTextRepayment=(EditText)findViewById(R.id.repaymentText);
        editTextSalary=(EditText)findViewById(R.id.salaryText);
    }
    public void calculateLoan(View view){
        double price,downpayment,interest_rate,repayment,salary,total_interest,total_loan,monthlyPayment;
        //get input
        price=Double.parseDouble(editTextPrice.getText().toString());
        downpayment=Double.parseDouble(editTextDown.getText().toString());
        interest_rate=Double.parseDouble(editTextInterest.getText().toString());
        repayment=Double.parseDouble(editTextRepayment.getText().toString());
        salary=Double.parseDouble(editTextSalary.getText().toString());
        //Calculation
        total_interest=(price-downpayment)*(interest_rate/100)*(repayment/12);
        total_loan=(price-downpayment)+total_interest;
        monthlyPayment=total_loan/repayment;
        //send to another layout
        Intent intent=new Intent(this,ResultActivity.class);
        if(monthlyPayment>(salary*0.3)){
            intent.putExtra(LOAN_STATUS, "Rejected");

        }
        else{
            intent.putExtra(LOAN_STATUS, "Accepted");
        }
        //Change UI

        //intent.putExtra(LOAN_STATUS, "Approve");
        intent.putExtra(LOAN_REPAYMENT, monthlyPayment);
        startActivity(intent);

    }
}
