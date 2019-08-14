package pro.it.sis.javacourse;

public class DamageFactory {
    public static Damage createDamage(DamageType type, int strength) {
        switch (type) {
            case physical:
                return new PhysicalDamage(strength);
            case fire:
                return new FireDamage(strength);
            case ice:
                return new IceDamage(strength);
            case poison:
                return new PoisonDamage(strength);
            default:
                throw new RuntimeException("Unknown damage type: " + type);
        }
    }

}
