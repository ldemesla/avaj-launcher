package com.simulator;
import java.util.ArrayList;
import com.flyers.Flyable;

public class Tower {
   private ArrayList<Flyable> observers = new ArrayList<Flyable>();

   public void register(Flyable flyable)
   {
        if (!observers.contains(flyable))
        {
            observers.add(flyable);
        }
   }
   public void unregister(Flyable flyable)
   {
        observers.remove(flyable);
   }

    protected void conditionChanged()
    {
        for (int i = 0; i < observers.size(); i++)
        {
            observers.get(i).updateConditions();
        }
    }
}