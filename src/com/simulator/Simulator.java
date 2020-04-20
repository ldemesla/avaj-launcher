package com.simulator;
import java.io.*;
import java.util.*;
import com.flyers.AircraftFactory;

public class Simulator {
    public static PrintWriter writer;
    public static void main(String[] args) throws Exception {
        if (args.length != 1)
        {
            System.out.print("error: you need to provide a scenario file\n");
            return ;
        }
        File file = new File("simulation.txt");
        if (file.isDirectory())
        {
            System.out.print("error: simulation.txt is a directory\n");
            return ;
        }
        writer = new PrintWriter(file);
        BufferedReader br = new BufferedReader( new FileReader(args[0]));
        String line = br.readLine();
        if (isNumber(line) == false)
        {
            System.out.print("error: the number of epochs must be a unique number\n");
            return ;
        }
        int epochs = Integer.parseInt(line);
        String[] splitted_line;
        List<String> list = Arrays.asList(new String[]{"Helicopter", "Baloon", "JetPlane"});
        AircraftFactory factory = new AircraftFactory();
        WeatherTower weatherTower = new WeatherTower();
        while ((line = br.readLine()) != null)
        {
            splitted_line = line.split("\\s+");
            if (splitted_line.length != 5)
            {
                System.out.print("error: incorrect number of attributes in scenario file\n");
                return ;
            }
            else if (list.contains(splitted_line[0]) == false)
            {
                System.out.print("error: incorrect aircraft type\n");
                return ;
            }
            else if (!isNumber(splitted_line[2]) || !isNumber(splitted_line[3]) || !isNumber(splitted_line[4]))
            {
                System.out.print("error: longitude, latitude and height must me numbers\n");
                return ;
            }
            factory.newAircraft(splitted_line[0], splitted_line[1], Integer.parseInt(splitted_line[2]), Integer.parseInt(splitted_line[3]), Integer.parseInt(splitted_line[4])).registerTower(weatherTower);
        }
        for (int i = 0; i < epochs; i++)
        {
            weatherTower.changeWeather();
        }
        writer.close();
    };
    private static boolean isNumber(String nbr)
    {
        for (int i = 0; i < nbr.length(); i++)
        {
            if (Character.isDigit(nbr.charAt(i)) == false)
            return false;
        }
        return true;
    };
}