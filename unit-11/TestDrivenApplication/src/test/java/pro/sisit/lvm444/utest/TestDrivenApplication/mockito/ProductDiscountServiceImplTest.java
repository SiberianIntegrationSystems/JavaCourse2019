package pro.sisit.lvm444.utest.TestDrivenApplication.mockito;

import org.junit.Assert;
import org.junit.Test;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClientUser;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.Product;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.UserLevel;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class ProductDiscountServiceImplTest {


    @Test
    public void testDiscount() {

        Product product = new Product(100,"Beer");

        ClientUser client = new ClientUser(UserLevel.MEDIUM,"Ivan");

        ProductDiscountServiceImpl service = new ProductDiscountServiceImpl();
        double specialCost = service.calculateDiscount(product, client);

        Assert.assertThat(specialCost,is((double)90));
    }
}