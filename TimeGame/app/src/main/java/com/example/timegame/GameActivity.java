package com.example.timegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private Button p1Button, p2Button;
    private TextView textTimer;
    //remaining time
    private long remanTime;
    //variables from MainActivity
    private String P1, P2;
    //flag to control buttons enable and disable
    private int flag;
    CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        remanTime = 16000;
        p1Button = (Button)findViewById(R.id.player1Button);
        p2Button = (Button)findViewById(R.id.player2Button);
        textTimer = (TextView)findViewById(R.id.timerText);

        flag = 0;

        Intent incomingIntent = getIntent();
        P1 = incomingIntent.getStringExtra("player1");
        P2 = incomingIntent.getStringExtra("player2");

        p1Button.setText(P1);
        p2Button.setText(P2);
    }


    //is flag 0 -> start timer and set flag variable to 1,     is flag 1-> stop timer and set flag variable to 0 and disable p1Button, enable p2Button
    public void startButton1(View v) {
        if (flag==0) {
            //will be functionalized and optimized
            mCountDownTimer = new CountDownTimer(remanTime, 5) {
                @Override
                public void onTick(long millisUntilFinished) {
                    // Update the UI with the remaining time
                    textTimer.setText("Time remaining: " + millisUntilFinished / 1000);
                    remanTime = millisUntilFinished;
                }

                @Override
                public void onFinish() {
                    // Handle the timer finish event
                    textTimer.setText(P2 + " is won");
                    remanTime = 16000;
                }
            }.start();
            flag = 1;
        }
        else if(flag==1) {
            mCountDownTimer.cancel();
            flag = 0;
            p1Button.setEnabled(false);
            p2Button.setEnabled(true);
        }
    }

    //is flag 0 -> start timer and set flag variable to 1,     is flag 1-> stop timer and set flag variable to 0 and disable p2Button, enable p1Button
    public void startButton2(View v) {
        if (flag==0) {
            //will be functionalized and optimized
            mCountDownTimer = new CountDownTimer(remanTime, 5) {
                @Override
                public void onTick(long millisUntilFinished) {
                    // Update the UI with the remaining time
                    textTimer.setText("Time remaining: " + millisUntilFinished / 1000);
                    remanTime = millisUntilFinished;
                }

                @Override
                public void onFinish() {
                    // Handle the timer finish event
                    textTimer.setText(P1 + " is won");
                    remanTime = 16000;
                }
            }.start().start();
            flag = 1;
        }
        else if(flag==1) {
            mCountDownTimer.cancel();
            flag = 0;
            p2Button.setEnabled(false);
            p1Button.setEnabled(true);
        }
    }
}