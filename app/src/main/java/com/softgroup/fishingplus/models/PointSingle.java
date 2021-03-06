package com.softgroup.fishingplus.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Администратор on 25.04.2017.
 */

public class PointSingle {
    private static PointSingle pointSingle;
    private List<Point> pointList;


    public static PointSingle get(Context context) {

        if (pointSingle == null) {
            pointSingle = new PointSingle(context);

        }
        return pointSingle;
    }

    public void addPoint(Point point) {
        pointList.add(point);
    }

    public void deletePoint(Point point) {
        pointList.remove(point);
    }

    private PointSingle(Context context) {
        pointList = new ArrayList<>();

    }

    public List<Point> getPointList() {

        return pointList;
    }

    public Point getPoint(UUID uuid) {
        for (Point point : pointList) {
            if (point.getUuid().equals(uuid)) {
                return point;
            }

        }
        return null;
    }
}