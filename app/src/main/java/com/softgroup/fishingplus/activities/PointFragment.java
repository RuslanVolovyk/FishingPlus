package com.softgroup.fishingplus.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.utils.Utils;
import com.softgroup.fishingplus.models.Point;
import com.softgroup.fishingplus.models.PointSingle;

import java.util.UUID;


public class PointFragment extends Fragment {
    private Point point;
    private EditText editTextName;
    private EditText editTextDescription;
    private TextView datePoint;
    private TextView lon;
    private TextView lat;
    private TextView temperature;
    private TextView pressure;
    private TextView humidity;
    private TextView wind;


    public static final String ARGUMENTS = "id";

    public static PointFragment newInstance(UUID uuid) {
        Bundle arg = new Bundle();
        arg.putSerializable(ARGUMENTS, uuid);

        PointFragment pointFragment = new PointFragment();
        pointFragment.setArguments(arg);
        return pointFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        UUID uuid = (UUID) getArguments().getSerializable(ARGUMENTS);
        point = PointSingle.get(getActivity()).getPoint(uuid);
        Log.v("Referee", "onCreate" + point.getTemperature());

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.delete_point, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_delete_points:
                PointSingle.get(getActivity()).deletePoint(point);
                getActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        super.onPause();

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_point_detail, container, false);
        Log.v("Referee", "onCreateView" + point.getTemperature());

        try {
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
            datePoint.setText(point.getDate().toString());
            lat = (TextView) view.findViewById(R.id.point_lantituda);
            lat.setText(String.valueOf("Широта: " + point.getLat()));
            lon = (TextView) view.findViewById(R.id.point_longituda);
            lon.setText(String.valueOf("Долгота: " + point.getLon()));
            temperature = (TextView) view.findViewById(R.id.point_temperatura);
            temperature.setText(String.format(getString(R.string.temperatura), point.getTemperature()));
            humidity = (TextView) view.findViewById(R.id.point_humidity);
            humidity.setText("Влажность воздуха: " + point.getHumidity() + " %");
            pressure = (TextView) view.findViewById(R.id.point_pressure);
            pressure.setText("Давление: " + Utils.convertHpaToMMHg(point.getPressure()) + " мм рт.ст.");
            wind = (TextView) view.findViewById(R.id.point_wind_speed);
            wind.setText("Скорость ветра: " + String.valueOf(point.getWind()) + " м/с");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
}
