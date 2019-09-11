package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.AnswerItemDTO;
import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsItemDTO;
import com.github.siberianintegrationsystems.restApp.data.AnswerRepository;
import com.github.siberianintegrationsystems.restApp.data.QuestionRepository;
import com.github.siberianintegrationsystems.restApp.entity.Answer;
import com.github.siberianintegrationsystems.restApp.entity.Question;
import java.util.List;
import javax.transaction.SystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository,
        AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public QuestionsItemDTO createQuestion(QuestionsItemDTO dto) {
        Question question = new Question();
        question.setName(dto.name);
        questionRepository.save(question);

        saveAnswerList(question, dto.answers);

        return new QuestionsItemDTO(question, answerRepository.findAllByQuestion(question));
    }

    @Override
    public QuestionsItemDTO editQuestion(QuestionsItemDTO dto) {
        Question question = this.questionRepository.findById(Long.valueOf(dto.id))
                                                   .orElseThrow(() -> new RuntimeException(
                                                       String.format("Не найден вопрос с id %s", dto.id)));

        question.setName(dto.name);
        questionRepository.save(question);

        List<Answer> oldAnswers = answerRepository.findAllByQuestion(question);
        answerRepository.deleteAll(oldAnswers);

        saveAnswerList(question, dto.answers);

        return new QuestionsItemDTO(question, answerRepository.findAllByQuestion(question));
    }

    private void saveAnswerList(Question question, List<AnswerItemDTO> answerItemDTOS) {
        for (AnswerItemDTO answerItemDTO : answerItemDTOS) {
            Answer answer = new Answer();
            answer.setQuestion(question);
            answer.setName(answerItemDTO.answerText);
            answer.setCorrect(answerItemDTO.isCorrect);
            answerRepository.save(answer);
        }
    }
}
