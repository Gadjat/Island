package com.javarush.island.bulimov.islandMap;

import com.javarush.island.bulimov.entity.Organism;
import com.javarush.island.bulimov.entity.animals.herbivores.Herbivore;
import com.javarush.island.bulimov.islandSettings.OrganismSetting;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class IslandMapCreator {
    public int column;
    public int line;
    private static Cell[][] animalMap = new Cell[][]{};

    public IslandMapCreator(int column, int line) {
        this.column = column;
        this.line = line;
        animalMap = new Cell[column][line];
    }

    public void createMap(){
        for (int i = 0; i < animalMap.length; i++) {
            for (int j = 0; j < animalMap[i].length; j++) {
                animalMap[i][j] = new Cell(i,j);
                for (Organism animal : OrganismSetting.getAnimals()){
                    HashSet<Organism> organisms = new HashSet<>();
                    int maxAnimalCell = ThreadLocalRandom.current().nextInt(0, animal.maxItemCell);
                    for (int k = 0; k < maxAnimalCell; k++) {
                        organisms.add(Organism.clone(animal));
                    }
                    if(!organisms.isEmpty()){
                        animalMap[i][j].getAnimalsCell().put(animal.name, organisms);
                    }

                }

            }
        }
    }
    public Cell[][] getAnimalMap() {
        return animalMap;
    }

    public static void main(String[] args) {
        IslandMapCreator islandMapCreator = new IslandMapCreator(100, 20);
        islandMapCreator.createMap();
        for (int i = 0; i < islandMapCreator.getAnimalMap().length; i++) {
            for (int j = 0; j < islandMapCreator.getAnimalMap()[i].length; j++) {
                islandMapCreator.getAnimalMap()[i][j].toStringAnimal();
            }
        }
    }


}
