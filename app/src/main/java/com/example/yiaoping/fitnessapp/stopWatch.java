package com.example.yiaoping.fitnessapp;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class stopWatch extends AppCompatActivity {

    Button btnStart, btnStop, btnLap;
    TextView txtTimer;
    Handler customHandler = new Handler();
    LinearLayout container;

    long startTime = 0L, millisecondsTime=0L, timeSwap=0L, timeUpdate=0L;

    Runnable updateTimerThread = new Runnable(){
        @Override
        public void run(){
            millisecondsTime = SystemClock.uptimeMillis()-startTime;
            timeUpdate = timeSwap+millisecondsTime;
            int seconds = (int)(timeUpdate/1000);
            int minutes = seconds/60;
            seconds%=60;
            int milliseconds = (int)(timeUpdate%1000);
            txtTimer.setText(""+minutes+":"+String.format("%2d",seconds)+":"+String.format("%3d",milliseconds));
            customHandler.postDelayed(this,0);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = (Button)findViewById(R.id.btnStart);
        btnStop = (Button)findViewById(R.id.btnStop);
        btnLap = (Button)findViewById(R.id.btnLap);
        txtTimer = (TextView)findViewById(R.id.timerValue);
        container = (LinearLayout)findViewById(R.id.container);

        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startTime = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread, 0);

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                timeSwap+=millisecondsTime;
                customHandler.removeCallbacks((updateTimerThread));
            }
        });
        btnLap.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View addView = inflater.inflate(R.layout.layout,null);
                TextView txtValue= (TextView)addView.findViewById(R.id.txtContent);
                txtValue.setText(txtTimer.getText());
                container.addView(addView);
            }
        });

    }
}
