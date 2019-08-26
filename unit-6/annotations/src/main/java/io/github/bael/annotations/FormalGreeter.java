package io.github.bael.annotations;

public class FormalGreeter implements Greeter {
    @Override
    public String greeting(String name) {
        return String.format("Добро пожаловать, %s", name);
    }
}
