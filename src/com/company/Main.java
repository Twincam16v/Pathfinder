package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Map m = new Map();
        Mover mover = new Mover();

        List<Location> open = new ArrayList<>();

        m.readMap();

        System.out.println("The Initial Map is: ");
        m.printMap();

        m.getPosition("S");

        Location start = new Location(m.getX(), m.getY(),  "S");
        start.setCost(0);
        open.add(start);

        m.getPosition("E");

        Location end = new Location(m.getX(), m.getY(), "E");

        Location current = start;

        while (current.getHeuristic() > 0)
        {
            open.add(mover.updateLocation(current, end, m, open));
            current = open.get(mover.getIndex());
            m.printMap();
        }


        open.forEach(location -> {
            if (location.getCost() % 2 == 0)
            {
                m.updateMap(location.getX(), location.getY(), "\"");
            }
        });

        m.updateMap(start.getX(), start.getY(), "S");

        System.out.println("The path taken is: ");
        m.printMap();
    }
}
