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
    private double latitude; // latitude
    private double longitude; // longitude
    private long sunrise;
    private long sunset;
    private String country;
    private String city;
    private int precipitation;

    private int lastUpdate;
    private int weatherId;
    private String condition;
    private String description;
    private String icon;
    private float pressure;
    private float huminity;

    protected Weather(Parcel in) {
        speed = in.readFloat();
        iconData = in.readString();
        temp = in.readDouble();
        latitude = in.readDouble();
        longitude = in.readDouble();
        sunrise = in.readLong();
        sunset = in.readLong();
        country = in.readString();
        city = in.readString();
        precipitation = in.readInt();
        lastUpdate = in.readInt();
        weatherId = in.readInt();
        condition = in.readString();
        description = in.readString();
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public int getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

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
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeLong(sunrise);
        parcel.writeLong(sunset);
        parcel.writeString(country);
        parcel.writeString(city);
        parcel.writeInt(precipitation);
        parcel.writeInt(lastUpdate);
        parcel.writeInt(weatherId);
        parcel.writeString(condition);
        parcel.writeString(description);
        parcel.writeString(icon);
        parcel.writeFloat(pressure);
        parcel.writeFloat(huminity);
    }
}
