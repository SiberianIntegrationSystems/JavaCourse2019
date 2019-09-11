package com.github.siberianintegrationsystems.restApp.controller.dto;

import com.github.siberianintegrationsystems.restApp.entity.Answer;

public class AnswerItemDTO {

    public String id;
    public String answerText;
    public boolean isCorrect;

    public AnswerItemDTO() {

    }

    public AnswerItemDTO(Answer answer) {
        if (answer != null) {
            this.id = answer.getId().toString();
            this.answerText = answer.getName();
            this.isCorrect = answer.getCorrect();
        }
    }
}
