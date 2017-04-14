package com.softgroup.fishingplus.models;

import java.util.Date;

/**
 * Created by Администратор on 19.03.2017.
 */

public class FriendlyMessage {

    private String id;
    private String name;
    private String text;
    private String photo;
    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public FriendlyMessage() {
    }

    public FriendlyMessage(String name, String text, String photo) {
        this.name = name;
        this.text = text;
        this.photo = photo;

        time = new Date().getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
