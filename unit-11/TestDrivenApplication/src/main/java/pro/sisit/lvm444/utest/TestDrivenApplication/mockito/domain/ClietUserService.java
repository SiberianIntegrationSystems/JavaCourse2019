package pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain;

import java.util.Optional;

public interface ClietUserService {
    Optional<ClientUser> find(int clientId);
}
