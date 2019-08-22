package io.github.bael.javaclass.war;

public interface ActorState {
    int getLevel();

    int getHP();

    int getMaxHP();

    double getHPState();

    int getStrength();

    int getAttackLevel();

    int getDefenceLevel();

    boolean isAlive();

    ActorState takeDamage(int damage);

}
