package com.javarush.island.bulimov.entity.animals.herbivores;

public class Rabbit extends Herbivore{
    public Rabbit(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Rabbit";
    }
}
