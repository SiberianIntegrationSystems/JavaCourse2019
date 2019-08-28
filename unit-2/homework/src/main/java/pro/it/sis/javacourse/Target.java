package pro.it.sis.javacourse;

public class Target {

    private int physicalDamage;

    private int fireDamage;

    private int iceDamage;

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public int getFireDamage() {
        return fireDamage;
    }

    public int getIceDamage() {
        return iceDamage;
    }

    void setDamage(Damage damage) {
        physicalDamage += damage.getPhysicalDamage();
        fireDamage += damage.getFireDamage();
        iceDamage += damage.getIceDamage();
    }

    int getTotalDamage() {
        return physicalDamage + fireDamage + iceDamage;
    }
}
