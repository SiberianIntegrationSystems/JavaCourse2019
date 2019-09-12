package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.JournalItemDTO;
import com.github.siberianintegrationsystems.restApp.controller.dto.JournalRequestDTO;
import com.github.siberianintegrationsystems.restApp.entity.Journal;

import java.util.List;

public interface JournalService {
    Journal getJournal(String id);

    List<? extends JournalItemDTO> getJournalRows(String id, JournalRequestDTO req);
}
