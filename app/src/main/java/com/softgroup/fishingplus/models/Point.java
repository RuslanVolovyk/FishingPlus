package com.softgroup.fishingplus.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Администратор on 16.04.2017.
 */

public class Point {

    private UUID uuid;
    private String name;
    private String description;
//    private String condition;
    private Date date;
    private double lat;
    private double lon;
    private double temperature;
    private float pressure;
    private float humidity;
    private float wind;

    public Point(UUID uuid, String name, String description, Date date, double lat, double lon, double temperature, float pressure, float humidity, float wind) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind = wind;
    }

    public Point() {
        uuid = UUID.randomUUID();
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
        date = new Date();
        dateFormat.format(date);
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

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getWind() {
        return wind;
    }

    public void setWind(float wind) {
        this.wind = wind;
    }

//    public String getCondition() {
//        return condition;
//    }
//
//    public void setCondition(String condition) {
//        this.condition = condition;
//    }

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
