package pro.it.sis.javacourse.homework07.weather;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@Transactional
public class JdbcWeatherDataService implements WeatherDataService {

	private final JdbcTemplate jdbcTemplate;
	private final PropertyService propertyService;

	public JdbcWeatherDataService(JdbcTemplate jdbcTemplate, Environment environment, PropertyService propertyService) {
		this.jdbcTemplate = jdbcTemplate;
		this.propertyService = propertyService;
	}

	@Override
	public String save(Weather weather) {
		LocalDateTime localDateTime = weather.date.atZone(ZoneId.of(DateService.ZONE_UTC))
				.withZoneSameInstant(this.propertyService.getDefaultTimeZone())
				.toLocalDateTime();

		String text = DateService.toRusDate(localDateTime) + " " + weather.city + " " + weather.temperature;
		this.save(text);

		return text;
	}

	@Override
	public String save(String weatherText) {
		this.jdbcTemplate.update("insert into weather_data (weather) values (?)", weatherText);

		return weatherText;
	}

	@Override
	public List<String> getAll() {
		return jdbcTemplate.query("select weather from weather_data",
				(rs, rowNum) -> rs.getString("weather"));
	}
}
