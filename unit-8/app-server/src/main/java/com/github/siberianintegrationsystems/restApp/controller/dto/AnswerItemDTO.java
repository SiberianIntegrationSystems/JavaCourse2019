package com.github.siberianintegrationsystems.restApp.controller.dto;

public class AnswerItemDTO {
    public String answerText;
    public boolean isCorrect;

    public AnswerItemDTO(String answerText, boolean isCorrect) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }
}
