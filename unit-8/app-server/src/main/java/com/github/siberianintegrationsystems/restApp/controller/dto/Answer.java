package com.github.siberianintegrationsystems.restApp.controller.dto;

public class Answer {
    public String answerText;
    public Boolean isCorrect;

    public Answer(String answerText, Boolean isCorrect) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }
}
