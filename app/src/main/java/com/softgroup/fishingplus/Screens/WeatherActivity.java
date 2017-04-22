package com.softgroup.fishingplus.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.softgroup.fishingplus.R;
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


//    Location location;
//    Weather weather = new Weather();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weather);
       // SplashActivity splashActivity = new SplashActivity();

        Weather weather = getIntent().getExtras().getParcelable(WEATHER);





        cityName = (TextView) findViewById(R.id.text_view_city);
        temperature = (TextView) findViewById(R.id.text_view_temperatura);
        icon = (ImageView) findViewById(R.id.image_view);
        description = (TextView) findViewById(R.id.text_view_clouds);
        description.setText(weather.getDescription());

        humidity = (TextView) findViewById(R.id.text_view_humidity);
        pressure = (TextView) findViewById(R.id.text_view_pressure);
        wind = (TextView) findViewById(R.id.text_view_wind);


        sunRise = (TextView) findViewById(R.id.text_view_sun_rise);
        sunSet = (TextView) findViewById(R.id.text_view_sun_set);
        lastUpdate = (TextView) findViewById(R.id.text_view_last_update);


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

