package com.javarush.island.bulimov.entity.animals.herbivores;

import com.javarush.island.bulimov.entity.animals.Animal;
import com.javarush.island.bulimov.islandMap.Cell;
import com.javarush.island.bulimov.islandMap.IslandMapCreator;

import java.util.concurrent.ThreadLocalRandom;

public class Herbivore extends Animal {
    public Herbivore(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
    }

}
