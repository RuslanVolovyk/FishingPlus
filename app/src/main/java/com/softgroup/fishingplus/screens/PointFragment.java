package com.softgroup.fishingplus.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.Utils;
import com.softgroup.fishingplus.models.Point;
import com.softgroup.fishingplus.models.PointSingle;

import java.util.UUID;

/**
 * Created by Администратор on 19.04.2017.
 */

public class PointFragment extends Fragment {
    private Point point;
    private EditText editTextName;
    private EditText editTextDescription;
    private TextView datePoint;

    public static final String ARGUMENTS = "id";

    public static PointFragment newInstance(UUID uuid){
        Bundle arg = new Bundle();
        arg.putSerializable(ARGUMENTS, uuid);

        PointFragment pointFragment = new PointFragment();
        pointFragment.setArguments(arg);

        return pointFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID uuid = (UUID)getArguments().getSerializable(ARGUMENTS);
        point= PointSingle.get(getActivity()).getPoint(uuid);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_point_detail, container,false);

        editTextName = (EditText) view.findViewById(R.id.point_title_label_hint);
        editTextName.setText(point.getName());
        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                point.setName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        editTextDescription = (EditText) view.findViewById(R.id.point_description);
        editTextDescription.setText(point.getDescription());
        editTextDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                point.setDescription(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        datePoint = (TextView) view.findViewById(R.id.point_date);
        datePoint.setText(Utils.getCurrentDate());

        return view;
    }
}
