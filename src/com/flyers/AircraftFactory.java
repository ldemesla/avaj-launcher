package com.flyers;

public class AircraftFactory {
    
    public Flyable newAircraft(String type, String name, int lgt, int ltt, int hgt)
    {
        Coordinates coordinates = new Coordinates(lgt, ltt, hgt);
        if (hgt > 100)
            hgt = 100;
        if (type.equals("Baloon"))
            return new Baloon(name, coordinates);
        else if (type.equals("JetPlane"))
            return new JetPlane(name, coordinates);
        else
            return new Helicopter(name, coordinates);
    }
}