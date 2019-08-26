package io.github.bael.jokes.joke;

import io.github.bael.jokes.cli.ShellCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestJokeRetriever implements JokeRetriever {

    private final Logger logger = LoggerFactory.getLogger(RestJokeRetriever.class);

    private final RestTemplate restTemplate;

    public RestJokeRetriever(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public JokeImportDTO getJoke() {
        logger.debug("Request for new joke:");
        String url = "http://api.icndb.com/jokes/random";
        ResponseEntity<JokeImportDTO> response = restTemplate.getForEntity(url, JokeImportDTO.class);

        logger.debug("Request completed with result: {}", response.getBody());
        return response.getBody();
    }
}
