package pro.sisit.java.jpa.BookStoreApplication.dao;


import org.springframework.stereotype.Repository;
import pro.sisit.java.jpa.BookStoreApplication.entities.Author;
import pro.sisit.java.jpa.BookStoreApplication.entities.Book;

public interface BookDAO {

    Book createBook(String name, String isbn, Author author);

    Book findByISBN(String isbn);

    Book findById(Long id);
}
