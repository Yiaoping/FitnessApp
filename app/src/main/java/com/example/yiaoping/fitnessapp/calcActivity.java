package com.example.yiaoping.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.edit;
import static java.sql.Types.NULL;

public class calcActivity extends AppCompatActivity {
    double maxLift;
    Integer maxLiftInt;
    EditText weight;
    EditText rep;
    String weightResult;
    String repResult;
    int intWeight;
    int intRep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
    }

    public void calcMax(View view){
        weight = (EditText)findViewById(R.id.editText);
        rep = (EditText)findViewById(R.id.editText2);
        weightResult = weight.getText().toString();
        repResult = rep.getText().toString();

        System.out.println(intWeight);
        System.out.println(intRep);
        intWeight=Integer.parseInt(weightResult);
        intRep=Integer.parseInt(repResult);

        maxLift = intWeight/(1.0278-(0.0278*intRep));
        maxLiftInt = (int)maxLift;
        Context context = getApplicationContext();
        CharSequence text = "Your max is: " + maxLiftInt + " pounds";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
