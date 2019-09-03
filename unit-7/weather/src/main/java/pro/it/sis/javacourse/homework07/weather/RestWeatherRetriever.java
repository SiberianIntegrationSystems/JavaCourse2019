package pro.it.sis.javacourse.homework07.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pro.it.sis.javacourse.homework07.weather.dto.WeatherDTO;

import java.net.URI;

@Service
public class RestWeatherRetriever implements WeatherRetriever {

	private final Logger logger = LoggerFactory.getLogger(RestWeatherRetriever.class);

	private final RestTemplate restTemplate;

	private final PropertyService propertyService;

	public RestWeatherRetriever(RestTemplate restTemplate, PropertyService propertyService) {
		this.restTemplate = restTemplate;
		this.propertyService = propertyService;
	}

	@Override
	public Weather getWeather(String city) {
		Weather result = null;
		try {
			logger.debug("Request weather for city: {}", city);

			String url = "https://community-open-weather-map.p.rapidapi.com/weather?units=metric&mode=json&q=" + city;

			MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
			headers.add("x-rapidapi-host", this.propertyService.getRapidApiHost());
			headers.add("x-rapidapi-key", this.propertyService.getRapidApiKey());

			RequestEntity requestEntity = new RequestEntity(headers, HttpMethod.GET, URI.create(url));

			ResponseEntity<WeatherDTO> response = restTemplate.exchange(requestEntity, WeatherDTO.class);

			result = Weather.fromExternalDTO(response.getBody());
			logger.debug("Request completed with result: {}", result);
		} catch (Exception ex) {
			logger.error("Error was occurred: " + ex.getLocalizedMessage());
		}


		return result;
	}
}
