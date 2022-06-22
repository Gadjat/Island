package com.javarush.island.bulimov.entity.plants;

import com.javarush.island.bulimov.abstractions.Organism;
import com.javarush.island.bulimov.islandMap.Cell;

public class Plant extends Organism {

    public Plant(double weight, int maxItemCell) {
        super(weight, maxItemCell);
    }

    @Override
    public void reproducing(Cell cell) {
        if (cell.plants.size() < this.maxItemCell){
            cell.plants.add(new Plant(1.0, 200));
        }
    }
}
