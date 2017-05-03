//package com.softgroup.fishingplus.models;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import java.util.List;
//
///**
// * Created by Администратор on 02.05.2017.
// */
//
//public class Photo implements Parcelable {
//    List<Photo> photoList;
//    String image;
//
//    protected Photo(Parcel in) {
//        photoList = in.createTypedArrayList(Photo.CREATOR);
//        image = in.readString();
//    }
//
//    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
//        @Override
//        public Photo createFromParcel(Parcel in) {
//            return new Photo(in);
//        }
//
//        @Override
//        public Photo[] newArray(int size) {
//            return new Photo[size];
//        }
//    };
//
//    public void addPhotoToList(Photo photo){
//        photoList.add(photo);
//    }
//
//    public Photo(String image) {
//        this.image = image;
//    }
//
//    public Photo() {
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeTypedList(photoList);
//        parcel.writeString(image);
//    }
//}
