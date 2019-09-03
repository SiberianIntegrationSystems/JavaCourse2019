package pro.it.sis.javacourse.homework07.weather;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Optional;

@Service
public class PropertyService {

	private final Environment environment;

	public PropertyService(Environment environment) {
		this.environment = environment;
	}

	public ZoneId getDefaultTimeZone() {
		return ZoneId.of(
				Optional.ofNullable(this.environment.getProperty("weather.ldt.defaultZoneId"))
						.orElse(DateService.ZONE_UTC));

	}

	public String getRapidApiHost() {
		return Optional.ofNullable(this.environment.getProperty("x.rapidapi.host"))
				.orElseThrow(() -> new RuntimeException("RapidApi host not specified."));
	}

	public String getRapidApiKey() {
		return Optional.ofNullable(this.environment.getProperty("x.rapidapi.key"))
				.orElseThrow(() -> new RuntimeException("RapidApi key not specified."));
	}
}
