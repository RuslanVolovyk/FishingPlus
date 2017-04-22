package com.softgroup.fishingplus.screens;

import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.softgroup.fishingplus.MainActivity;
import com.softgroup.fishingplus.Utils;
import com.softgroup.fishingplus.data.GPSCurrentPosition;
import com.softgroup.fishingplus.data.JsonWeatherParser;
import com.softgroup.fishingplus.data.WeatherHttpClient;
import com.softgroup.fishingplus.models.Weather;


public class SplashActivity extends AppCompatActivity  {
    private static final String TAG = SplashActivity.class.getName();

    public static final String WEATHER = "weather";

    private double temperature;
    private String icon;
    private int pressure;

    private String sunRise;
    private String sunSet;
    private String lastUpdate;
    private String cityName;
    private String description;
    private float wind;
    private float humidity;

    //private static final int SPLASH_LENGTH = 20;

    Location location;
    Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GPSCurrentPosition gpsCurrentPosition = new GPSCurrentPosition(SplashActivity.this);
        location = gpsCurrentPosition.getLocation();

        if (location == null) {
            Log.v(TAG, "Location == null");

        }
        double lat = location.getLatitude();
        double lon = location.getLongitude();
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(String.format("?lat=%.4f&lon=%.4f&units=metric", lat, lon));

        Log.v(TAG, "Latitude and Longitude" + lat + lon);

        startMainactivity();
    }



    public class WeatherTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... strings) {

            if (strings.length == 0) {
                return null;
            }
            String data = ((new WeatherHttpClient()).getWeatherData(strings[0]));

            if (data == null) {
                Log.v(TAG, "Data null");
                return null;
            } else {
                Log.v(TAG, "Data "+ data);
            }
            weather = JsonWeatherParser.getWeather(data);

            if (weather == null) {
                Log.v(TAG, "Weather null");

                return null;
            } else {
                Log.v(TAG, "Weather " + weather.getCity());

            }
            return weather;
        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            cityName = weather.getCity() + ", " + weather.getCountry();
            temperature = weather.getTemp();
            humidity = weather.getHuminity();
            pressure = Utils.convertHpaToMMHg(weather.getPressure());
            wind = weather.getSpeed();
            sunRise = Utils.formatTimeFromSunSetandSunRise(weather.getSunrise());
            sunSet = Utils.formatTimeFromSunSetandSunRise(weather.getSunset());
            lastUpdate = Utils.getCurrentDate();
            description = weather.getCondition() + " (" + weather.getDescription() + ")";
            icon = Utils.getImage(weather.getIcon());
            Log.v(TAG, "Weather " + weather.getTemp());
            Log.v(TAG, "Weather " + weather.getHuminity());
            Log.v(TAG, "Weather " + Utils.convertHpaToMMHg(weather.getPressure()));
            Log.v(TAG, "Weather " + Utils.formatTimeFromSunSetandSunRise(weather.getSunrise()));
            Log.v(TAG, "Weather " + Utils.formatTimeFromSunSetandSunRise(weather.getSunset()));

            Log.v(TAG, "Weather1 " + weather);

            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            intent.putExtra(WEATHER, weather);
            startActivity(intent);
        }
    }

    public void startMainactivity() {



    }
}
