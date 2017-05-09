package com.softgroup.fishingplus.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.Utils;
import com.softgroup.fishingplus.models.Weather;

import static com.softgroup.fishingplus.screens.SplashActivity.WEATHER;


public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = WeatherActivity.class.getName();
    private TextView cityName;
    private TextView temperature;
    private ImageView icon;
    private TextView description;
    private TextView humidity;
    private TextView pressure;
    private TextView wind;
    private TextView sunRise;
    private TextView sunSet;
    private TextView lastUpdate;
    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weather = getIntent().getExtras().getParcelable(WEATHER);
        cityName = (TextView) findViewById(R.id.text_view_city);
        cityName.setText(weather.getCity() + ", " + weather.getCountry());
        temperature = (TextView) findViewById(R.id.text_view_temperatura);
        temperature.setText(String.format("%.1f °C", weather.getTemp()));
        icon = (ImageView) findViewById(R.id.image_view);
        Glide.with(WeatherActivity.this)
                .load(Utils.getImage(weather.getIcon()))
                .into(icon);
        description = (TextView) findViewById(R.id.text_view_clouds);
        description.setText("Облачность: " + weather.getCondition() + " (" + weather.getDescription() + ")");
        humidity = (TextView) findViewById(R.id.text_view_humidity);
        humidity.setText("Влажность воздуха: " + weather.getHuminity() + " %");
        pressure = (TextView) findViewById(R.id.text_view_pressure);
        pressure.setText("Давление: " + Utils.convertHpaToMMHg(weather.getPressure()) + " мм рт.ст.");
        wind = (TextView) findViewById(R.id.text_view_wind);
        wind.setText("Скорость ветра: " + weather.getSpeed() + " м/с");
        sunRise = (TextView) findViewById(R.id.text_view_sun_rise);
        sunRise.setText(String.format("Восход солнца: %s ", Utils.formatTimeFromSunSetandSunRise(weather.getSunrise())));
        sunSet = (TextView) findViewById(R.id.text_view_sun_set);
        sunSet.setText(String.format("Закат солнца: %s ", Utils.formatTimeFromSunSetandSunRise(weather.getSunset())));
        lastUpdate = (TextView) findViewById(R.id.text_view_last_update);
        lastUpdate.setText(String.format("Последнее обновление: %s", Utils.getCurrentDate()));

    }

}
