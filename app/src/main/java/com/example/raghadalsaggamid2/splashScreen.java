package com.example.raghadalsaggamid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        TimerTask task = new TimerTask() {


            @Override
            public void run() {
                finish();
                startActivity(new Intent(splashScreen.this,MainActivity.class));
            }

        };
        Timer opening=new Timer();
        opening.schedule(task,5000);
    }
}