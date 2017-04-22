package com.softgroup.fishingplus.screens;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.data.GPSCurrentPosition;

/**
 * Created by Администратор on 19.04.2017.
 */

public abstract class BaseFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment =createFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();

        }
    }
}
