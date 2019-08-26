package io.github.bael.javaclass.war;

public abstract class Warrior implements Actor {

    private static final int CRITICAL_DAMAGE_RATE = 3;
    private static final int CRITICAL_DAMAGE_EDGE = 95;
    ActorState state;

    protected Warrior() {
    }

    public Warrior(ActorState state) {
        this.state = state;
    }


    /**
     * Сила атаки = уровень атаки + сила + признак критичности удара.
     */
    @Override
    public void attackEnemy(Chance chance, Warrior warrior) {
        System.out.println("Attacking the enemy! " + warrior);
        int percent = chance.getProbability();
        Damage damage = new Damage(state.getAttackLevel() + state.getStrength(), detectCriticalAttackChance(percent));
        System.out.println("Attack damage is ! " + damage);
        warrior.receiveAttack(damage);
    }

    // считаем что урон критический если вероятность критического удара + уровень воина выше порога
    protected boolean detectCriticalAttackChance(int percent) {
        return percent + state.getLevel() >= CRITICAL_DAMAGE_EDGE;
    }


    /***
     * Принимаемый урон от атаки = уровень атаки * (мультипликатор критичности удара) - сила защиты.
     */
    @Override
    public void receiveAttack(Damage strike) {
        System.out.println("Recieveing the attack: " + strike);

        // урон не может быть отрицательным
        int damage = Math.max(0, strike.getValue() - state.getDefenceLevel());

        if (strike.getIsCritical()) {
            damage *= CRITICAL_DAMAGE_RATE;
        }

        this.state = this.state.takeDamage(damage);

    }

    @Override
    public ActorState getState() {
        return state;
    }


}
