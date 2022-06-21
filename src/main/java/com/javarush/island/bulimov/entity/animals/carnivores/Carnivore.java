package com.javarush.island.bulimov.entity.animals.carnivores;

import com.javarush.island.bulimov.entity.animals.Animal;
import com.javarush.island.bulimov.islandMap.Cell;

public class Carnivore extends Animal {
    public Carnivore(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
    }

    @Override
    public void eating(Cell cell) {

    }

    @Override
    public void moving(Cell cell) {

    }

    @Override
    public void reproducing(Cell cell) {

    }
}
