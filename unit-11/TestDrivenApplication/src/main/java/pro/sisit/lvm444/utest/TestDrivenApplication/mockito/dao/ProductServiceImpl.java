package pro.sisit.lvm444.utest.TestDrivenApplication.mockito.dao;

import org.springframework.stereotype.Repository;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.ProductService;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.Product;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class ProductServiceImpl implements ProductService {

    @Override
    public Optional<Product> find(int id) {

        HashMap<Integer,Product> productSet = new HashMap<>();

        productSet.putIfAbsent(1,new Product(1,50,"milk"));
        productSet.putIfAbsent(2,new Product(2,80,"soap"));
        productSet.putIfAbsent(3,new Product(3,100,"beer"));


        Product product = productSet.getOrDefault(id, null);
        return Optional.ofNullable(product);
    }
}
