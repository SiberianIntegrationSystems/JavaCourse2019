package com.github.siberianintegrationsystems.restApp.controller.dto;


import java.util.List;

public class QuestionsItemDTO extends JournalItemDTO {
    public String name;
    public int answersCount;
    public List<Answer> answers;

    public QuestionsItemDTO(String id, String name, int answersCount, List<Answer> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
        this.answersCount = answersCount;
    }
}
