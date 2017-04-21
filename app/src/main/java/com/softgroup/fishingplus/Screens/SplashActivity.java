package com.softgroup.fishingplus.screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.softgroup.fishingplus.MainActivity;


public class SplashActivity extends AppCompatActivity {


    private static final int SPLASH_LENGTH = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WeatherActivity weatherActivity = new WeatherActivity();


         new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, SPLASH_LENGTH);
    }

}
