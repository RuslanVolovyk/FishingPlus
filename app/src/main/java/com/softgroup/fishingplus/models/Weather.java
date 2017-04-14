package com.softgroup.fishingplus.models;

/**
 * Created by Администратор on 13.04.2017.
 */


public class Weather {
    public Place place;
    public String iconData;
    public CurrentCondition currentCondition = new CurrentCondition();
    public Temperature temperature = new Temperature();
    public Wind wind= new Wind();
    public Snow snow = new Snow();
    public Clouds clouds = new Clouds();
}
