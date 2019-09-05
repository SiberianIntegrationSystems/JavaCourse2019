package io.github.bael.spring.data.data;

import io.github.bael.spring.data.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BooksSpecification {

    public static Specification<Book> yearLessThan(int year) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get("year"), year);
    }

    public static Specification<Book> yearGreaterThan(int year) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("year"), year);
    }

    public static Specification<Book> yearInRange(int startYear, int finishYear) {

        return yearLessThan(finishYear).and(yearGreaterThan(startYear));

    }
}
