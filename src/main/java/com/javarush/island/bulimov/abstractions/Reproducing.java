package com.javarush.island.bulimov.abstractions;

import com.javarush.island.bulimov.islandMap.Cell;
@FunctionalInterface
public interface Reproducing {
    void reproducing(Cell cell) throws InstantiationException, IllegalAccessException;
}
