package com.code.dp.behavioural.memento;

public class Originator implements Cloneable{
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
            Originator clone = (Originator) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
