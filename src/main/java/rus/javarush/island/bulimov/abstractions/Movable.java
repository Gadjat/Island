package rus.javarush.island.bulimov.abstractions;

import rus.javarush.island.bulimov.islandMap.Cell;

@FunctionalInterface
public interface Movable {
    void moving(Cell cell);
}
