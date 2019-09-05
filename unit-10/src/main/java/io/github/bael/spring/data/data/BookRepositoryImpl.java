package io.github.bael.spring.data.data;

import io.github.bael.spring.data.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookComplexQueryRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> complexQueryMethod() {
        return jdbcTemplate.query(
                "select id, title, description, year from book",
                (rs, rowNum) -> Book.builder()
                        .id(rs.getLong("id"))
                        .year(rs.getInt("year"))
                        .title(rs.getString("title"))
                        .description(rs.getString("description"))
                        .build()
        );
    }
}
