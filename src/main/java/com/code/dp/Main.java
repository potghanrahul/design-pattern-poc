package com.code.dp;

import com.code.dp.behavioural.iterator.History;
import com.code.dp.behavioural.iterator.Iterator;
import com.code.dp.behavioural.memento.Memento;
import com.code.dp.behavioural.memento.Originator;
import com.code.dp.behavioural.state.*;
import com.code.dp.behavioural.strategy.BubbleSort;
import com.code.dp.behavioural.strategy.SortCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        mementoPatternCall();
//        statePatternCall();
//        iteratorPatternCall();
//        strategyPattern();

    }

    private static void strategyPattern() {
        List<String> list = new ArrayList<>();
        Comparator<String> comparator = String::compareTo;
        SortCollection<String> collection = new SortCollection<>(comparator);
        collection.sort(list);
        collection.setAlgorithm(new BubbleSort<>());
        collection.sort(list);
    }

    private static void iteratorPatternCall() {
        History<String> history = new History<>();
        history.push("A");
        history.push("B");
        history.push("C");
        Iterator<String> iterator = history.createIterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println("item = " + item);
        }
    }

    private static void statePatternCall() {
        List<Perform> performs = Arrays.asList(
                new Perform<>(new Addition<>()),
                new Perform<>(new Subtraction<>()),
                new Perform<>(new Multiplication<>()),
                new Perform<>(new Division<>())
        );
        for (Perform p : performs) {
            System.out.println("p = " + p.doPerform(10, 20));
        }
    }

    private static void mementoPatternCall() {
        Originator originator = new Originator("originator-1", "Type-1", 5);
        Memento<Originator> memento = new Memento<>(originator);
        System.out.println("originator = " + memento.get());

        memento.get().setName("originator-2");
        memento.get().setType("Type-2");
        memento.get().setSize(10);
        memento.save();
        System.out.println("originator = " + memento.get());

        memento.get().setName("originator-3");
        memento.save();
        System.out.println("originator = " + memento.get());

        memento.undo();
        System.out.println("originator = " + memento.get());

        memento.undo();
        System.out.println("originator = " + memento.get());

        memento.redo();
        System.out.println("originator = " + memento.get());

        memento.redo();
        System.out.println("originator = " + memento.get());

        memento.redo();
        System.out.println("originator = " + memento.get());
    }
}