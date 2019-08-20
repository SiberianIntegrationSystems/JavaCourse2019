package pro.sisit.javacourse;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductsService {

    public static void main(String[] args) {
    }

    private static List<Product> getProducts() {
        return Arrays.asList(
                new Product(1, "Саянита", ProductType.Candy, BigDecimal.valueOf(50), "Краскон"),
                new Product(2, "Саянские", ProductType.Candy, BigDecimal.valueOf(70), "Краскон"),
                new Product(3, "Красноярские столбы", ProductType.Candy, BigDecimal.valueOf(100), "Краскон"),
                new Product(4, "Багира", ProductType.Candy, BigDecimal.valueOf(110), "Краскон"),
                new Product(5, "Шоколад темный", ProductType.Chocolate, BigDecimal.valueOf(70), "Краскон"),
                new Product(6, "Шоколад молочный", ProductType.Chocolate, BigDecimal.valueOf(70), "Краскон"),
                new Product(7, "Дуэт в карамельном", ProductType.Chocolate, BigDecimal.valueOf(80), "Россия"),
                new Product(8, "Дуэт в молочном", ProductType.Chocolate, BigDecimal.valueOf(80), "Россия"),
                new Product(9, "Российский темный шоколад", ProductType.Chocolate, BigDecimal.valueOf(75), "Россия"),
                new Product(10, "Российский темный шоколад", ProductType.Chocolate, BigDecimal.valueOf(75), "Россия"),
                new Product(11, "Родные просторы", ProductType.Candy, BigDecimal.valueOf(120), "Россия")
        );
    }

}
