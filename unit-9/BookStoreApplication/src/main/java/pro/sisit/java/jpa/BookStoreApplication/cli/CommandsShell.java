package pro.sisit.java.jpa.BookStoreApplication.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import pro.sisit.java.jpa.BookStoreApplication.entities.Author;
import pro.sisit.java.jpa.BookStoreApplication.entities.Book;
import pro.sisit.java.jpa.BookStoreApplication.services.AuthorService;
import pro.sisit.java.jpa.BookStoreApplication.services.BookService;

@ShellComponent
public class CommandsShell {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @ShellMethod("create book")
    public void createBook(@ShellOption({"-n", "--name"}) String name, @ShellOption({"-a", "--author"}) String authorid,@ShellOption({"-i", "--isbn"}) String isbn){

        Book book = bookService.createBook(name, isbn, Long.parseLong(authorid));

        Book book2 = bookService.findIsbn(isbn);

        System.out.printf("Книга сохранена %s",book2.toString());
    }

    @ShellMethod("create author")
    public void createAuthor(@ShellOption({"-n", "--name"}) String name){
        Author author = authorService.createAuthor(name);

        System.out.printf("Автор сохранен %s",author);
    }

    @ShellMethod("find by isbn")
    public void findIsbn(@ShellOption({"-i", "--isbn"}) String isbn){

        Book book = bookService.findIsbn(isbn);
    }
}
