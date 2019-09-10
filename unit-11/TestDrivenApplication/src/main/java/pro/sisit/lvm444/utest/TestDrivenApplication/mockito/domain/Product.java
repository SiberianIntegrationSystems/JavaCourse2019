package pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain;

public class Product {
    private final int cost;

    public long getId() {
        return id;
    }

    private final long id;

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    private final String name;

    public Product(long id, int cost, String name) {
        this.id = id;
        this.cost =cost;
        this.name = name;
    }
}
