package com.softgroup.fishingplus.screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.softgroup.fishingplus.R;

import java.util.UUID;

public class PointActivity extends AppCompatActivity {
    public static final String POINT_ID = "Point id";

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

    public static Intent newIntent(Context context, UUID uuid){
        Intent intent = new Intent (context, PointActivity.class);
        intent.putExtra(POINT_ID, uuid);
        return intent;
    }


    protected Fragment createFragment() {

        UUID uuid = (UUID) getIntent().getSerializableExtra(POINT_ID);
        return PointFragment.newInstance(uuid);
    }

}
