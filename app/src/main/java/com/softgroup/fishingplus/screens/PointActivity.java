package com.softgroup.fishingplus.screens;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;


public class PointActivity extends BaseFragmentActivity {
    public static final String POINT_ID = "Point id";

    public static Intent newIntent(Context context, UUID uuid){
        Intent intent = new Intent (context, PointActivity.class);
        intent.putExtra(POINT_ID, uuid);
        return intent;
    }

    @Override
    protected Fragment createFragment() {

        UUID uuid = (UUID) getIntent().getSerializableExtra(POINT_ID);
        return PointFragment.newInstance(uuid);
    }

}
