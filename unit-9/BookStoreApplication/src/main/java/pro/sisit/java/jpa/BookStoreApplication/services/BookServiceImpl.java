package pro.sisit.java.jpa.BookStoreApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import pro.sisit.java.jpa.BookStoreApplication.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Book createBook(String name,String isbn, String authorid) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Book book = new Book();
        book.setIsbn(isbn);
        book.setName(name);
        book.setAuthor(author);

        entityManager.persist(book);

        return book;


        return null;
    }

    @Override
    public Book findByISBN(String isbn) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book as b WHERE b.isbn=:isbn", Book.class);
        query.setParameter("isbn",isbn);

        List<Book> resultList = query.getResultList();

        if (resultList.size()>0)
        {
            return resultList.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public Book findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Book book = entityManager.find(Book.class, id);

        return book;

    }
}
