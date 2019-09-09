package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsItemDTO;
import com.github.siberianintegrationsystems.restApp.data.AnswerRepository;
import com.github.siberianintegrationsystems.restApp.data.QuestionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public SessionServiceImpl(QuestionRepository questionRepository,
        AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public List<QuestionsItemDTO> getQuestionsForNewSession() {
        return this.questionRepository.findAll()
                                      .stream()
                                      .map(question -> new QuestionsItemDTO(question,
                                          answerRepository.findAllByQuestion(question)))
                                      .collect(Collectors.toList());
    }
}
