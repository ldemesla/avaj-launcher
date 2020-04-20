package com.flyers;
import com.simulator.WeatherTower;
import com.simulator.Simulator;


public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    Baloon(String name, Coordinates crdt)
    {
        super(name, crdt);
    };
    public void updateConditions()
    {
        String wt = weatherTower.getWeather(this.coordinates);
        int hgt;
        if (this.coordinates.getHeight() > 96)
            hgt = 100 - this.coordinates.getHeight();
        else 
            hgt = 4;
        if (wt.equals("SUN"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + hgt);
        }
        else if (wt.equals("RAIN"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
        }
        else if (wt.equals("FOG"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
        }
        else if (wt.equals("SNOW"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
        }
        Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): weather is " + wt);
        if (this.coordinates.getHeight() <= 0)
        {
            Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): landing...");
            this.weatherTower.unregister(this);
            Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + "): unregister from weather tower");
        }
    };
    public void registerTower(WeatherTower wt)
    {
        this.weatherTower = wt;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + "): register from weather tower");
    }
}