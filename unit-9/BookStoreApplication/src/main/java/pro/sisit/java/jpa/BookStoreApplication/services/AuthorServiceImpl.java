package pro.sisit.java.jpa.BookStoreApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.java.jpa.BookStoreApplication.entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {



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

        entityManager.persist(author);

        return author;
    }
}
