package io.github.bael.xml;

public class Dog extends Pet {
    @Override
    public String speak() {
        return "woof!";
    }

    @Override
    public Toy toy() {
        return null;
    }
}
