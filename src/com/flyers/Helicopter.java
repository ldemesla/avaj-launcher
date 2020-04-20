package com.flyers;
import com.simulator.WeatherTower;
import com.simulator.Simulator;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates crdt)
    {
        super(name, crdt);
    };
    public void updateConditions()
    {
        String wt = weatherTower.getWeather(this.coordinates);
        int hgt;
        if (this.coordinates.getHeight() > 98)
            hgt = 100 - this.coordinates.getHeight();
        else 
            hgt = 2;
        if (wt.equals("SUN"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + hgt);
        }
        else if (wt.equals("RAIN"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
        }
        else if (wt.equals("FOG"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
        }
        else if (wt.equals("SNOW"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
        }
        Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + "): weather is " + wt);
        if (this.coordinates.getHeight() <= 0)
        {
            Simulator.writer.println("Helicopter#" + this.name + "(" + this.id + "): landing...");
            this.weatherTower.unregister(this);
            Simulator.writer.println("Tower says: Helicopter#" + this.name + "(" + this.id + "): unregister from weather tower");
        }
    };
    public void registerTower(WeatherTower wt)
    {
        this.weatherTower = wt;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: Helicopter#" + this.name + "(" + this.id + "): register from weather tower");
    }
}