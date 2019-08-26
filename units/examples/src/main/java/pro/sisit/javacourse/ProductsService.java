package pro.sisit.javacourse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsService {

    public static void main(String[] args) {
        List<Product> products = getProducts();
        String producer = getProducer(products, 13);
        System.out.println(producer);
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

    private static List<Product> filterByType(List<Product> products, ProductType type) {
        return products.stream()
                .filter(product -> product.getType() == type)
                .collect(Collectors.toList());
    }

    private static List<String> getSortedProducers(List<Product> products) {
        return products.stream()
                .map(Product::getProducer)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static BigDecimal getTotalTax(List<Product> products) {
        return products.stream()
                .map(Product::getPrice)
                .map(price -> price.divide(BigDecimal.valueOf(120), RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(20)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static String getProducer(List<Product> products, long id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .map(product -> "Производитель: " + product.getProducer())
                .findFirst()
                .orElse("Товар не найден");
    }

}
