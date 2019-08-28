package pro.it.sis.javacourse;

public class Damage {

    private int physicalDamage;
    private int fireDamage;
    private int iceDamage;

    Damage(int physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    void setPhysicalDamage(int fireDamage) {
        this.physicalDamage = fireDamage;
    }

    void setFireDamage(int fireDamage) {
        this.fireDamage = fireDamage;
    }

    void setIceDamage(int iceDamage) {
        this.iceDamage = iceDamage;
    }

    int getPhysicalDamage() {
        return physicalDamage;
    }

    int getFireDamage() {
        return fireDamage;
    }

    int getIceDamage() {
        return iceDamage;
    }

    String getAllValues() {
        return String.format(
                "physicalDamage = %s, fireDamage = %s, iceDamage = %s",
                physicalDamage, fireDamage, iceDamage
        );
    }
}
