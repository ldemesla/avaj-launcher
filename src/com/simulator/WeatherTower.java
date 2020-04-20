package com.simulator;
import com.weather.WeatherProvider;
import com.flyers.Coordinates;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates crdt)
    {
        return WeatherProvider.getProvider().getCurrentWeather(crdt);
    };
    void changeWeather()
    {
        this.conditionChanged();
    }
}