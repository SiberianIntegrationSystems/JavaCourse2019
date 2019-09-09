package pro.sisit.lvm444.utest.TestDrivenApplication.mockito;

import org.junit.Assert;
import org.junit.Test;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClientUser;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.UserLevel;

public class ProductDiscountServiceImplTest {

    @Test
    public void testDiscount() {

        int cost = 100;

        ClientUser user = new ClientUser(1, UserLevel.MEDIUM,"Ivan");

        ProductDiscountServiceImpl productDiscountService = new ProductDiscountServiceImpl();

        double discountedProduct = productDiscountService.calculateDiscount(cost, user);

        Assert.assertEquals(90.005,discountedProduct,0.01);
    }
}