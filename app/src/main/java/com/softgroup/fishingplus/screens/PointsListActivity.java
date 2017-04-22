package com.softgroup.fishingplus.screens;

import android.support.v4.app.Fragment;

import com.softgroup.fishingplus.data.GPSCurrentPosition;

public class PointsListActivity extends BaseFragmentActivity {
    private static final String TAG = PointsListActivity.class.getName();

    GPSCurrentPosition gpsCurrentPosition = new GPSCurrentPosition(this);
    WeatherActivity weatherActivity = new WeatherActivity();





    @Override
    protected Fragment createFragment() {
        return new PointListFragment();
    }
}

