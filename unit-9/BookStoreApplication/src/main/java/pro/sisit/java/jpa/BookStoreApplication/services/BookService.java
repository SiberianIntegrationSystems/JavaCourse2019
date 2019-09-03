package pro.sisit.java.jpa.BookStoreApplication.services;


import pro.sisit.java.jpa.BookStoreApplication.entities.Book;

public interface BookService {

    Book createBook(String name, String isbn, String authorid);

    Book findByISBN(String isbn);

    Book findById(Long id);
}
