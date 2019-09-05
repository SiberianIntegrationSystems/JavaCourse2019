package pro.sisit.java.jpa.BookStoreApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.java.jpa.BookStoreApplication.entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public AuthorServiceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Author createAuthor(String name) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Author author = new Author();
        author.setName(name);

        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return author;
    }
}
