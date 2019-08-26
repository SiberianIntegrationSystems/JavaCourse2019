package pro.sisit.javacourse;

import java.math.BigDecimal;

public class Product {

    private long id;
    private String name;
    private ProductType type;
    private BigDecimal price;
    private String producer;

    public Product(long id, String name, ProductType type, BigDecimal price, String producer) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.producer = producer;
    }

    public long getId() {
        return id;
    }

    public ProductType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProducer() {
        return producer;
    }

    public String getName() {
        return name;
    }
}
