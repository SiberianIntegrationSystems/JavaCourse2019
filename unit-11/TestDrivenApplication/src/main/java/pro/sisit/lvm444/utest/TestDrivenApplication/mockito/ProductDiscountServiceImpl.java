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
    public double calculateDiscount(Product product, ClientUser client) {

        if (product.getCost()>99)
        {
            return product.getCost()*discountService.getDiscount(client.getLevel());
        }
        else
        {
            return product.getCost();
        }
    }
}
