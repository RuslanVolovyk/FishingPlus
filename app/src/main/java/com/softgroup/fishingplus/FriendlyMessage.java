package com.softgroup.fishingplus;

/**
 * Created by Администратор on 19.03.2017.
 */

public class FriendlyMessage {
    private String name;
    private String id;
    private String text;
    private String photo;

    public FriendlyMessage(String name, String text, String photo) {
        this.name = name;
        this.text = text;
        this.photo = photo;
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
