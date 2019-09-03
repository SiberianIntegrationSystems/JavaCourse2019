package pro.it.sis.javacourse.homework07.weather;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;

@ShellComponent
public class WeatherShell {

	private final WeatherRetriever weatherRetriever;
	private final WeatherDataService weatherDataService;

	public WeatherShell(WeatherRetriever weatherRetriever, WeatherDataService weatherDataService) {
		this.weatherRetriever = weatherRetriever;
		this.weatherDataService = weatherDataService;
	}

	@ShellMethod("Get weather by default city.")
	public String current() {
		return weather("Красноярск");
	}

	@ShellMethod("Get weather by concrete city.")
	public String weather(String city) {
		return Optional.ofNullable(this.weatherRetriever.getWeather(city))
				.map(this.weatherDataService::save)
				.orElse(null);
	}

	@ShellMethod("Show all saved")
	public String show() {
		return String.join("\n", this.weatherDataService.getAll());
	}
}
