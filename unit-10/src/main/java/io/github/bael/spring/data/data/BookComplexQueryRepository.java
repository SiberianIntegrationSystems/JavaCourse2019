package io.github.bael.spring.data.data;

import io.github.bael.spring.data.entity.Book;

import java.util.List;

public interface BookComplexQueryRepository {
    List<Book> complexQueryMethod();
}