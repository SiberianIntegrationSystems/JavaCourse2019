package pro.sisit.java.jpa.BookStoreApplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.sisit.java.jpa.BookStoreApplication.entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class AuthorDAOImpl implements AuthorDAO {


    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public AuthorDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Author findById(Long authorid) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Author.class,authorid);
    }
}
