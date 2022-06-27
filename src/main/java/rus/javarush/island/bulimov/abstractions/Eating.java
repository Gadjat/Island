package rus.javarush.island.bulimov.abstractions;

import rus.javarush.island.bulimov.islandMap.Cell;

@FunctionalInterface
public interface Eating {
    void eating(Cell cell);
}
