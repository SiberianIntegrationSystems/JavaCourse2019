package io.github.bael.javaclass;

import io.github.bael.javaclass.war.ActorState;
import io.github.bael.javaclass.war.Knight;
import io.github.bael.javaclass.war.Warrior;
import io.github.bael.javaclass.war.WarriorState;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class KnightTrainingCenter implements TrainingCenter {
    @Override
    public Warrior gloriousWarrior() {
        ActorState state = WarriorState.builder().hp(1000)
                .maxHP(1000).strength(100)
                .attackLevel(100).level(1).defenceLevel(100).build();
        return new Knight(state);
    }



}
