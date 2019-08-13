package pro.it.sis.javacourse;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeaponTest {

    @Test
    public void testMeleePhysicalDamage() {
        this.testDamage(WeaponType.melee, DamageType.physical, 100);
    }

    @Test
    public void testMeleeFireDamage() {
        this.testDamage(WeaponType.melee, DamageType.fire, 50);
    }

    @Test
    public void testMeleeIceDamage() {
        this.testDamage(WeaponType.melee, DamageType.ice, 100);
    }

    @Test
    public void testRangedPhysicalDamage() {
        this.testDamage(WeaponType.ranged, DamageType.physical, 100);
    }

    @Test
    public void testRangedFireDamage() {
        this.testDamage(WeaponType.ranged, DamageType.fire, 10);
    }

    @Test
    public void testRangedIceDamage() {
        this.testDamage(WeaponType.ranged, DamageType.ice, 15);
    }

    private void testDamage(WeaponType weaponType, DamageType damageType, int damageStrength) {
        Target target = new Target();
        Weapon weapon = WeaponFactory.createWeapon(weaponType, damageType, damageStrength);
        weapon.hit(target);

        assertEquals(damageStrength, target.getTotalDamageStrength(damageType));
        assertEquals(damageStrength, target.getTotalDamageStrength());
    }

    @Test
    public void testDoubleRangedIceDamage() {
        Target target = new Target();
        Weapon weapon = WeaponFactory.createWeapon(WeaponType.ranged, DamageType.ice, 10);
        weapon.hit(target);
        weapon.hit(target);

        assertEquals(20, target.getTotalDamageStrength(DamageType.ice));
        assertEquals(20, target.getTotalDamageStrength());
    }

    @Test
    public void testBrokenWeapon() {
        Target target = new Target();
        Weapon weapon = WeaponFactory.createWeapon(WeaponType.ranged, DamageType.ice, 30);
        weapon.hit(target);
        assertEquals(30, target.getTotalDamageStrength(DamageType.ice));

        weapon.getDamage().setStrength(5);
        assertEquals(5, weapon.getDamage().getStrength());

        assertEquals(30, target.getTotalDamageStrength(DamageType.ice));

    }

    @Test
    public void testMixedDamage() {
        Target target = new Target();

        Weapon fireStick = WeaponFactory.createWeapon(WeaponType.ranged, DamageType.fire, 40);
        fireStick.hit(target);

        Weapon simpleBow = WeaponFactory.createWeapon(WeaponType.ranged, DamageType.physical, 15);
        simpleBow.hit(target);

        Weapon frozenSword = WeaponFactory.createWeapon(WeaponType.ranged, DamageType.ice, 20);
        frozenSword.hit(target);

        assertEquals(20, target.getTotalDamageStrength(DamageType.ice));
        assertEquals(15, target.getTotalDamageStrength(DamageType.physical));
        assertEquals(40, target.getTotalDamageStrength(DamageType.fire));
        assertEquals(75, target.getTotalDamageStrength());
    }
}