package io.github.bael.javaclass.war;

/**
 * В данном классе содержится информация о состоянии бойца, здоровье, атака и защита.
 */
public class WarriorState implements ActorState {

    private int attackLvl;
    private int defenceLvl;
    private int hp;
    private int maxHP;
    private int level;
    private int strength;


    private WarriorState(int attackLvl, int defenceLvl, int hp, int level, int strength, int maxHP) {
        this.attackLvl = attackLvl;
        this.defenceLvl = defenceLvl;
        this.hp = hp;
        this.maxHP = maxHP;
        this.level = level;
        this.strength = strength;

    }

    public static WarriorStateBuilder builder() {
        return new WarriorStateBuilder();
    }


    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public double getHPState() {
        if (getMaxHP() == 0) {
            return 0;
        }

        return (double) getHP() / getMaxHP();

    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getAttackLevel() {
        return attackLvl;
    }

    @Override
    public int getDefenceLevel() {
        return defenceLvl;
    }

    @Override
    public boolean isAlive() {
        return getHP() > 0;
    }

    /**
     * Создаем новый объект при изменениях над текущим, для иммутабельности
     */
    @Override
    public ActorState takeDamage(int damage) {
        System.out.println("taking damage " + damage);
        int mutatedHp = hp - Math.min(hp, Math.max(0, damage));
        return new WarriorState(this.attackLvl, this.defenceLvl, mutatedHp, this.level, this.strength, this.maxHP);
    }

    @Override
    public String toString() {
        return "WarriorState{" +
                "attackLvl=" + attackLvl +
                ", defenceLvl=" + defenceLvl +
                ", hp=" + hp +
                ", maxHP=" + maxHP +
                ", level=" + level +
                ", strength=" + strength +
                '}';
    }

    /**
     * Внутренний класс для паттерна builder. static  означает что данный класс не может обращаться к полям внешнего
     * класса WarriorState, и не будет создаваться на каждый экземпляр объекта WarriorState
     */
    public static class WarriorStateBuilder {
        private int attackLvl;
        private int defenceLvl;
        private int hp;
        private int maxHP;
        private int level;
        private int strength;


        public WarriorStateBuilder attackLevel(int attackLvl) {
            this.attackLvl = attackLvl;
            return this;
        }

        public WarriorStateBuilder defenceLevel(int defenceLvl) {
            this.defenceLvl = defenceLvl;
            return this;
        }

        public WarriorStateBuilder level(int level) {
            this.level = level;
            return this;
        }

        public WarriorStateBuilder hp(int hp) {
            this.hp = hp;
            return this;
        }

        public WarriorStateBuilder maxHP(int maxHP) {
            this.maxHP = maxHP;
            return this;
        }

        public WarriorStateBuilder strength(int strength) {
            this.strength = strength;
            return this;
        }

        private void requirePositive(int value) {
            if (value < 0) {
                throw new IllegalArgumentException();
            }
        }


        public WarriorState build() {
            requirePositive(this.attackLvl);
            requirePositive(this.defenceLvl);
            requirePositive(this.hp);
            requirePositive(this.level);
            requirePositive(this.strength);
            requirePositive(this.maxHP);

            requirePositive(this.maxHP - this.hp);

            return new WarriorState(this.attackLvl, this.defenceLvl, this.hp, this.level, this.strength, this.maxHP);
        }


    }
}
