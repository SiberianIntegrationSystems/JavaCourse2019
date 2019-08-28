package pro.it.sis.javacourse.enums;

public enum WeaponTypes {

    MELEE("Melee"),
    DISTANT("Distant");

    private String label;

    WeaponTypes(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
