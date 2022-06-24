package com.javarush.island.bulimov.entity.animals.carnivores;

import com.javarush.island.bulimov.entity.animals.Animal;
import com.javarush.island.bulimov.islandMap.Cell;
import com.javarush.island.bulimov.islandMap.IslandMapCreator;

import java.util.concurrent.ThreadLocalRandom;

public class Carnivore extends Animal {
    Carnivore(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
    }

    @Override
    public void eating(Cell cell) {
        cell.getLock().lock();
        cell.getLock().unlock();
    }

    @Override
    public void moving(Cell cell) {
        cell.getLock().lock();

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

        cell.getLock().unlock();
    }

    @Override
    public void reproducing(Cell cell)  {
        cell.getLock().lock();

        cell.getLock().unlock();
    }
}
