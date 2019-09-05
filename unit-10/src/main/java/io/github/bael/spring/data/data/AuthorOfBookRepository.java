package io.github.bael.spring.data.data;

import io.github.bael.spring.data.entity.AuthorOfBook;
import org.springframework.data.repository.CrudRepository;

public interface AuthorOfBookRepository extends CrudRepository<AuthorOfBook, Long> {
}
