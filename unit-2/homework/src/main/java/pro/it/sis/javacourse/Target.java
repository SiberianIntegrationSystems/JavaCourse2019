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

    public int getTotalDamageStrength(DamageType type) {
        int totalDamage = 0;
        for (Damage damage : this.damages) {
            if (damage.getType().equals(type)) {
                totalDamage += damage.getStrength();
            }
        }
        return totalDamage;
    }

    public void addDamage(Damage weaponDamage) {
        this.damages.add(weaponDamage);
    }
}
