package com.softgroup.fishingplus.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Администратор on 13.04.2017.
 */


public class Weather implements Parcelable {

    private float speed;
    public String iconData;
    private double temp;
    private long sunrise;
    private long sunset;
    private String country;
    private String city;
    private int weatherId;
    private String icon;
    private float pressure;
    private float huminity;

    protected Weather(Parcel in) {
        speed = in.readFloat();
        iconData = in.readString();
        temp = in.readDouble();
        sunrise = in.readLong();
        sunset = in.readLong();
        country = in.readString();
        city = in.readString();
        weatherId = in.readInt();
        icon = in.readString();
        pressure = in.readFloat();
        huminity = in.readFloat();
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getIconData() {
        return iconData;
    }

    public void setIconData(String iconData) {
        this.iconData = iconData;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }


    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
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

    public Weather() {


    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(speed);
        parcel.writeString(iconData);
        parcel.writeDouble(temp);
        parcel.writeLong(sunrise);
        parcel.writeLong(sunset);
        parcel.writeString(country);
        parcel.writeString(city);
        parcel.writeInt(weatherId);
        parcel.writeString(icon);
        parcel.writeFloat(pressure);
        parcel.writeFloat(huminity);
    }
}
