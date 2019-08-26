package pro.it.sis.javacourse.homework05.entity;

/**
 * Маршрут
 */
public class Route {

    /**
     * Тип маршрута
     */
    private RouteType type;

    /**
     * Длина пути
     */
    private double length;

    public Route(RouteType type, double length) {
        this.type = type;
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public RouteType getType() {
        return type;
    }
}
