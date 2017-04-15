package com.softgroup.fishingplus.data;

import com.softgroup.fishingplus.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Администратор on 13.04.2017.
 */

public class WeatherHttpClient {

    //http connection
    public String getWeatherData(String coord) {

        HttpURLConnection connection;
        InputStream inputStream;

        try {
            connection = (HttpURLConnection) (new URL(Utils.BASE_URL+coord+Utils.OPEN_WEATHER_MAP_API_KEY))
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();


            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();
            if (inputStream == null) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\n");
            }
            if (stringBuffer.length() == 0) {
                return null;
            }

            inputStream.close();
            connection.disconnect();
            return stringBuffer.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

