package pro.it.sis.javacourse;

public class WeaponFactory {
    public static Weapon createWeapon(WeaponType weaponType, DamageType damageType, int damageStrength) {
        Damage damage = DamageFactory.createDamage(damageType, damageStrength);
        return createWeapon(weaponType, damage);
    }

    public static Weapon createWeapon(WeaponType weaponType, Damage damage) {
        switch (weaponType) {
            case ranged:
                return new RangedWeapon(damage);
            case melee:
                return new MeleeWeapon(damage);
            default:
                throw new RuntimeException("Unknown weapon type: " + weaponType);
        }
    }


}
