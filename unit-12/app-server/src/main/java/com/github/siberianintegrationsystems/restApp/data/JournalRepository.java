package com.github.siberianintegrationsystems.restApp.data;

import com.github.siberianintegrationsystems.restApp.entity.Journal;
import org.springframework.data.repository.CrudRepository;

public interface JournalRepository
        extends CrudRepository<Journal, String> {
}
