package com.softgroup.fishingplus.data;

import com.softgroup.fishingplus.Utils;
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

            //get coor

//            JSONObject coorObj = Utils.getObject("coord", jsonObject);
//
//            place.setLat(Utils.getFloat("lat", coorObj));
//            place.setLon(Utils.getFloat("lon", coorObj));

            //get sys data

            JSONObject sysObj = Utils.getObject("sys", jsonObject);
            weather.setCountry(Utils.getString("country", sysObj));
            weather.setSunrise(Utils.getInt("sunrise", sysObj));
            weather.setSunset(Utils.getInt("sunset", sysObj));

            //get  cityname data from main jsonObject
            //  place.setLastUpdate(Utils.getInt("dt", jsonObject));
            weather.setCity(Utils.getString("name", jsonObject));



            //get weather

            JSONArray weatherArray = jsonObject.getJSONArray("weather");
            JSONObject weatherObj = weatherArray.getJSONObject(0);
            weather.setWeatherId(Utils.getInt("id", weatherObj));
            weather.setDescription(Utils.getString("description", weatherObj));
            weather.setCondition(Utils.getString("main", weatherObj));
            weather.setIcon(Utils.getString("icon", weatherObj));

            //get main () data

            JSONObject mainObj = Utils.getObject("main", jsonObject);
            weather.setHuminity(Utils.getInt("humidity", mainObj));
            weather.setPressure(Utils.getInt("pressure", mainObj));
            // weather.currentCondition.setMinTemp(Utils.getFloat("temp_min", mainObj));
            //weather.currentCondition.setMaxTemp(Utils.getFloat("temp_max", mainObj));
            weather.setTemp(Utils.getDouble("temp", mainObj));


            //get wind data
            JSONObject windObj = Utils.getObject("wind", jsonObject);
            weather.setSpeed(Utils.getFloat("speed", windObj));

            //get clouds data
            JSONObject cloudsObj = Utils.getObject("clouds", jsonObject);
            weather.setPrecipitation(Utils.getInt("all", cloudsObj));

            return weather;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}

