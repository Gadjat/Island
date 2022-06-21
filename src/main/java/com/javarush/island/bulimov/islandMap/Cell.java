package com.javarush.island.bulimov.islandMap;

import com.javarush.island.bulimov.entity.animals.carnivores.Carnivore;
import com.javarush.island.bulimov.entity.animals.herbivores.Herbivore;
import com.javarush.island.bulimov.entity.plants.Plant;

import java.util.HashSet;

public class Cell {
    public int column;
    public int line;

    public HashSet<Carnivore> carnivores = new HashSet<>();
    public HashSet<Herbivore> herbivores = new HashSet<>();
    public HashSet<Plant> plants = new HashSet<>();


    public Cell(int column, int line) {
        this.column = column;
        this.line = line;
    }
}
