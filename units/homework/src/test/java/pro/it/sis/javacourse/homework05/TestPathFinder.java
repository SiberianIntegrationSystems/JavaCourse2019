package pro.it.sis.javacourse.homework05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import pro.it.sis.javacourse.homework05.entity.DeliveryTask;
import pro.it.sis.javacourse.homework05.entity.Route;
import pro.it.sis.javacourse.homework05.entity.RouteType;
import pro.it.sis.javacourse.homework05.entity.Transport;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestPathFinder {

	private static Transport GAZelle = new Transport("Газель", 1, 1, RouteType.Road);
	private static Transport Plane = new Transport("Самолет", 20, 50, RouteType.Air);
	private static Transport Tanker = new Transport("Танкер", 200, 100, RouteType.Sea);
	private static Transport Train = new Transport("Поезд", 100, 10, RouteType.Railway);
	private static Transport SemiTrailerTruck = new Transport("Фура", 5, 2, RouteType.Road);

	private List<Transport> getAvailableTransport() {
		return Arrays.asList(GAZelle, Plane, Tanker, Train, SemiTrailerTruck);
	}

	@ParameterizedTest
	@ArgumentsSource(TestGetOptimalTransportArguments.class)
	void testGetOptimalTransport(DeliveryTask deliveryTask, Transport expected) {
		PathFinder pathFinder = new PathFinder();
		Transport optimalTransport = pathFinder.getOptimalTransport(deliveryTask, getAvailableTransport());
		Assertions.assertEquals(expected, optimalTransport);
	}

	static class TestGetOptimalTransportArguments implements ArgumentsProvider {

		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
			return Stream.of(
					new Object[]{getApplesDelivery(), TestPathFinder.SemiTrailerTruck},
					new Object[]{getSmartphoneDelivery(), TestPathFinder.Plane},
					new Object[]{getCarsDelivery(), TestPathFinder.Train},
					new Object[]{getBreadDelivery(), TestPathFinder.GAZelle},
					new Object[]{getKingKongDelivery(), TestPathFinder.Tanker}
			).map(Arguments::of);
		}

		private DeliveryTask getKingKongDelivery() {
			return new DeliveryTask(
					"Кинг-Конг",
					Arrays.asList(
							new Route(RouteType.Air, 2000),
							new Route(RouteType.Sea, 2500)
					),
					150
			);
		}

		private DeliveryTask getBreadDelivery() {
			return new DeliveryTask(
					"Хлеб",
					Arrays.asList(
							new Route(RouteType.Air, 50),
							new Route(RouteType.Road, 100),
							new Route(RouteType.Railway, 70)
					),
					1
			);
		}

		private DeliveryTask getCarsDelivery() {
			return new DeliveryTask(
					"Автомобили",
					Arrays.asList(
							new Route(RouteType.Air, 2000),
							new Route(RouteType.Sea, 2500),
							new Route(RouteType.Road, 4000),
							new Route(RouteType.Railway, 3000)
					),
					100);
		}

		private DeliveryTask getSmartphoneDelivery() {
			return new DeliveryTask(
					"Смартфоны",
					Arrays.asList(
							new Route(RouteType.Air, 2000),
							new Route(RouteType.Sea, 2500),
							new Route(RouteType.Road, 4000)
					),
					20
			);
		}

		private DeliveryTask getApplesDelivery() {
			return new DeliveryTask(
					"Яблоки",
					Arrays.asList(
							new Route(RouteType.Road, 1000),
							new Route(RouteType.Air, 700)
					),
					5
			);
		}
	}

}
