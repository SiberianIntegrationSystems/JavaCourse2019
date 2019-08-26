package io.github.bael.jokes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
public class JokesApplication {

	private final Logger logger = LoggerFactory.getLogger(JokesApplication.class);
	public JokesApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(JokesApplication.class, args);
	}

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void onPostConstruct() {
		logger.debug("Update DB Scheme");
		jdbcTemplate.update("drop table jokes if exists; create table jokes (text text);");
		logger.debug("Updated successfully");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
