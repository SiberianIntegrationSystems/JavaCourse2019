package pro.it.sis.javacourse;

public class Damage {
    private DamageType type;
    private double strength;
    private double baseStrength;

    public double getBaseStrength() {
        return baseStrength;
    }

    public Damage(DamageType type, double strength) {
        this.type = type;
        this.strength = strength;
        this.baseStrength = strength;
    }

    public Damage(DamageType type, double strength, double baseStrength) {
        this.type = type;
        this.strength = strength;
        this.baseStrength = baseStrength;
    }

    public DamageType getType() {
        return type;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public Damage copy() {
        return new Damage(this.type, this.strength, this.baseStrength);
    }
}
