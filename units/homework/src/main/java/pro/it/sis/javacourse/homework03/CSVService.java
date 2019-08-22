package pro.it.sis.javacourse.homework03;

public class CSVService {

	public static final String CSV_DELIMITER = ";";

	public static String toCSV(String... properties) {
		return String.join(CSV_DELIMITER, properties);
	}

	public static String[] parseCSV(String csv) {
		return csv.split(CSV_DELIMITER);
	}
}
