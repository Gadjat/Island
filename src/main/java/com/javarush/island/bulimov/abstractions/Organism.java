package com.javarush.island.bulimov.abstractions;

import com.javarush.island.bulimov.islandMap.Cell;

public abstract class Organism implements Reproducing{
    public String name;
    public double weight;

    public int maxItemCell;

    public boolean hold = false;



    public Organism(double weight, int maxItemCell) {
        this.weight = weight;
        this.maxItemCell = maxItemCell;
    }

}
