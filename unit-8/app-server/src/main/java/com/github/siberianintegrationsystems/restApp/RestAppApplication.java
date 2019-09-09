package com.github.siberianintegrationsystems.restApp;

import static com.github.siberianintegrationsystems.restApp.service.JournalServiceImpl.QUESTIONS_JOURNAL_ID;
import static com.github.siberianintegrationsystems.restApp.service.JournalServiceImpl.SESSIONS_JOURNAL_ID;

import com.github.siberianintegrationsystems.restApp.data.JournalRepository;
import com.github.siberianintegrationsystems.restApp.entity.Journal;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestAppApplication {

	@Autowired
	JournalRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(RestAppApplication.class, args);
	}

	@PostConstruct
	public void init() {
		createJournal(QUESTIONS_JOURNAL_ID, "Вопросы");
		createJournal(SESSIONS_JOURNAL_ID, "Сессии");
	}

	private void createJournal(String id, String name) {
		Journal sessions = new Journal();
		sessions.setId(id);
		sessions.setName(name);
		sessions.setDefaultPageSize(15L);
		repository.save(sessions);
	}

}
