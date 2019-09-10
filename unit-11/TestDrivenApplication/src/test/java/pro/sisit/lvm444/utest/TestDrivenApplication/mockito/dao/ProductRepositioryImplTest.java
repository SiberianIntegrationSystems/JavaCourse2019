package pro.sisit.lvm444.utest.TestDrivenApplication.mockito.dao;

import org.junit.Test;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.Product;

import static org.junit.Assert.*;

public class ProductRepositioryImplTest {

    @Test
    public void find() {

        ProductServiceImpl productRepositiory = new ProductServiceImpl();

        Product product = productRepositiory.find(1).orElseGet(()-> null);

        assertNotNull(product);

        assertEquals(1L,product.getId());
    }
}