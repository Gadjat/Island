package ru.javarush.island.bulimov.islandMap;

import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.entity.islandSettings.OrganismSetting;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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

    public static Cell[][] getAnimalMap() {
        return animalMap;
    }


}
