package pro.it.sis.javacourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Weapon {
    private List<Damage> damages = new ArrayList<>();
    private double grade = 1;
    private int hitCount = 0;

    public Weapon(Damage... damages) {
        this.damages.addAll(Arrays.asList(damages));
    }

    void hit(Target target) {
        target.addDamage(damages);
        this.hitCount++;
        if (hitCount % 10 == 0) {
            this.downgrade(0.1);
        }
    }

    private void setGrade(double grade) {
        if (this.grade == grade) {
            return;
        }

        List<Damage> newDamages = new ArrayList<>();
        for (Damage damage : this.damages) {
            Damage newDamage = damage.copy();
            newDamage.setStrength((int) (newDamage.getStrength() * grade));
            newDamages.add(newDamage);
        }

        this.damages = newDamages;
        this.grade = grade;
    }

    public void downgrade(double diff) {
        this.setGrade(this.grade - diff);
    }

    public void upgrade(double diff) {
        this.setGrade(this.grade + diff);
    }

    public void restore() {
        this.setGrade(1);
    }
}
