package ru.javarush.island.bulimov.services;

import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.entity.islandSettings.OrganismSetting;
import ru.javarush.island.bulimov.exception.IslandRunException;
import ru.javarush.island.bulimov.islandMap.Cell;
import ru.javarush.island.bulimov.islandMap.IslandMapCreator;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrganismWorker implements  Runnable{

    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();
    @Override
    public void run() {
        Cell[][] cells = IslandMapCreator.getAnimalMap();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                try {
                    processOnCell(cell);
                } catch (RuntimeException e) {
                    throw new IslandRunException("Error island run method " + e);
                }
            }
        }

    }

    private void processOnCell(Cell cell){
        cell.getLock().lock();
        for (String name : OrganismSetting.getNames()) {
            if (cell.getAnimalsCell().get(name).size() > 0){
                try{
                    for (Organism organism : cell.getAnimalsCell().get(name)) {
                        tasks.add(new Task(organism, cell));
                    }
                }
                finally {
                    cell.getLock().unlock();
                }

                tasks.forEach(Task::doTask);
                tasks.clear();
            }

        }
    }
}
