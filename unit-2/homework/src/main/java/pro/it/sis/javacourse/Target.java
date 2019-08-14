package pro.it.sis.javacourse;

import java.util.ArrayList;
import java.util.List;

public class Target {

    private List<Damage> damages = new ArrayList<>();

    public int getTotalDamageStrength() {
        int totalDamage = 0;
        for (Damage damage : this.damages) {
            totalDamage += damage.getStrength();
        }
        return totalDamage;
    }

    public int getLastDamageStrength(DamageType type) {
        int lastDamage = 0;
        for (int i = damages.size() - 1; i >= 0; i--) {
            Damage currentDamage = damages.get(i);
            if (currentDamage.getType().equals(type)) {
                lastDamage = currentDamage.getStrength();
                break;
            }
        }
        return lastDamage;
    }

    public int getTotalDamageStrength(DamageType type) {
        int totalDamage = 0;
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
