package com.code.dp.behavioural.strategy;

import java.util.Collection;
import java.util.Comparator;

public class QuickSort<T> implements Algorithm<T> {
    @Override
    public void sort(Collection<T> collection, Comparator<T> strategy) {
        System.out.println("QuickSort.sort");
    }
}
