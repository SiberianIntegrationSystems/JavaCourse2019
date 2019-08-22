package io.github.bael.annotations;

public class InformalGreeter implements Greeter {
    @Override
    public String greeting(String name) {

        return String.format("Я вас категорически приветствую, %s!", name);
    }
}
