package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsItemDTO;
import javax.transaction.SystemException;

public interface QuestionService {

    QuestionsItemDTO createQuestion(QuestionsItemDTO dto);

    QuestionsItemDTO editQuestion(QuestionsItemDTO dto) throws SystemException;
}
