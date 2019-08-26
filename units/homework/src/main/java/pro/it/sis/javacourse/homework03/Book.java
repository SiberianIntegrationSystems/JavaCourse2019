package pro.it.sis.javacourse.homework03;

public class Book implements CSVObject {
	private String title;
	private String author;
	private Integer publishingYear;
	private BookGenre genre;

	public Book() {
	}

	public Book(String title, String author, Integer publishingYear, BookGenre genre) {
		this.title = title;
		this.author = author;
		this.publishingYear = publishingYear;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(Integer publishingYear) {
		this.publishingYear = publishingYear;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}


	@Override
	public String toCSV() {
		return CSVService.toCSV(this.title, this.author, this.publishingYear.toString(), genre.name());
	}

	@Override
	public void fillByCSV(String csv) {
		String[] properties = CSVService.parseCSV(csv);
		this.title = properties[0];
		this.author = properties[1];
		this.publishingYear = Integer.valueOf(properties[2]);
		this.genre = BookGenre.valueOf(properties[3]);

	}
}
