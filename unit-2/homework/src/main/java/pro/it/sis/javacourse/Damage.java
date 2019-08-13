package pro.it.sis.javacourse;

public class Damage {
    private DamageType type;
    private int strength;

    public Damage(DamageType type, int strength) {
        this.type = type;
        this.strength = strength;
    }

    public DamageType getType() {
        return type;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Damage copy() {
        return new Damage(this.type, this.strength);
    }
}
