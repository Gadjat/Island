package com.javarush.island.bulimov.entity.plants;

import com.javarush.island.bulimov.entity.Organism;
import com.javarush.island.bulimov.islandMap.Cell;

public class Plant extends Organism {

    public Plant(double weight, int maxItemCell) {
        super(weight, maxItemCell);
        this.name = "Plant";
    }

    @Override
    public void reproducing(Cell cell) {

    }
}
