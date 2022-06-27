package com.javarush.island.bulimov.entity.animals.carnivores;

import com.javarush.island.bulimov.entity.Organism;
import com.javarush.island.bulimov.entity.animals.Animal;
import com.javarush.island.bulimov.islandMap.Cell;
import com.javarush.island.bulimov.islandMap.IslandMapCreator;

import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class Carnivore extends Animal {
    Carnivore(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
    }
}
