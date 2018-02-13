package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Map {


    private String[][] map;
    private int x;
    private int y;
    private int height;
    private int width;

    public void readMap() throws IOException {

        try (Stream<String> lines = Files.lines(Paths.get("/home/reeves/VirtualBox VMs/WinVirtualShare/Travelling Salesman/map.txt"))) {
            map = lines.map(s -> s.split("\\s+"))
                    .toArray(String[][]::new);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        height = map.length;
        width = Arrays.asList(map[0]).size();


    }

    public String[][] getMap() {
        return map;
    }

    public void setMap(String[][] map) {
        this.map = map;
    }

    public void getPosition(String search)
    {
        for(int i = 0; i < map.length;i++)
        {
            x = Arrays.asList(map[i]).indexOf(search);

            if(x > -1)
            {
                y = i;
                break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getValueFromMap(int xloc, int yloc)
    {
        return map[yloc][xloc];
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void updateMap(int xloc, int yloc, String val)
    {
        map[yloc][xloc] = val;
    }

    public void printMap()
    {
        Arrays.stream(map)
                .map(a -> String.join(" ", a))
                .forEach(System.out::println);
    }
}
