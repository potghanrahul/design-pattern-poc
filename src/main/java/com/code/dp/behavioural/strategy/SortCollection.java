package com.code.dp.behavioural.strategy;

import java.util.Collection;
import java.util.Comparator;

/**
 *
 * @param <T>
 * @author Rahul Potghan
 * @apiNote This class is not fully implemented. It is just to show how Strategy Pattern can be implemented.
 */
public class SortCollection<T> {
    private Comparator<T> strategy;
    private Algorithm<T> algorithm;

    public SortCollection(Comparator<T> strategy) {
        this.strategy = strategy;
        algorithm = new MergeSort<>();
    }

    public SortCollection(Comparator<T> strategy, Algorithm<T> algorithm) {
        this.strategy = strategy;
        this.algorithm = algorithm;
    }

    public void sort(Collection<T> collection) {
        algorithm.sort(collection, strategy);
    }

    public void sort(Collection<T> collection, Comparator<T> strategy) {
        algorithm.sort(collection, strategy);
    }

    public void sort(Collection<T> collection, Algorithm<T> algorithm){
        algorithm.sort(collection, strategy);
    }

    public void sort(Collection<T> collection, Algorithm<T> algorithm, Comparator<T> strategy){
        algorithm.sort(collection, strategy);
    }

    public void setStrategy(Comparator<T> strategy) {
        this.strategy = strategy;
    }

    public void setAlgorithm(Algorithm<T> algorithm) {
        this.algorithm = algorithm;
    }
}
