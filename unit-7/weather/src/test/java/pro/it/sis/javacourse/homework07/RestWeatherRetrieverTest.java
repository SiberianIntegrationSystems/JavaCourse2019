package pro.it.sis.javacourse.homework07;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import pro.it.sis.javacourse.WeatherApp;
import pro.it.sis.javacourse.homework07.weather.WeatherRetriever;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = WeatherApp.class,
		properties = {
				InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
				ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
		}
)
public class RestWeatherRetrieverTest {

	@Autowired
	WeatherRetriever weatherRetriever;

	@Test
	public void weatherTest() {
		String text = weatherRetriever.getWeather("Красноярск").toString();
		Assert.assertFalse(text.isEmpty());
		Assert.assertTrue(text.contains("Krasnoyarsk"));
	}
}