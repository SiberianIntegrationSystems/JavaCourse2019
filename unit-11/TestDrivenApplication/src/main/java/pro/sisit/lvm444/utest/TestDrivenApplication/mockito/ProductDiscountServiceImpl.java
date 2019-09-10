package pro.sisit.lvm444.utest.TestDrivenApplication.mockito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClientUser;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.Product;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.UserLevel;


@Service
public class ProductDiscountServiceImpl implements ProductDiscountService {

    @Autowired
    private DiscountService discountService;

    @Override
    public double calculateDiscount(Integer cost, ClientUser client) {

        if (cost>10)
        {
            discountService.sendNotification(client);

            return cost * discountService.getDiscount(client.getLevel());
        }
        else
        {
            return cost;
        }
    }
}
