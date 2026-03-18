package com.code.dp.behavioural.memento;

import java.util.Objects;

public class Originator implements Cloneable {
    private String name;
    private String type;
    private Integer size;


    public Originator(String name, String type, Integer size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Document{" +
                "content='" + name + '\'' +
                ", fontName='" + type + '\'' +
                ", fontSize=" + size +
                '}';
    }

    @Override
    public Originator clone() {
        try {
            return (Originator) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Originator that = (Originator) o;
        return Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, size);
    }
}
