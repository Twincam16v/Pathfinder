package com.company;

import java.util.ArrayList;
import java.util.List;

public class Mover {

    private int index;

    public Mover() {
        index = 0;
    }

    public Location updateLocation(Location currentLocation, Location end, Map map, List<Location> locations)
    {

        Location previous;

        if (index > 0)
        {
            previous = locations.get(index-1);
        }
        else
        {
            previous = locations.get(index);
        }

        Location nextLocation = currentLocation;
        map.updateMap(currentLocation.getX(), currentLocation.getY(), "*");

        List<Location> locationList = new ArrayList<>();

        //Bottom coordinate
        int x = currentLocation.getX();
        int y = currentLocation.getY()+1;
        String value = "";

        if (y < map.getHeight())
        {
            value = map.getValueFromMap(x, y);
            if (value.equals(".") || value.equals("E"))
            {
                locationList.add(new Location(x,y,value));
            }
        }

        //Top Coordinate
        y = currentLocation.getY()-1;


        if (y > 0)
        {
            value = map.getValueFromMap(x,y);
            if (value.equals(".") || value.equals("E"))
            {
                locationList.add(new Location(x,y,value));
            }
        }

        //Right Coordinate
        x = currentLocation.getX()+1;
        y = currentLocation.getY();

        if (x < map.getWidth())
        {
            value = map.getValueFromMap(x,y);
            if (value.equals(".") || value.equals("E"))
            {
                locationList.add(new Location(x,y,value));
            }
        }

        //Left Coordinate
        x = currentLocation.getX()-1;

        if (x > 0)
        {
            value = map.getValueFromMap(x,y);
            if (value.equals(".") || value.equals("E"))
            {
                locationList.add(new Location(x,y,value));
            }
        }

        //Calculate Heuristic for each node
        if (locationList.size() == 0)
        {
            map.updateMap(nextLocation.getX(), nextLocation.getY(), "\"");
            nextLocation = previous;
            index--;
        }
        else if (locationList.size() == 1)
        {
            nextLocation = locationList.get(0);
            index = locations.size();
        }
        else
        {
            for (int i =0; i < locationList.size(); i++)
            {
                locationList.get(i).calculateHeuristic(end.getX(), end.getY());
            }

            nextLocation = locationList.get(0);

            for (int j = 1; j < locationList.size(); j ++)
            {
                if (nextLocation.getHeuristic() > locationList.get(j).getHeuristic())
                {
                    nextLocation = locationList.get(j);
                }
            }
            index = locations.size();
        }


        nextLocation.updateCost();
        return nextLocation;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
