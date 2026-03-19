package com.code.dp.behavioural.strategy;

import java.util.Collection;
import java.util.Comparator;

public class MergeSort<T> implements Algorithm<T> {
    @Override
    public void sort(Collection<T> collection, Comparator<T> strategy) {
        System.out.println("MergeSort.sort");
    }
}
