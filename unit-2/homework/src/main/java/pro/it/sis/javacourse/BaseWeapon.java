package pro.it.sis.javacourse;

public abstract class BaseWeapon {

    private Damage damage;

    public BaseWeapon(Damage damage) {
        this.damage = damage;
    }

    public abstract String getLabel();

    protected void hit(Target target) {
        System.out.println(String.format("%s weapon hit with %s!", getLabel(), damage.getAllValues()));
        target.setDamage(damage);
    }

}
