package com.softgroup.fishingplus.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.models.Weather;

import static com.softgroup.fishingplus.activities.SplashActivity.WEATHER;

public class PointsListActivity extends AppCompatActivity {
    private static final String TAG = PointsListActivity.class.getName();
    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        try {
            weather = getIntent().getExtras().getParcelable(WEATHER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(WEATHER, weather);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = createFragment();
            fragment.setArguments(bundle);
            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    protected Fragment createFragment() {

        return new PointListFragment();
    }
}
