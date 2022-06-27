package com.javarush.island.bulimov.entity.animals;

import com.javarush.island.bulimov.abstractions.Eating;
import com.javarush.island.bulimov.abstractions.Movable;
import com.javarush.island.bulimov.entity.Organism;
import com.javarush.island.bulimov.islandMap.Cell;
import com.javarush.island.bulimov.islandMap.IslandMapCreator;
import com.javarush.island.bulimov.islandSettings.OrganismSetting;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism implements Eating, Movable {
    public int maxSpeedInCell;
    public double maxSaturation;
    public boolean check = false;


    public Animal(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, saturation);
        this.maxSpeedInCell = maxSpeedInCell;
        this.maxSaturation = maxSaturation;

    }

    @Override
    public void eating(Cell cell) {
        cell.getLock().lock();
        try{
            int index = 0;
            for (int animalName = 0; animalName < OrganismSetting.getNames().length; animalName++) {
                if(OrganismSetting.getNames()[animalName].equals(this.name)){
                    for (int percent = 0; percent < OrganismSetting.getPercent()[animalName].length; percent++) {
                        if(OrganismSetting.getPercent()[animalName][percent] > 0){
                            for (Organism organism : cell.getAnimalsCell().get(OrganismSetting.getNames()[percent])) {
                                if(ThreadLocalRandom.current().nextInt(100 - OrganismSetting.getPercent()[animalName][percent], 100)
                                        >= 100 - OrganismSetting.getPercent()[animalName][percent]){
                                    if(this.saturation+ organism.weight >= this.maxSaturation){
                                        this.saturation = this.maxSaturation;
                                    }
                                    else{
                                        this.saturation+=organism.weight;
                                    }
                                    organism.weight = 0;

                                }
                            }
                        }
                    }
                }
            }
        }
        finally {
            cell.getLock().unlock();
        }

    }
    @Override
    public void reproducing(Cell cell)  {
        cell.getLock().lock();
        try{
            if(cell.getAnimalsCell().get(this.name).size() > 0 && this.weight > 0) {
                cell.getAnimalsCell().get(this.name).stream()
                        .filter(s-> !s.pregnancy && s.weight > 0)
                        .findAny()
                        .get().pregnancy = true;

            }
        }
        finally {
            cell.getLock().unlock();
        }


    }
    @Override
    public void moving(Cell cell) {
        cell.getLock().lock();
        try{
            cell.getAnimalsCell().get(this.name).removeIf(organism -> organism.equals(this));
            int rout = ThreadLocalRandom.current().nextInt(0, 4);
            switch (rout) {
                case 1 -> {
                    if (cell.column + this.maxItemCell >= 100)
                        cell.column = 100;
                    else {
                        cell.column += this.maxItemCell;
                    }
                }
                case 2 -> {
                    if (cell.column - this.maxItemCell <= 0)
                        cell.column = 0;
                    else {
                        cell.column -= this.maxItemCell;
                    }
                }
                case 3 -> {
                    if (cell.line + this.maxItemCell >= 20)
                        cell.line = 20;
                    else {
                        cell.line += this.maxItemCell;
                    }
                }
                case 4 -> {
                    if (cell.line - this.maxItemCell <= 0)
                        cell.line = 0;
                    else {
                        cell.line -= this.maxItemCell;
                    }
                }
            }
            IslandMapCreator.getAnimalMap()[cell.column][cell.line].getAnimalsCell().get(this.name).add(this);
            if(this.pregnancy){
                IslandMapCreator.getAnimalMap()[cell.column][cell.line].getAnimalsCell().get(this.name).add(Organism.clone(this));
            }
            this.saturation -= 1;
        }
        finally {
            cell.getLock().unlock();
        }


    }

}
