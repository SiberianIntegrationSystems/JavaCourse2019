package pro.it.sis.javacourse.homework05.entity;

/**
 * Транспорт для доставки груза
 */
public class Transport {

    /**
     * Название
     */
    private String name;
    /**
     * Допустимый объем груза
     */
    private double volume;
    /**
     * Стоимость перевозки груза на единицу длины маршрута
     */
    private double price;
    /**
     * Тип маршрута, по которому может перемещаться транспорт
     */
    private RouteType type;

    public Transport(String name, double volume, double price, RouteType type) {
        this.name = name;
        this.volume = volume;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public double getPrice() {
        return price;
    }

    public RouteType getType() {
        return type;
    }
}
