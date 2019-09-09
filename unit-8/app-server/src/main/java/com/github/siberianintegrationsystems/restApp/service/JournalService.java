package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.JournalItemDTO;
import com.github.siberianintegrationsystems.restApp.entity.Journal;
import java.util.List;
import java.util.Optional;

public interface JournalService {

    Optional<Journal> findJournalById(String id);

    List<? extends JournalItemDTO> getJournalEntities(String journalId, String search);
}
