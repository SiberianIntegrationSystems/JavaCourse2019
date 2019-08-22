package io.github.bael.xml;


public class Cat extends Pet {
    public Cat(Toy toy) {
        this.toy = toy;
    }

    @Override
    public String speak() {
        return "mewow";
    }

    private Toy toy;

    @Override
    public Toy toy() {
        return toy;
    }



}
