package pro.it.sis.javacourse;

public class WeaponFactory {
    public static Weapon createWeapon(WeaponType weaponType, DamageType damageType, double damageStrength) {
        Damage damage = DamageFactory.createDamage(damageType, damageStrength);
        return createWeapon(weaponType, damage);
    }

    public static Weapon createWeapon(WeaponType weaponType, Damage... damages) {
        switch (weaponType) {
            case ranged:
                return new RangedWeapon(damages);
            case melee:
                return new MeleeWeapon(damages);
            default:
                throw new RuntimeException("Unknown weapon type: " + weaponType);
        }
    }


}
