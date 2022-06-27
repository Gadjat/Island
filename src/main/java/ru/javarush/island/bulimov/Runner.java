package ru.javarush.island.bulimov;

import ru.javarush.island.bulimov.islandMap.IslandMapCreator;

import static ru.javarush.island.bulimov.islandMap.IslandMapCreator.getAnimalMap;

public class Runner {
    public static void main(String[] args) {
        IslandMapCreator islandMap = new IslandMapCreator(100, 20);
        islandMap.createMap();
        for (int i = 0; i < getAnimalMap().length; i++) {
            for (int j = 0; j < getAnimalMap()[i].length; j++) {
                getAnimalMap()[i][j].toStringAnimal();
            }
        }
    }
}
