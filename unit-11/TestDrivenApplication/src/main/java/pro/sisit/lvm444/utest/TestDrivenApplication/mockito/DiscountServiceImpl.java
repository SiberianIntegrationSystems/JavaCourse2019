package pro.sisit.lvm444.utest.TestDrivenApplication.mockito;

import org.springframework.stereotype.Service;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClientUser;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.UserLevel;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Override
    public double getDiscount(UserLevel level) {

        if (UserLevel.SMALL.equals(level))
        {
            return 0.95;
        }
        else if(UserLevel.MEDIUM.equals(level))
        {
            return 0.90;
        }
        else if(UserLevel.HUGE.equals(level))
        {
            return 0.85;
        }
        else
        {
            return 100;
        }
    }

    @Override
    public void sendNotification(ClientUser client) {
        System.out.printf("User has discount %s%n", client.getName());
    }
}
