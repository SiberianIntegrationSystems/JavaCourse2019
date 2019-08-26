package pro.it.sis.javacourse.homework05.entity;

import java.util.List;

/**
 * Задача по доставке груза из одной точки в другую
 */
public class DeliveryTask {

	/**
	 * Список доступных маршрутов для доставки
	 */
	private List<Route> routes;

	/**
	 * Объем груза
	 */
	private double volume;

	/**
	 * Название груза
	 */
	private String name;

	public DeliveryTask(String name, List<Route> routes, double volume) {
		this.name = name;
		this.routes = routes;
		this.volume = volume;
	}

	public String getName() {
		return name;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public double getVolume() {
		return volume;
	}
}
