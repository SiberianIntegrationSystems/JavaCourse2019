package pro.it.sis.javacourse;

public class Weapon {
    private Damage damage;

    public Weapon(Damage damage) {
        this.damage = damage;
    }

    public Damage getDamage() {
        return damage;
    }

    void hit(Target target) {
        // Если в процессе урон оружия изменится, урон нанесенный сейчас сохранится
        target.addDamage(damage.copy());
    }
}
