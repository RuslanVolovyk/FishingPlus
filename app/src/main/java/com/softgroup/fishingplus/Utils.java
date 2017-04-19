package com.softgroup.fishingplus;

import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Администратор on 20.03.2017.
 */

public class Utils {
    public static final String FRIENDLY_MSG_LENGTH = "friendly_msg_length";
    public static final String OPEN_WEATHER_MAP_API_KEY = "&appid=d3bf86bef1b2822625c633f6161032fe";
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";


    public static JSONObject getObject (String string, JSONObject jsonObject) throws JSONException {
        JSONObject object = jsonObject.getJSONObject(string);

        return object;
    }
    public static String getString (String string, JSONObject jsonObject) throws JSONException{

        return jsonObject.getString(string);
    }

    public static float getFloat (String string, JSONObject jsonObject) throws JSONException{

        return (float) jsonObject.getDouble(string);
    }
    public static double getDouble (String string, JSONObject jsonObject) throws JSONException{

        return (float) jsonObject.getDouble(string);
    }
    public static int getInt (String string, JSONObject jsonObject) throws JSONException{

        return jsonObject.getInt(string);
    }
    public static String getImage(String icon){
        return String.format("http://openweathermap.org/img/w/%s.png",icon);
    }
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public static String formatTimeFromSunSetandSunRise(double unixTimeStamp){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime((long)unixTimeStamp*1000);
        return dateFormat.format(date);
    }
    public static int convertHpaToMMHg (float pressure){
        int convertPressure = (int) (pressure * 0.75006375541921);

        return convertPressure;
    }
    public static boolean isBlankField(EditText etPersonData) {
        return etPersonData.getText().toString().trim().equals("");
    }

}
