package com.code.dp.behavioural.memento;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Memento<T extends Cloneable> {

    private T t;
    private final Caretaker<T> caretaker;

    public Memento(T t) {
        this.t = t;
        this.caretaker = new Caretaker<>();
        this.save();
    }

    public void save() {
        this.caretaker.push(t);
        try {
            this.t = (T) this.t.getClass().getMethod("clone").invoke(this.t);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(T t) {
        try {
            this.t = (T) this.t.getClass().getMethod("clone").invoke(this.t);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        this.caretaker.push(t);
    }

    public void undo() {
        this.t = caretaker.pop();
    }

    public T get() {
        return t;
    }

    public static class Caretaker<T> {
        private final List<T> states;

        private Caretaker() {
            states = new ArrayList<>();
        }

        private void push(T t) {
            states.add(t);
        }

        private T pop() {
            if(states.size()>1) {
                states.removeLast();
            }
            return states.getLast();
        }
    }
}
