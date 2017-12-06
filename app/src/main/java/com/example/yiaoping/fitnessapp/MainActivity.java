package com.example.yiaoping.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inputDataButton(View view){
        Intent intent = new Intent(this, inputActivity.class);
        startActivity(intent);

    }

    public void calcMaxButton(View view){
        Intent intent = new Intent(this, calcActivity.class);
        startActivity(intent);
    }

    public void stopWatchButton(View view){
        Intent intent = new Intent(this, stopWatch.class);
        startActivity(intent);
    }
}
