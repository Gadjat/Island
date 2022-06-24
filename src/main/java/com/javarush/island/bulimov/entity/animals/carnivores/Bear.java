package com.javarush.island.bulimov.entity.animals.carnivores;

public class Bear extends Carnivore{
    public Bear(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Bear";
    }
}
