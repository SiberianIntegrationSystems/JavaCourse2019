package io.github.bael.jokes.joke;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JdbcJokeDataService implements JokeDataService {

    private final JdbcTemplate jdbcTemplate;

    public JdbcJokeDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

@Override
public void save(String jokeText) {
    jdbcTemplate.update("insert into jokes (joke) values (?)", jokeText);
}

@Override
public List<String> getAll() {
    return jdbcTemplate.query("select joke from jokes",
            (rs, rowNum) -> rs.getString("joke"));
}
}
