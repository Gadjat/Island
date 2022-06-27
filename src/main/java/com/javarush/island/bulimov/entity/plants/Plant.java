package com.javarush.island.bulimov.entity.plants;

import com.javarush.island.bulimov.entity.Organism;
import com.javarush.island.bulimov.islandMap.Cell;

import java.util.Collections;

public class Plant extends Organism {


    public Plant(double weight, int maxItemCell, double saturation) {
        super(weight, maxItemCell, saturation);
        this.name = "Plant";
    }
    @Override
    public void reproducing(Cell cell) {
        cell.getLock().lock();
        if(cell.getAnimalsCell().get(this.name).size() <= this.maxItemCell){
            cell.getAnimalsCell().get(this.name).add(Organism.clone(this));
        }
        cell.getLock().unlock();

    }
}
