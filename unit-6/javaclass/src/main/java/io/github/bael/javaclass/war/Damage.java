package io.github.bael.javaclass.war;

public class Damage {
    private final int value;
    private final boolean isCritical;

    Damage(int value, boolean isCritical) {
        this.value = value;
        this.isCritical = isCritical;
    }

    int getValue() {
        return value;
    }

    boolean getIsCritical() {
        return isCritical;
    }

    @Override
    public String toString() {
        return "Damage{" +
                "value=" + value +
                ", isCritical=" + isCritical +
                '}';
    }
}
