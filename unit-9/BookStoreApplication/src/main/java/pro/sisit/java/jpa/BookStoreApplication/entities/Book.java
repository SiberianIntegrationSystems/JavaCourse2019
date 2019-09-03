package pro.sisit.java.jpa.BookStoreApplication.entities;

import java.util.List;

public class Book {

    private Long id;

    private String Name;

    private Author author;

    private String isbn;

    private List<Page> pages;

    public Long getId() {
        return id;
    }
}
