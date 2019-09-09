package pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain;

import java.util.Arrays;
import java.util.Optional;

public enum UserLevel {
    SMALL(0),MEDIUM(1),HUGE(2);

    public int getCode() {
        return code;
    }

    private final int code;

    UserLevel(int code) {
        this.code = code;
    }

    public static UserLevel findByString(int level) {

        Optional<UserLevel> firstopt = Arrays.stream(UserLevel.values()).filter(levelItem -> levelItem.getCode() == level).findFirst();

        return firstopt.orElseThrow(() -> new RuntimeException(String.format("Unknown user level %d", level)));
    }


}
