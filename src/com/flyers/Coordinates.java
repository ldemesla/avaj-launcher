package com.flyers;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    Coordinates(int lgt, int ltt, int hgt)
    {
        longitude = lgt;
        latitude = ltt;
        height = hgt;
    }
    public int getLongitude()
    {
        return longitude;
    }
    public int getLatitude()
    {
        return latitude;
    }
    public int getHeight()
    {
        return height;
    }
}