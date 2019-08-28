package pro.it.sis.javacourse;

import org.junit.Test;
import pro.it.sis.javacourse.weapontypes.DistantWeapon;
import pro.it.sis.javacourse.weapontypes.MeleeWeapon;

import static org.junit.Assert.*;

public class WeaponTest {

    @Test
    public void testPhysicalDamage() {
        Target t = new Target();
        Damage damage = new Damage(100);
        MeleeWeapon weapon = new MeleeWeapon(damage);

        weapon.hit(t);
        assertEquals(100, t.getPhysicalDamage());

        damage.setPhysicalDamage(50);
        weapon.hit(t);
        assertEquals(150, t.getPhysicalDamage());

    }

    @Test
    public void testFireDamage() {

        Target t = new Target();
        Damage damage = new Damage(20);
        damage.setFireDamage(200);
        DistantWeapon weapon = new DistantWeapon(damage);

        weapon.hit(t);
        assertEquals(200, t.getFireDamage());

        damage.setFireDamage(100);
        weapon.hit(t);
        assertEquals(300, t.getFireDamage());

    }

    @Test
    public void testIceDamage() {

        Target t = new Target();
        Damage damage = new Damage(30);
        damage.setIceDamage(300);
        MeleeWeapon weapon = new MeleeWeapon(damage);

        weapon.hit(t);
        assertEquals(300, t.getIceDamage());

        damage.setIceDamage(0);
        weapon.hit(t);
        assertEquals(300, t.getIceDamage());

    }

    @Test
    public void testTotalDamage() {
        Target t = new Target();
        Damage damage = new Damage(30);
        damage.setFireDamage(200);
        damage.setIceDamage(300);
        DistantWeapon weapon = new DistantWeapon(damage);

        weapon.hit(t);
        assertEquals(530, t.getTotalDamage());
    }
}