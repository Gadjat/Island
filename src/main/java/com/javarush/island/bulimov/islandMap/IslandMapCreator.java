package com.javarush.island.bulimov.islandMap;

public class IslandMapCreator {
    public int column;
    public int line;
    private static Cell[][] animalMap = new Cell[][]{};

    public IslandMapCreator(int column, int line) {
        this.column = column;
        this.line = line;
        animalMap = new Cell[column][line];
    }


    public static Cell[][] getAnimalMap() {
        return animalMap;
    }


}
