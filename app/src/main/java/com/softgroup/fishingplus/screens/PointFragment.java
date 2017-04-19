package com.softgroup.fishingplus.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.models.Point;

/**
 * Created by Администратор on 19.04.2017.
 */

public class PointFragment extends Fragment {
    Point point;
    EditText editTextTitle;
    EditText editTextDescription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        point = new Point();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_point_detail, container,false);
        return view;
    }
}
