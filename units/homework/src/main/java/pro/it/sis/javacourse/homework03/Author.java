package pro.it.sis.javacourse.homework03;

public class Author implements CSVObject {
	private String name;
	private String birthPlace;

	public Author() {
	}

	public Author(String authorName, String authorBirthPlace) {
		this.name = authorName;
		this.birthPlace = authorBirthPlace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@Override
	public String toCSV() {
		return CSVService.toCSV(this.name, this.birthPlace);
	}

	@Override
	public void fillByCSV(String csv) {
		String[] properties = CSVService.parseCSV(csv);
		this.name = properties[0];
		this.birthPlace = properties[1];
	}
}
