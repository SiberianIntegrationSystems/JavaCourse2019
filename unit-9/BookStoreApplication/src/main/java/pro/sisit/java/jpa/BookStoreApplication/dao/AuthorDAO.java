package pro.sisit.java.jpa.BookStoreApplication.dao;

import pro.sisit.java.jpa.BookStoreApplication.entities.Author;

public interface AuthorDAO {
    Author findById(Long authorid);
}
