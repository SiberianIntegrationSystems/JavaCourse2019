package io.github.bael.jokes.joke;

public class JokeImportDTO {
    public String type;
    public JokeValue value;

    public int id;

    @Override
    public String toString() {
        return "JokeImportDTO{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", id=" + id +
                '}';
    }

//    { "type": "success", "value": { "id": 560, "joke": "Chuck Norris sits at the stand-up.", "categories": [] } }
}
