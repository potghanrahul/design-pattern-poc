package com.code.dp.behavioural.memento;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 * @author Rahul Potghan
 * @implNote This Memento Pattern is partially completed,
 * because to work this code we need to access the Originator through Memento object.
 * I am still working on it, to make it complete. So through single object we can directly perform save, undo and redo operations.
 */
public class Memento<T extends Cloneable> {

    private final Caretaker<T> caretaker;
    private T originator;

    public Memento(T originator) {
        this.originator = originator;
        this.caretaker = new Caretaker<>();
        this.save();
    }

    public T get() {
        return originator;
    }

    public void save() {
        if (caretaker.getStates().isEmpty() || !originator.equals(caretaker.getStates().getLast())) {
            this.caretaker.push(originator);
            cloneOriginator();
        }
    }

    public void save(T originator) {
        if (!originator.equals(caretaker.getStates().getLast())) {
            cloneOriginator();
            this.caretaker.push(originator);
        }
    }

    public void undo() {
        this.originator = caretaker.pop();
        cloneOriginator();
    }

    public void redo() {
        this.originator = caretaker.redo();
        cloneOriginator();
    }

    private void cloneOriginator() {
        try {
            this.originator = (T) this.originator.getClass().getMethod("clone").invoke(this.originator);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Caretaker<T> {
        private final List<T> states;
        private final List<T> undoStates;

        private Caretaker() {
            states = new ArrayList<>();
            undoStates = new ArrayList<>();
        }

        public List<T> getStates() {
            return states;
        }

        private void push(T originator) {
            states.add(originator);
            if(!this.undoStates.isEmpty()) {
                this.undoStates.clear();
            }
        }

        private T pop() {
            if (states.size() > 1) {
                undoStates.add(states.removeLast());
            }
            return states.getLast();
        }

        private T redo() {
            if(!undoStates.isEmpty())
                states.add(undoStates.removeLast());
            return states.getLast();
        }
    }
}
