package com.javarush.island.bulimov.entity.animals;

import com.javarush.island.bulimov.abstractions.Eating;
import com.javarush.island.bulimov.abstractions.Movable;
import com.javarush.island.bulimov.entity.Organism;

public abstract class Animal extends Organism implements Eating, Movable {
    public int maxSpeedInCell;
    public double maxSaturation;

    public boolean pregnancy = false;
    public int pregnancyProgressInCell = 1;
    public boolean check = false;


    public Animal(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, saturation);
        this.maxSpeedInCell = maxSpeedInCell;
        this.maxSaturation = maxSaturation;

    }





}
