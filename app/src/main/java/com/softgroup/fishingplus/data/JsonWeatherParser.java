package com.softgroup.fishingplus.data;

import com.softgroup.fishingplus.Utils;
import com.softgroup.fishingplus.models.Place;
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
            Place place = new Place();

            //get coor

//            JSONObject coorObj = Utils.getObject("coord", jsonObject);
//
//            place.setLat(Utils.getFloat("lat", coorObj));
//            place.setLon(Utils.getFloat("lon", coorObj));

            //get sys data

            JSONObject sysObj = Utils.getObject("sys", jsonObject);
            place.setCountry(Utils.getString("country", sysObj));
            place.setSunrise(Utils.getInt("sunrise", sysObj));
            place.setSunset(Utils.getInt("sunset", sysObj));

            //get  cityname data from main jsonObject
            //  place.setLastUpdate(Utils.getInt("dt", jsonObject));
            place.setCity(Utils.getString("name", jsonObject));

            weather.place = place;


            //get weather

            JSONArray weatherArray = jsonObject.getJSONArray("weather");
            JSONObject weatherObj = weatherArray.getJSONObject(0);
            weather.currentCondition.setWeatherId(Utils.getInt("id", weatherObj));
            weather.currentCondition.setDescription(Utils.getString("description", weatherObj));
            weather.currentCondition.setCondition(Utils.getString("main", weatherObj));
            weather.currentCondition.setIcon(Utils.getString("icon", weatherObj));

            //get main () data

            JSONObject mainObj = Utils.getObject("main", jsonObject);
            weather.currentCondition.setHuminity(Utils.getInt("humidity", mainObj));
            weather.currentCondition.setPressure(Utils.getInt("pressure", mainObj));
            // weather.currentCondition.setMinTemp(Utils.getFloat("temp_min", mainObj));
            //weather.currentCondition.setMaxTemp(Utils.getFloat("temp_max", mainObj));
            weather.currentCondition.setTemp(Utils.getDouble("temp", mainObj));


            //get wind data
            JSONObject windObj = Utils.getObject("wind", jsonObject);
            weather.wind.setSpeed(Utils.getFloat("speed", windObj));
            weather.wind.setDeg(Utils.getFloat("deg", windObj));

            //get clouds data
            JSONObject cloudsObj = Utils.getObject("clouds", jsonObject);
            weather.clouds.setPrecipitation(Utils.getInt("all", cloudsObj));

            return weather;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}

