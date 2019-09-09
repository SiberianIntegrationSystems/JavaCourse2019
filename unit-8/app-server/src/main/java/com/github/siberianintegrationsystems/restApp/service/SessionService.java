package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsItemDTO;
import java.util.List;

public interface SessionService {

    List<QuestionsItemDTO> getQuestionsForNewSession();
}
