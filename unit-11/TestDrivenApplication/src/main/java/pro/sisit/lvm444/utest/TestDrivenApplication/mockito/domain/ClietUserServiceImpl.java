package pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;


@Service
public class ClietUserServiceImpl implements ClietUserService {
    @Override
    public Optional<ClientUser> find(int clientId) {

        HashMap<Integer,ClientUser> usersMap = new HashMap<>();

        usersMap.putIfAbsent(1,new ClientUser(1,UserLevel.MEDIUM,"Ivan"));
        usersMap.putIfAbsent(2,new ClientUser(2,UserLevel.SMALL,"Fedor"));
        usersMap.putIfAbsent(3,new ClientUser(3,UserLevel.SMALL,"Nikolay"));

        return Optional.ofNullable(usersMap.get(clientId));
    }
}
