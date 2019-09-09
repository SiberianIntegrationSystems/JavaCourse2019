package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.JournalItemDTO;
import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsItemDTO;
import com.github.siberianintegrationsystems.restApp.data.AnswerRepository;
import com.github.siberianintegrationsystems.restApp.data.JournalRepository;
import com.github.siberianintegrationsystems.restApp.data.QuestionRepository;
import com.github.siberianintegrationsystems.restApp.entity.BaseEntity;
import com.github.siberianintegrationsystems.restApp.entity.Journal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class JournalServiceImpl implements JournalService {

    public static final String QUESTIONS_JOURNAL_ID = "questions";
    public static final String SESSIONS_JOURNAL_ID = "sessions";

    private final JournalRepository journalRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public JournalServiceImpl(JournalRepository journalRepository,
        QuestionRepository questionRepository,
        AnswerRepository answerRepository) {
        this.journalRepository = journalRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public Optional<Journal> findJournalById(String id) {
        return journalRepository.findById(id);
    }

    @Override
    public List<? extends JournalItemDTO> getJournalEntities(String journalId, String search) {
        List<? extends JournalItemDTO> collection = Collections.emptyList();
        switch (journalId) {
            case QUESTIONS_JOURNAL_ID:
                collection = convertToDTOList(search,
                    this.questionRepository::findByNameContainingIgnoreCase,
                    question -> new QuestionsItemDTO(question, answerRepository.findAllByQuestion(question)));
                break;
            case SESSIONS_JOURNAL_ID:
                //collection = this.sessions;
                break;
        }

        return collection;
    }

    private <T extends BaseEntity, U extends JournalItemDTO> List<U> convertToDTOList(String search,
        Function<String, List<T>> finder, Function<T, U> converter) {
        return finder.apply(search).stream().map(converter).collect(Collectors.toList());
    }
}
