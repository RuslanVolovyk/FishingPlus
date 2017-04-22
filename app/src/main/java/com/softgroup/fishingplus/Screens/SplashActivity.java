package com.softgroup.fishingplus.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {


    private static final int SPLASH_LENGTH = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



//         new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                finish();
//            }
//        }, SPLASH_LENGTH);
    }

}
