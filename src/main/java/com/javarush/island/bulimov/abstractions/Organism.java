package com.javarush.island.bulimov.abstractions;

public abstract class Organism implements Reproducing{
    public double weight;
    public int maxItemCell;

    public Organism(double weight, int maxItemCell) {
        this.weight = weight;
        this.maxItemCell = maxItemCell;
    }
}
