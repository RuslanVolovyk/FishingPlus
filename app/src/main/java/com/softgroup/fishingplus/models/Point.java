package com.softgroup.fishingplus.models;

import com.softgroup.fishingplus.data.GPSCurrentPosition;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Администратор on 16.04.2017.
 */

public class Point  {

    private GPSCurrentPosition gpsCurrentPosition;
    Weather weather;
    private UUID uuid;
    private String name;
    private Date date;
    private String description;
    private double lat;
    private double lon;
    private String temperature;
    private String pressure;
    private String humidity;
    private String wind;
    private String condition;



    public Point() {
       uuid =UUID.randomUUID();
        date = new Date();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public double getLat() {

        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {

        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
