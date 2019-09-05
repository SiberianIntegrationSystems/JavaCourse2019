package io.github.bael.spring.data.data;

import io.github.bael.spring.data.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
