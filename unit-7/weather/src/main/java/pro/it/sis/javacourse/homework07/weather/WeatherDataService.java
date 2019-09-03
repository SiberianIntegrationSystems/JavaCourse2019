package pro.it.sis.javacourse.homework07.weather;

import java.util.List;

public interface WeatherDataService {

	String save(Weather weather);

	String save(String weatherString);

	List<String> getAll();
}
