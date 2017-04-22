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

    Weather weather;

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



//        GPSCurrentPosition gpsCurrentPosition = new GPSCurrentPosition(WeatherActivity.this);
//        location = gpsCurrentPosition.getLocation();
//
//
//        if (location == null) {
//            Log.v(TAG, "Location == null");
//
//        }
//        double lat = location.getLatitude();
//        double lon = location.getLongitude();
//        WeatherTask weatherTask = new WeatherTask();
//        weatherTask.execute(String.format("?lat=%.4f&lon=%.4f&units=metric", lat, lon));
//
//        Log.v(TAG, "Latitude and Longitude" + lat + lon);

    }

//    public class WeatherTask extends AsyncTask<String, Void, Weather> {
//
//        @Override
//        protected Weather doInBackground(String... strings) {
//
//            if (strings.length == 0) {
//                return null;
//            }
//            String data = ((new WeatherHttpClient()).getWeatherData(strings[0]));
//
//            if (data == null) {
//                Log.v(TAG, "Data null");
//                return null;
//            } else {
//                Log.v("Data", data);
//            }
//            weather = JsonWeatherParser.getWeather(data);
//
//            if (weather == null) {
//                Log.v(TAG, "Weather null");
//
//                return null;
//            } else {
//                Log.v(TAG, "Weather" + weather.place.getCity());
//
//            }
//            return weather;
//        }
//
//        @Override
//        protected void onPostExecute(Weather weather) {
//            super.onPostExecute(weather);
//
//            cityName.setText(weather.place.getCity() + ", " + weather.place.getCountry());
//            temperature.setText(String.format("%.1f °C", weather.currentCondition.getTemp()));
//            humidity.setText("Влажность воздуха: " + weather.currentCondition.getHuminity() + " %");
//            pressure.setText("Давление: " + Utils.convertHpaToMMHg(weather.currentCondition.getPressure()) + " мм рт.ст.");
//            wind.setText("Скорость ветра: " + weather.wind.getSpeed() + " м/с");
//            sunRise.setText(String.format("Восход солнца: %s ", Utils.formatTimeFromSunSetandSunRise(weather.place.getSunrise())));
//            sunSet.setText(String.format("Закат солнца: %s ", Utils.formatTimeFromSunSetandSunRise(weather.place.getSunset())));
//            lastUpdate.setText(String.format("Последнее обновление: %s", Utils.getCurrentDate()));
//            description.setText("Облачность: " + weather.currentCondition.getCondition() + " (" + weather.currentCondition.getDescription() + ")");
//            Glide.with(WeatherActivity.this)
//                    .load(Utils.getImage(weather.currentCondition.getIcon()))
//                    .into(icon);
//
//        }
//    }
}

