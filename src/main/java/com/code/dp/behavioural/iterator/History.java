package com.code.dp.behavioural.iterator;

import java.util.ArrayList;
import java.util.List;

public class History<T> {
    private final List<T> stack = new ArrayList<>();

    public void push(T t) {
        stack.add(t);
    }

    public T pop() {
        if (!stack.isEmpty())
            return stack.removeLast();
        return null;
    }

    public Iterator<T> createIterator() {
        return new ListIterator(this);
    }

    public class ListIterator implements Iterator<T> {

        private final History<T> history;
        private int index;

        public ListIterator(History<T> history) {
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return index < history.stack.size();
        }

        @Override
        public T next() {
            return history.stack.get(index++);
        }
    }
}
