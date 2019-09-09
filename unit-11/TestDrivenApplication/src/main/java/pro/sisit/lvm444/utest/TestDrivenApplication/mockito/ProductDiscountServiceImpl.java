package pro.sisit.lvm444.utest.TestDrivenApplication.mockito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClientUser;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.Product;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.UserLevel;


@Service
public class ProductDiscountServiceImpl implements ProductDiscountService {

    @Override
    public double calculateDiscount(Integer cost, ClientUser client) {

        if (client.getLevel().equals(UserLevel.SMALL))
        {
            return cost * 0.95;
        }
        else if (client.getLevel().equals(UserLevel.MEDIUM))
        {
            return cost * 0.90;
        }
        else if(client.getLevel().equals(UserLevel.HUGE))
        {
            return cost * 0.85;
        }
        else {
            return cost;
        }
    }
}
