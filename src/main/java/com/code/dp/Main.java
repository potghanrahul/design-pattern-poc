package com.code.dp;

import com.code.dp.behavioural.iterator.History;
import com.code.dp.behavioural.iterator.Iterator;
import com.code.dp.behavioural.memento.Memento;
import com.code.dp.behavioural.memento.Originator;
import com.code.dp.behavioural.state.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        mementoPatternCall();
//        statePatternCall();
//        iteratorPatternCall();
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
                new Perform<>(new Addition<>(), 10, 20),
                new Perform<>(new Subtraction<>(), 10F, 20F),
                new Perform<>(new Multiplication<>(), 10.1, 20.1),
                new Perform<>(new Division<>(), 10L, 20L)
        );
        for (Perform p : performs) {
            System.out.println("p = " + p.doPerform());
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