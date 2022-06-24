package com.javarush.island.bulimov.entity;

import com.javarush.island.bulimov.abstractions.Reproducing;
import com.javarush.island.bulimov.exception.IslandRunException;
import com.javarush.island.bulimov.islandMap.Cell;

public abstract class Organism implements Reproducing, Cloneable{
    public String name;
    public double weight;

    public int maxItemCell;

    public double saturation;

    public boolean hold = false;



    public Organism(double weight, int maxItemCell , double saturation) {
        this.weight = weight;
        this.maxItemCell = maxItemCell;
        this.saturation = saturation;
    }

    @Override
    protected Organism clone() throws CloneNotSupportedException{
        Organism clone = (Organism) super.clone();
        return clone;
    }
    public static <T extends Organism> T clone(T original) {
        try {
            return (T) original.clone();
        } catch (CloneNotSupportedException e) {
            throw new IslandRunException("Cloneable error"+ e);
        }

    }

}
