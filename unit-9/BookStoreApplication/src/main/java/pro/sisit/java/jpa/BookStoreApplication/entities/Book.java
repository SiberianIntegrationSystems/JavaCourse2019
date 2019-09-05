package pro.sisit.java.jpa.BookStoreApplication.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String isbn;

    /*@Column(name = "author_id")
    private Long authorId;*/

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Transient
    private List<Page> pages;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ID %d name %s isbn %s", id, name, isbn);
    }
}
