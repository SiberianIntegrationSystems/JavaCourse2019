package pro.sisit.java.jpa.BookStoreApplication.entities;

import javax.persistence.*;


public class Page {

    private Long id;

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    private Long bookId;
}
