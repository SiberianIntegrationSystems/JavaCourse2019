package pro.it.sis.javacourse.homework02;

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
        if (this.hitCount % 10 == 0) {
            this.downgrade(0.1d);
        }
    }

    private void setGrade(double grade) {
        if (this.grade == grade) {
            return;
        }

        List<Damage> newDamages = new ArrayList<>();
        for (Damage damage : this.damages) {
            Damage newDamage = damage.copy();
            newDamage.setStrength(damage.getBaseStrength() * grade);
            newDamages.add(newDamage);
        }


        this.damages = newDamages;
        this.grade = grade;
    }

    public void downgrade(double diff) {
        double newGrade = this.grade - diff;
        if (newGrade < 0) {
            newGrade = 0;
        }
        this.setGrade(newGrade);
    }

    public void upgrade(double diff) {
        this.setGrade(this.grade + diff);
    }

    public void restore() {
        this.setGrade(1);
    }

    public String toString() {
        String result = "\n---------Weapon---------";

        for (Damage damage : this.damages) {
            result += "\nDamage type:" + damage.getType() + "; strength: " + damage.getStrength() + "; baseStrength: " + damage.getBaseStrength();
        }
        result += "\ngrade: " + grade;
        result += "\nhitCount: " + hitCount;

        result += "\n------------------------";

        return result;
    }

    public void print() {
        System.out.println(toString());
    }
}
