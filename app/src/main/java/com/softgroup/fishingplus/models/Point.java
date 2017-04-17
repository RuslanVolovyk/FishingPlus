package com.softgroup.fishingplus.models;

import java.util.Date;

/**
 * Created by Администратор on 16.04.2017.
 */

public class Point {
    private String name;
    private Date date;
    private String description;

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
