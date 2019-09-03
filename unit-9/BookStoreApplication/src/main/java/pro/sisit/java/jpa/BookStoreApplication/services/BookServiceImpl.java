package pro.sisit.java.jpa.BookStoreApplication.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.java.jpa.BookStoreApplication.dao.AuthorDAO;
import pro.sisit.java.jpa.BookStoreApplication.dao.BookDAO;
import pro.sisit.java.jpa.BookStoreApplication.entities.Author;
import pro.sisit.java.jpa.BookStoreApplication.entities.Book;
import pro.sisit.java.jpa.BookStoreApplication.entities.Page;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private final AuthorDAO authorDAO;

    @Autowired
    private final BookDAO bookDAO;

    public BookServiceImpl(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public Book createBook(String name, String isbn, Long authorid) {
        Author author = authorDAO.findById(authorid);

        Book book = bookDAO.createBook(name, isbn, author);

        ArrayList<Page> pages = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Page page = new Page();

            page.setNumber(String.valueOf(i));
            pages.add(page);
        }
        book.setPages(pages);

        return book;
    }

    @Override
    public Book findIsbn(String isbn) {
        Optional<Book> byISBN = Optional.ofNullable(bookDAO.findByISBN(isbn));

        return byISBN.get();
    }

    private class BookNotFound extends RuntimeException{

        public BookNotFound(String message) {
            super(message);
        }
    }
}
