package pro.sisit.lvm444.utest.TestDrivenApplication.mockito;

import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClientUser;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.UserLevel;

public interface DiscountService {
    double getDiscount(UserLevel level);

    void sendNotification(ClientUser client);
}
