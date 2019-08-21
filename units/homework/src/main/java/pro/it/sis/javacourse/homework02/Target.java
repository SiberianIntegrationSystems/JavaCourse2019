package pro.it.sis.javacourse.homework02;

import java.util.ArrayList;
import java.util.List;

public class Target {

    private List<Damage> damages = new ArrayList<>();

    public double getTotalDamageStrength() {
        double totalDamage = 0;
        for (Damage damage : this.damages) {
            totalDamage += damage.getStrength();
        }
        return totalDamage;
    }

    public double getLastDamageStrength(DamageType type) {
        double lastDamage = 0;
        for (int i = damages.size() - 1; i >= 0; i--) {
            Damage currentDamage = damages.get(i);
            if (currentDamage.getType().equals(type)) {
                lastDamage = currentDamage.getStrength();
                break;
            }
        }
        return lastDamage;
    }

    public double getTotalDamageStrength(DamageType type) {
        double totalDamage = 0;
        for (Damage damage : this.damages) {
            if (damage.getType().equals(type)) {
                totalDamage += damage.getStrength();
            }
        }
        return totalDamage;
    }

    public void addDamage(List<Damage> weaponDamages) {
        this.damages.addAll(weaponDamages);
    }
}
