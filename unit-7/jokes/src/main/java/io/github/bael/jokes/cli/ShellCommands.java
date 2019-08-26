package io.github.bael.jokes.cli;

import io.github.bael.jokes.JokesApplication;
import io.github.bael.jokes.joke.JokeDataService;
import io.github.bael.jokes.joke.JokeRetriever;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@ShellComponent
public class ShellCommands {
    private final JokeRetriever jokeService;
    private final JokeDataService jokeDataService;

    public ShellCommands(JokeRetriever jokeService, JokeDataService jokeDataService) {
        this.jokeService = jokeService;
        this.jokeDataService = jokeDataService;
    }

    private String lastJoke;

    @ShellMethod("Get joke about Chuck Norris.")
    public String joke() {
        lastJoke = jokeService.getJoke().value.getJoke();
        return lastJoke;
    }

    @ShellMethod("Get last joke.")
    public String last() {
        return Optional.ofNullable(lastJoke).orElse("No jokes yet");
    }

    @ShellMethod("That's good, save it!")
    public String save() {
        if (Objects.nonNull(lastJoke)) {
                jokeDataService.save(lastJoke);
        }

        return "saved";
    }

    @ShellMethod("Show all saved")
    public String show() {
        return jokeDataService.getAll().stream().collect(Collectors.joining("\n"));
    }
}
