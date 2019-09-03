package pro.it.sis.javacourse.homework07.weather;

import pro.it.sis.javacourse.homework07.weather.dto.WeatherDTO;

import java.time.LocalDateTime;

public class Weather {

	public Double temperature;
	public String city;
	public LocalDateTime date;

	public static Weather fromExternalDTO(WeatherDTO dto) {
		Weather data = new Weather();
		data.city = dto.name;
		data.date = DateService.fromUnixTS(dto.dt);
		data.temperature = dto.main.temp;
		return data;
	}

	public String toString() {
		return date + " " + city + " " + temperature;
	}

}
