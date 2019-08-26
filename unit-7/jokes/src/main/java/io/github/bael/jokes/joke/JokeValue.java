package io.github.bael.jokes.joke;

public class JokeValue {

    private int id;
    private String joke;

    public int getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }

    @Override
    public String toString() {
        return "JokeValue{" +
                "id=" + id +
                ", joke='" + joke + '\'' +
                '}';
    }

//    { "id": 560, "joke": "Chuck Norris sits at the stand-up.", "categories": [] }
}
