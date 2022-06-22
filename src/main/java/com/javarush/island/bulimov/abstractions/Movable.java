package com.javarush.island.bulimov.abstractions;

import com.javarush.island.bulimov.islandMap.Cell;
@FunctionalInterface
public interface Movable {
    void moving(Cell cell);
}
