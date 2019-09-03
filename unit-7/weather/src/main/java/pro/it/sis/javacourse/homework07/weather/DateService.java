package pro.it.sis.javacourse.homework07.weather;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateService {

	public static String ZONE_UTC = "UTC";

	public static LocalDateTime fromUnixTS(Long unixTS) {
		return fromUnixTS(unixTS, ZoneId.of(ZONE_UTC));
	}

	public static LocalDateTime fromUnixTS(Long unixTS, ZoneId zoneId) {
		return LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTS), zoneId);
	}

	public static String toRusDate(LocalDateTime localDateTime) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		return dateTimeFormatter.format(localDateTime);
	}
}
