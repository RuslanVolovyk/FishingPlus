package com.softgroup.fishingplus.screens;

import android.support.v4.app.Fragment;

public class PointsListActivity extends BaseFragmentActivity {
    private static final String TAG = PointsListActivity.class.getName();

    @Override
    protected Fragment createFragment() {
        return new PointListFragment();
    }
}

