package io.github.bael.javaclass.war;

public interface Actor {


    void attackEnemy(Chance chance, Warrior warrior);

    void receiveAttack(Damage strike);

    ActorState getState();


}
