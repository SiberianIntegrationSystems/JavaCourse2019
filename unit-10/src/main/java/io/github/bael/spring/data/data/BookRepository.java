package io.github.bael.spring.data.data;

import io.github.bael.spring.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long>
, PagingAndSortingRepository<Book, Long>, JpaRepository<Book, Long>
    , JpaSpecificationExecutor<Book>,
        BookComplexQueryRepository
{

    List<Book> findBooksByYear(int year);

    @Query("select aob.book from "
            + "AuthorOfBook aob join aob.book "
            + "join aob.author "
            + "where  aob.author.lastname = ?1")
    List<Book> findByAuthorLastname(String authorLastName);

}
