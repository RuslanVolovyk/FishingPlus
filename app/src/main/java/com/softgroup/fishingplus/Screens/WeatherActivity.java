package com.softgroup.fishingplus.screens;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.Utils;
import com.softgroup.fishingplus.data.JsonWeatherParser;
import com.softgroup.fishingplus.data.WeatherHttpClient;
import com.softgroup.fishingplus.models.Weather;


public class WeatherActivity extends AppCompatActivity {
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

    Weather weather = new Weather();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weather);

        cityName = (TextView) findViewById(R.id.text_view_city);
        temperature = (TextView) findViewById(R.id.text_view_temperatura);
        icon = (ImageView) findViewById(R.id.image_view);
        description = (TextView) findViewById(R.id.text_view_clouds);
        humidity = (TextView) findViewById(R.id.text_view_humidity);
        pressure = (TextView) findViewById(R.id.text_view_pressure);
        wind = (TextView) findViewById(R.id.text_view_wind);
        sunRise = (TextView) findViewById(R.id.text_view_sun_rise);
        sunSet = (TextView) findViewById(R.id.text_view_sun_set);
        lastUpdate = (TextView) findViewById(R.id.text_view_last_update);

        renderWeatherData("Moscow, ru");


    }

    public void renderWeatherData(String city) {
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(city + "&units=metric");
    }

    private class WeatherTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... strings) {

            if (strings.length == 0) {
                return null;
            }
            String date = ((new WeatherHttpClient()).getWeatherData(strings[0]));

            if (date == null) {
                Log.v("Weather", "null");
                return null;
            } else {
                Log.v("Weather", date);
            }
            weather = JsonWeatherParser.getWeather(date);

            if (weather == null) {
                Log.v("Weather", "null");

                return null;
            } else {
                Log.v("Weather", weather.location.getCity());

            }
            return weather;
        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

            cityName.setText(weather.location.getCity() + ", " + weather.location.getCountry());
            temperature.setText(String.format("%.1f °C", weather.currentCondition.getTemp()));
            humidity.setText("Влажность воздуха: " + weather.currentCondition.getHuminity() + " %");
            pressure.setText("Давление: " + Utils.convertHpaToMMHg(weather.currentCondition.getPressure()) + " мм рт.ст.");
            wind.setText("Скорость ветра: " + weather.wind.getSpeed() + " м/с");
            sunRise.setText(String.format("Восход солнца: %s ",  Utils.formatTimeFromSunSetandSunRise(weather.location.getSunrise())));
            sunSet.setText(String.format("Закат солнца: %s ", Utils.formatTimeFromSunSetandSunRise(weather.location.getSunset())));
            lastUpdate.setText(String.format("Последнее обновление: %s", Utils.getCurrentDate()));
            description.setText("Облачность: " + weather.currentCondition.getCondition() + " (" + weather.currentCondition.getDescription() + ")");
            Glide.with(WeatherActivity.this)
                    .load(Utils.getImage(weather.currentCondition.getIcon()))
                    .into(icon);

        }
    }
}

