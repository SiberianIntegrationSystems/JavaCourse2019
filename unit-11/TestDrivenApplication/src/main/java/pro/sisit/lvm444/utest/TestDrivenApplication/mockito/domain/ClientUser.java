package pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain;

public class ClientUser {
    private final UserLevel level;

    public int getId() {
        return id;
    }

    private final int id;

    public UserLevel getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    private final String name;

    public ClientUser(int id, UserLevel level, String name) {

        this.id = id;
        this.level = level;
        this.name = name;
    }
}
