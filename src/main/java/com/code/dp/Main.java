package com.code.dp;

import com.code.dp.behavioural.memento.Memento;
import com.code.dp.behavioural.memento.Originator;

public class Main {

    public static void main(String[] args) {
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