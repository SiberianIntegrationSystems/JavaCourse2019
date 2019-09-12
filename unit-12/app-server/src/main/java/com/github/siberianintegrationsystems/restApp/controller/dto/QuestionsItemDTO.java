package com.github.siberianintegrationsystems.restApp.controller.dto;

import com.github.siberianintegrationsystems.restApp.entity.Answer;
import com.github.siberianintegrationsystems.restApp.entity.Question;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionsItemDTO extends JournalItemDTO {
    public String name;
    public List<AnswerItemDTO> answers;

    public QuestionsItemDTO() {

    }

    public QuestionsItemDTO(Question question, List<Answer> answers) {
        this.id = question.getId().toString();
        this.name = question.getName();
        this.answers = answers.stream()
                .map(AnswerItemDTO::new)
                .collect(Collectors.toList());
    }
}
