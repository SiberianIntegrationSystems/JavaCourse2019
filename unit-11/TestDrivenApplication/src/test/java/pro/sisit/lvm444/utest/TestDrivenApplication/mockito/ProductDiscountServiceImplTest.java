package pro.sisit.lvm444.utest.TestDrivenApplication.mockito;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClientUser;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.Product;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.UserLevel;

import java.util.Arrays;
import java.util.List;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProductDiscountServiceImplTest {

    @Mock
    private DiscountService discountService;

    @Captor
    private ArgumentCaptor<ClientUser> clientCaptor = ArgumentCaptor.forClass(ClientUser.class);

    @InjectMocks
    private ProductDiscountServiceImpl productDiscountService;

    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDiscount() {
        // Arrange
        int cost = 100;

        ClientUser user = new ClientUser(1, UserLevel.MEDIUM,"Ivan");

        when(discountService.getDiscount(Mockito.any())).thenReturn(0.9);

        /// Act

        double discountedCost = productDiscountService.calculateDiscount(cost, user);

        verify(discountService,times(1)).sendNotification(clientCaptor.capture());

        /// Assert
        Assert.assertEquals(90,discountedCost,0);

        assertEquals(user.getId(),clientCaptor.getValue().getId());

    }


    @Test
    public void testList()
    {
        List<String> fruits = Arrays.asList("Orange", "Apple", "Melon");

        assertThat(fruits,containsInAnyOrder("Orange","Melon","Apple"));

        assertThat(fruits,anyOf(hasItem("Orange1"),containsInAnyOrder("O1range","Melon","Apple")));
    }

    @Test
    public void testShazam()
    {
        Product productActual = new Product(1,100,"Milk");

        Product productExp = new Product(2,100,"Milk");

        assertThat(productActual,sameBeanAs(productExp).ignoring("id"));



    }
}