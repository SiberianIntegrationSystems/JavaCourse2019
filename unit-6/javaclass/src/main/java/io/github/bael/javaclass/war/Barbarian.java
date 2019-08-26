package io.github.bael.javaclass.war;

/**
 * Варвар. при низком здоровье (20 %) сила умножается на 5.
 */
public class Barbarian extends Warrior {

    private static final double RAGE_HEALTH_EDGE = .2d;

    private Barbarian() {
    }

    public Barbarian(ActorState state) {
        super(state);
    }

    /**
     * При пониженном здоровье урон от силы в пять раз выше
     */
    @Override
    public void attackEnemy(Chance chance, Warrior warrior) {
        int multiplication = 1;
        // здоровье меньше 20%
        if (state.getHPState() <= RAGE_HEALTH_EDGE) {
            System.out.println("Proud barbarian is in rage! Health is " + state.getHPState());
            multiplication = 5;
        }

        int percent = chance.getProbability();
        Damage damage = new Damage(state.getAttackLevel() + multiplication * state.getStrength(), detectCriticalAttackChance(percent));
        System.out.printf("Attack damage is %s.\n", damage);
        warrior.receiveAttack(damage);
    }

    @Override
    public String toString() {
        return "Barbarian{" +
                "state=" + state +
                '}';
    }
}
