package pro.it.sis.javacourse.homework05;

import pro.it.sis.javacourse.homework05.entity.DeliveryTask;
import pro.it.sis.javacourse.homework05.entity.Transport;

import java.util.Comparator;
import java.util.List;

public class PathFinder {

	public Transport getOptimalTransport(DeliveryTask deliveryTask, List<Transport> transports) {
		return transports.stream()
				.filter(transport -> this.availableByVolume(deliveryTask, transport))
				.filter(transport -> this.availableByRouteType(deliveryTask, transport))
				.min(Comparator.comparingDouble(transport -> getTaskPrice(deliveryTask, transport)))
				.orElse(null);
	}

	private boolean availableByVolume(DeliveryTask task, Transport transport) {
		return task.getVolume() <= transport.getVolume();
	}

	private boolean availableByRouteType(DeliveryTask task, Transport transport) {
		return task.getRoutes().stream().anyMatch(route -> route.getType().equals(transport.getType()));
	}

	private double getTaskPrice(DeliveryTask task, Transport transport) {
		return task.getRoutes()
				.stream()
				.filter(route -> route.getType().equals(transport.getType()))
				.findFirst()
				.map(route -> route.getLength() * transport.getPrice())
				.orElseThrow(() -> new RuntimeException("Unavailable transport: " + transport.getType()));
	}

}
