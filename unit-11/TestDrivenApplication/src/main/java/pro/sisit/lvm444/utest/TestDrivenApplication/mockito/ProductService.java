package pro.sisit.lvm444.utest.TestDrivenApplication.mockito;

import jdk.nashorn.internal.runtime.options.Option;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> find(int id);
}
