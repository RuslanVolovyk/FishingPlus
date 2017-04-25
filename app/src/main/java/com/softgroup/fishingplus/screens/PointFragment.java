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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.Utils;
import com.softgroup.fishingplus.data.GPSCurrentPosition;
import com.softgroup.fishingplus.models.Point;
import com.softgroup.fishingplus.models.Weather;

import static com.softgroup.fishingplus.screens.PointsListActivity.POINT;
import static com.softgroup.fishingplus.screens.SplashActivity.WEATHER;

/**
 * Created by Администратор on 19.04.2017.
 */

public class PointFragment extends Fragment {
    private Point point;
    private EditText editTextName;
    private EditText editTextDescription;
    private TextView datePoint;
    private GPSCurrentPosition gpsCurrentPosition;
    private TextView lon;
    private TextView lat;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    Weather weather;


    private TextView condition;


    private TextView temperature;
    private TextView pressure;
    private TextView humidity;
    private TextView wind;


    public static final String ARGUMENTS = "id";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_point_detail, container, false);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("point");


        point = (Point) getArguments().getSerializable(POINT);


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
        lat.setText(String.valueOf("Широта " + point.getLat()));
        lon = (TextView) view.findViewById(R.id.point_longituda);
        lon.setText(String.valueOf("Долгота " + point.getLon()));


        weather = getArguments().getParcelable(WEATHER);


        temperature = (TextView) view.findViewById(R.id.point_temperatura);
        temperature.setText(String.valueOf("Температура: " + point.getTemperature()));

        condition = (TextView) view.findViewById(R.id.point_condition);
        condition.setText("Облачность: " + point.getCondition() + " (" + point.getDescription() + ")");

        humidity = (TextView) view.findViewById(R.id.point_humidity);
        humidity.setText("Влажность воздуха: " + point.getHumidity() + " %");

        pressure = (TextView) view.findViewById(R.id.point_pressure);
        pressure.setText("Давление: " + Utils.convertHpaToMMHg(point.getPressure()) + " мм рт.ст.");

        wind = (TextView) view.findViewById(R.id.point_wind_speed);
        wind.setText("Скорость ветра: " + String.valueOf(point.getWind()) + " м/с");

        ref.push().setValue(point);

        return view;
    }
}
