package com.softgroup.fishingplus.models;

/**
 * Created by Администратор on 13.04.2017.
 */

public class CurrentCondition {
    private int weatherId;
    private String condition;
    private String description;
    private String icon;
    private float pressure;
    private float huminity;
    //    private float minTemp;
//    private float maxTemp;
    private double temp;

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHuminity() {
        return huminity;
    }

    public void setHuminity(float huminity) {
        this.huminity = huminity;
    }

//    public float getMinTemp() {
//        return minTemp;
//    }
//
//    public void setMinTemp(float minTemp) {
//        this.minTemp = minTemp;
//    }
//
//    public float getMaxTemp() {
//        return maxTemp;
//    }
//
//    public void setMaxTemp(float maxTemp) {
//        this.maxTemp = maxTemp;
//    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}

