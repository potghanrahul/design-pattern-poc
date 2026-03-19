package com.code.dp.behavioural.strategy;

import java.util.Collection;
import java.util.Comparator;

public interface Algorithm<T> {
    public void sort(Collection<T> collection, Comparator<T> strategy);
}
