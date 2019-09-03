package pro.sisit.java.jpa.BookStoreApplication.services;

import pro.sisit.java.jpa.BookStoreApplication.entities.Author;
import pro.sisit.java.jpa.BookStoreApplication.entities.Book;


public interface BookService {
    Book createBook(String name, String isbn, Long author);

    Book findIsbn(String isbn);
}
