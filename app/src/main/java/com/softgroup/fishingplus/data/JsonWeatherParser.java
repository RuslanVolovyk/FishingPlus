package com.softgroup.fishingplus.data;

import com.softgroup.fishingplus.utils.Utils;
import com.softgroup.fishingplus.models.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Администратор on 13.04.2017.
 */

public class JsonWeatherParser {

    public static Weather getWeather(String data) {
        Weather weather = new Weather();

        try {
            JSONObject jsonObject = new JSONObject(data);

            JSONObject sysObj = Utils.getObject("sys", jsonObject);

            weather.setCountry(Utils.getString("country", sysObj));
            weather.setSunrise(Utils.getInt("sunrise", sysObj));
            weather.setSunset(Utils.getInt("sunset", sysObj));
            weather.setCity(Utils.getString("name", jsonObject));

            JSONArray weatherArray = jsonObject.getJSONArray("weather");

            JSONObject weatherObj = weatherArray.getJSONObject(0);
            weather.setWeatherId(Utils.getInt("id", weatherObj));
            weather.setIcon(Utils.getString("icon", weatherObj));

            JSONObject mainObj = Utils.getObject("main", jsonObject);
            weather.setHuminity(Utils.getInt("humidity", mainObj));
            weather.setPressure(Utils.getInt("pressure", mainObj));
            weather.setTemp(Utils.getDouble("temp", mainObj));

            JSONObject windObj = Utils.getObject("wind", jsonObject);
            weather.setSpeed(Utils.getFloat("speed", windObj));

            return weather;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}

