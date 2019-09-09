package pro.sisit.lvm444.utest.TestDrivenApplication.mockito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClientUser;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.Product;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.UserLevel;


@Service
public class ProductDiscountServiceImpl implements ProductDiscountService {


    @Override
    public double calculateDiscount(Product product1, ClientUser client) {

        if(client.getLevel().equals(UserLevel.SMALL))
        {
            return product1.getCost()*0.95;
        }
        else if(client.getLevel().equals(UserLevel.MEDIUM))
        {
            return product1.getCost()*0.90;
        }
        else if(client.getLevel().equals(UserLevel.HUGE))
        {
            return product1.getCost()*0.85;
        }
        else
        {
            return product1.getCost();
        }
    }
}
