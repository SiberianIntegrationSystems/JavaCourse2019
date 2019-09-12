package com.github.siberianintegrationsystems.restApp.controller.dto;

import com.github.siberianintegrationsystems.restApp.entity.Answer;

public class AnswerItemDTO {
    public String id;
    public String answerText;
    public Boolean isCorrect;

    public AnswerItemDTO() {

    }

    public AnswerItemDTO(Answer answer) {
        id = answer.getId().toString();
        answerText = answer.getName();
        isCorrect = answer.getCorrect();
    }
}
