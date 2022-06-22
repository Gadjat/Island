package com.javarush.island.bulimov.entity.animals.carnivores;

import com.javarush.island.bulimov.entity.animals.Animal;
import com.javarush.island.bulimov.entity.animals.herbivores.Herbivore;
import com.javarush.island.bulimov.islandMap.Cell;
import com.javarush.island.bulimov.resources.AnimalsEatPercent;
import com.javarush.island.bulimov.resources.Percent;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Carnivore extends Animal {
    Carnivore(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
    }

    @Override
    public void eating(Cell cell) {
        for (Herbivore herbivore : cell.herbivores) {
            if(!herbivore.hold && this.saturation != this.maxSaturation){
                herbivore.hold = true;
                HashSet<Percent> percents = AnimalsEatPercent.getInstance().getEatPercent().get(this.name);
                for (Percent percent : percents) {
                    if(herbivore.name.equals(percent.getName())){
                        if(herbivore.weight + this.saturation >= this.maxSaturation){
                            this.saturation = this.maxSaturation;
                        }
                        else{
                            this.saturation+= herbivore.weight;
                        }
                        herbivore.weight = 0;
                    }
                }

            }
        }
    }

    @Override
    public void moving(Cell cell) {

        int rout = ThreadLocalRandom.current().nextInt(0,4);
        switch (rout){
            case 1 -> {
                if (cell.column+this.maxItemCell >= 100)
                    cell.column = 100;
                else{
                    cell.column+=this.maxItemCell;
                }
            }
            case 2 -> {
                if (cell.column-this.maxItemCell <= 0)
                    cell.column = 0;
                else{
                    cell.column-=this.maxItemCell;
                }
            }
            case 3 -> {
                if (cell.line+this.maxItemCell >= 20)
                    cell.line = 20;
                else{
                    cell.line+=this.maxItemCell;
                }
            }
            case 4 -> {
                if (cell.line-this.maxItemCell <= 0)
                    cell.line = 0;
                else{
                    cell.line-=this.maxItemCell;
                }
            }
        }
        //дописать перемещение по карте и саму карту
    }

    @Override
    public void reproducing(Cell cell) throws InstantiationException, IllegalAccessException {
        cell.herbivores.add(new Herbivore()); // дописать сюда получение класса через парсер
    }
}
