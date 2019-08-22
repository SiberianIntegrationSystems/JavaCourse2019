package pro.it.sis.javacourse.homework03;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;
import static org.junit.Assert.assertEquals;

public class CsvAdapterTest {
	@Test
	public void testCsvAdapterAuthor() {

		InputStream fileStream = getClass().getClassLoader().getResourceAsStream("authors.csv");
		File file = FileService.copyStream(fileStream);

		try (FileInputStream fileInputStream = new FileInputStream(file);
			 InputStreamReader reader = new InputStreamReader(fileInputStream, UTF_8);
			 BufferedReader fileReader = new BufferedReader(reader);
			 BufferedWriter fileWriter = Files.newBufferedWriter(file.toPath(), UTF_8, APPEND)) {

			CSVAdapter<Author> authorCsvAdapter = new CSVAdapterImpl<>(Author.class, fileReader, fileWriter);

			Author author = authorCsvAdapter.read(0);
			assertEquals("Лев Николаевич Толстой", author.getName());
			assertEquals("Ясная Поляна", author.getBirthPlace());

			Author authorNew = new Author("Лукьяненко Сергей Васильевич", "Каратау");

			int rowIndex = authorCsvAdapter.append(authorNew);
			Author authorNewOpened = authorCsvAdapter.read(rowIndex);

			assertEquals(authorNew.getName(), authorNewOpened.getName());
			assertEquals(authorNew.getBirthPlace(), authorNewOpened.getBirthPlace());

		} catch (IOException | InstantiationException | IllegalAccessException ex) {
			ex.printStackTrace();
			throw new RuntimeException("While processing file '" + file.getName() + "' error occurred: " + ex.getLocalizedMessage());
		}
	}
	@Test
	public void testCsvAdapterBook() {

		InputStream fileStream = getClass().getClassLoader().getResourceAsStream("books.csv");
		File file = FileService.copyStream(fileStream);

		try (FileInputStream fileInputStream = new FileInputStream(file);
			 InputStreamReader reader = new InputStreamReader(fileInputStream, UTF_8);
			 BufferedReader fileReader = new BufferedReader(reader);
			 BufferedWriter fileWriter = Files.newBufferedWriter(file.toPath(), UTF_8, APPEND)) {

			CSVAdapter<Book> bookCsvAdapter = new CSVAdapterImpl<>(Book.class, fileReader, fileWriter);

			Book book = bookCsvAdapter.read(0);
			assertEquals("Война и мир", book.getTitle());
			assertEquals("Толстой Л. Н.", book.getAuthor());
			assertEquals(Integer.valueOf("1996"), book.getPublishingYear());
			assertEquals(BookGenre.Classic, book.getGenre());

			Book bookNew = new Book("Территория", "Олег Куваев", 1975, BookGenre.Romance);

			int rowIndex = bookCsvAdapter.append(bookNew);
			Book bookNewOpened = bookCsvAdapter.read(rowIndex);

			assertEquals(bookNew.getTitle(), bookNewOpened.getTitle());
			assertEquals(bookNew.getAuthor(), bookNewOpened.getAuthor());
			assertEquals(bookNew.getPublishingYear(), bookNewOpened.getPublishingYear());
			assertEquals(bookNew.getGenre(), bookNewOpened.getGenre());

		} catch (IOException | InstantiationException | IllegalAccessException ex) {
			ex.printStackTrace();
			throw new RuntimeException("While processing file '" + file.getName() + "' error occurred: " + ex.getLocalizedMessage());
		}
	}
}