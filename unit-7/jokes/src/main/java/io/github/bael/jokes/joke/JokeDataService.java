package io.github.bael.jokes.joke;

import java.util.List;

public interface JokeDataService {

    void save(String jokeText);

    List<String> getAll();
}
