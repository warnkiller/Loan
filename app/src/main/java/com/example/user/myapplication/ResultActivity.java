package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView textViewStatus,textViewMonthly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewStatus=(TextView)findViewById(R.id.statusText);
        textViewMonthly=(TextView)findViewById(R.id.monthlyText);
        //method that asking who called this activity
        Intent intent=getIntent();
        String status=intent.getStringExtra(MainActivity.LOAN_STATUS);
        double repayment = intent.getDoubleExtra(MainActivity.LOAN_REPAYMENT,0);
        textViewStatus.setText("Status :"+status);
        textViewMonthly.setText("Monthly Payment :"+repayment);
        //For numerical

    }
    public void closeEvent(View view){
        finish();
    }
}
