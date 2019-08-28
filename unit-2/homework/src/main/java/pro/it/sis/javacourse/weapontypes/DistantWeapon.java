package pro.it.sis.javacourse.weapontypes;

import pro.it.sis.javacourse.Damage;
import pro.it.sis.javacourse.BaseWeapon;
import pro.it.sis.javacourse.enums.WeaponTypes;

public class DistantWeapon extends BaseWeapon {

    private final String label = WeaponTypes.DISTANT.getLabel();

    public DistantWeapon(Damage damage) {
        super(damage);
    }
    
    @Override
    public String getLabel() {
        return label;
    }

}
