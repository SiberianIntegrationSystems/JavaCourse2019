package com.github.siberianintegrationsystems.restApp.controller.dto;

public class QuestionsItemDTO extends JournalItemDTO {
    public String name;
    public int answersCount;

    public QuestionsItemDTO(String id, String name, int answersCount) {
        this.id = id;
        this.name = name;
        this.answersCount = answersCount;
    }
}
