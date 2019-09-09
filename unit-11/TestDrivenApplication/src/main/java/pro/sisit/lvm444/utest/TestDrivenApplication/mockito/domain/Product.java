package pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain;

public class Product {
    private final int cost;

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    private final String name;

    public Product(int cost, String name) {
        this.cost =cost;
        this.name = name;
    }
}
