package com.javarush.island.bulimov.islandSettings;

public class Limits {
    String name;
    public double weight;
    public int maxItemCell;
    public int maxSpeedInCell;
    public double maxSaturation;
    public double saturation;

    public Limits(String name, double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        this.name = name;
        this.weight = weight;
        this.maxItemCell = maxItemCell;
        this.maxSpeedInCell = maxSpeedInCell;
        this.maxSaturation = maxSaturation;
        this.saturation = saturation;
    }
}
