package com.softgroup.fishingplus.screens;

import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.softgroup.fishingplus.data.GPSCurrentPosition;
import com.softgroup.fishingplus.data.JsonWeatherParser;
import com.softgroup.fishingplus.data.WeatherHttpClient;
import com.softgroup.fishingplus.models.Weather;


public class SplashActivity extends AppCompatActivity {
    private static final String TAG = SplashActivity.class.getName();
    public static final String WEATHER = "weather";

    private Location location;
    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GPSCurrentPosition gpsCurrentPosition = new GPSCurrentPosition(SplashActivity.this);
        double lat = 0;
        double lon = 0;
        try {
            location = gpsCurrentPosition.getLocation();

            if (location == null) {
                Log.v(TAG, "Location == null");

            }
            lat = location.getLatitude();
            lon = location.getLongitude();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(String.format("?lat=%.4f&lon=%.4f&units=metric", lat, lon));

        Log.v(TAG, "Latitude and Longitude" + lat + lon);

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
                Log.v(TAG, "Data " + data);
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

            Intent intent = new Intent(SplashActivity.this, ChatActivity.class);
            intent.putExtra(WEATHER, weather);
            startActivity(intent);
        }
    }

}
