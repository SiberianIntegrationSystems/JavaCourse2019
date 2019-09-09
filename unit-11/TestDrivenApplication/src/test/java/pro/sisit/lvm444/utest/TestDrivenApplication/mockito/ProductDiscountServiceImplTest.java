package pro.sisit.lvm444.utest.TestDrivenApplication.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClientUser;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.Product;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.UserLevel;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductDiscountServiceImplTest {
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Captor
    private ArgumentCaptor<ClientUser> clientUserArgumentCaptor = ArgumentCaptor.forClass(ClientUser.class);

    @Mock
    private DiscountService discountService;

    @InjectMocks
    private ProductDiscountServiceImpl productDiscountService;

    @Test
    public void testDiscount() {

        when(discountService.getDiscount(any(UserLevel.class))).thenReturn(0.90);

        verify(discountService).sendNotification(clientUserArgumentCaptor.capture());

        ClientUser clientSended = clientUserArgumentCaptor.getValue();

        Product product = new Product(100,"Beer");

        ClientUser client = new ClientUser(UserLevel.MEDIUM,"Ivan");

        double specialCost = productDiscountService.calculateDiscount(product,client);

        Assert.assertThat(specialCost,is((double)90));
    }
}