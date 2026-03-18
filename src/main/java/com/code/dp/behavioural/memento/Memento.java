package com.code.dp.behavioural.memento;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 * @author Rahul Potghan
 * @implNote This Memento Pattern is partially completed,
 * because to work this code we need to access the Originator through Memento object.
 * I am still working on it, to make it complete. So through single object we can access originator and perform save and undo operation.
 * For now, I have only implemented save and undo, still working on redo.
 */
public class Memento<T extends Cloneable> {

    private final Caretaker<T> caretaker;
    private T t;

    public Memento(T t) {
        this.t = t;
        this.caretaker = new Caretaker<>();
        this.save();
    }

    public void save() {
        if (!t.equals(caretaker.getStates().getLast())) {
            this.caretaker.push(t);
            try {
                this.t = (T) this.t.getClass().getMethod("clone").invoke(this.t);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void save(T t) {
        if (!t.equals(caretaker.getStates().getLast())) {
            try {
                this.t = (T) this.t.getClass().getMethod("clone").invoke(this.t);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            this.caretaker.push(t);
        }
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

        public List<T> getStates() {
            return states;
        }

        private void push(T t) {
            states.add(t);
        }

        private T pop() {
            if (states.size() > 1) {
                states.removeLast();
            }
            return states.getLast();
        }
    }
}
