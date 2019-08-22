package io.github.bael.javaclass.war;

/**
 * класс для тестирования, шанс всегда = 0
 */
public class BadLuckChance implements Chance {
    @Override
    public int getProbability() {
        return 0;
    }
}
