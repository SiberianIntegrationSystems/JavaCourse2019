package com.github.siberianintegrationsystems.restApp.controller.dto;

import java.util.List;

public class QuestionsItemDTO extends JournalItemDTO {

    public List<AnswerItemDTO> answers;

    public QuestionsItemDTO(String id, String name, List<AnswerItemDTO> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }
}
