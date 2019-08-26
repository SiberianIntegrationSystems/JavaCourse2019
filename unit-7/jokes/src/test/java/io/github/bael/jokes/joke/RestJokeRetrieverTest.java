package io.github.bael.jokes.joke;

import io.github.bael.jokes.JokesApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = JokesApplication.class,
        properties = {
                InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
                ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
        }
)
public class RestJokeRetrieverTest {

    @Autowired
    JokeRetriever jokeRetriever;

    @Test
    public void joke() {
        String jokeText = jokeRetriever.getJoke().value.getJoke();
        Assert.assertFalse(jokeText.isEmpty());
        Assert.assertTrue(jokeText.contains("Chuck Norris"));
    }
}