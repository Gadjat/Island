package rus.javarush.island.bulimov.abstractions;

import rus.javarush.island.bulimov.islandMap.Cell;
@FunctionalInterface
public interface Reproducing {
    void reproducing(Cell cell) throws InstantiationException, IllegalAccessException;
}
