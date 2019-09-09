package pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain;

public class ClientUser {
    private final UserLevel level;

    public UserLevel getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    private final String name;

    public ClientUser(UserLevel level, String name) {
        this.level = level;
        this.name = name;
    }
}
