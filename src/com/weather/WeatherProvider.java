package com.weather;
import com.flyers.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {
        "RAIN",
        "FOG",
        "SNOW",
        "SUN"
    };
    private WeatherProvider()
    {

    };
    public static WeatherProvider getProvider()
    {
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates crdt)
    {
        int i = (crdt.getLongitude() + crdt.getLatitude() + crdt.getHeight()) % 4;
        return weather[i];
    }
}