package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsItemDTO;

public interface QuestionService {
    QuestionsItemDTO createQuestion(QuestionsItemDTO dto);
}
