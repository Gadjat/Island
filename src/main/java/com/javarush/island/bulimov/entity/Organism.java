package com.javarush.island.bulimov.entity;

import com.javarush.island.bulimov.abstractions.Reproducing;
import com.javarush.island.bulimov.exception.IslandRunException;
import com.javarush.island.bulimov.islandMap.Cell;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Organism implements Reproducing, Cloneable{
    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());
    private long id = idCounter.incrementAndGet();
    public String name;
    public double weight;

    public int maxItemCell;

    public double saturation;

    public boolean hold = false;
    public boolean pregnancy = false;




    public Organism(double weight, int maxItemCell , double saturation) {
        this.weight = weight;
        this.maxItemCell = maxItemCell;
        this.saturation = saturation;
    }

    @Override
    protected Organism clone() throws CloneNotSupportedException{
        Organism clone = (Organism) super.clone();
        clone.id = idCounter.incrementAndGet();
        clone.weight = ThreadLocalRandom.current().nextDouble(clone.weight/2, clone.weight);
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
