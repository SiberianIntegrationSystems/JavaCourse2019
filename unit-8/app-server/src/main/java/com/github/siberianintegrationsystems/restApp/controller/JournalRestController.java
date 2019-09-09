package com.github.siberianintegrationsystems.restApp.controller;

import com.github.siberianintegrationsystems.restApp.controller.dto.*;
import com.github.siberianintegrationsystems.restApp.controller.dto.session.SessionItemDTO;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/journal")
public class JournalRestController {

    private final String QUESTIONS_JOURNAL_ID = "questions";
    private final String SESSIONS_JOURNAL_ID = "sessions";

    private final List<JournalEntityDTO> journals = Arrays.asList(
            new JournalEntityDTO(QUESTIONS_JOURNAL_ID, "Вопросы", 15),
            new JournalEntityDTO(SESSIONS_JOURNAL_ID, "Сессии", 15)
    );

    private final List<QuestionsItemDTO> questions = Arrays.asList(
            new QuestionsItemDTO("1", "Сколько было назгулов?", Arrays.asList(new AnswerItemDTO("test", true))),
            new QuestionsItemDTO("2", "Какой ответ на вопрос жизни вселенной и всего остального?", Arrays.asList(new AnswerItemDTO("test", true))),
            new QuestionsItemDTO("3", "Кто написал картину \"Мона Лиза\"?", Arrays.asList(new AnswerItemDTO("test", true))),
            new QuestionsItemDTO("4", "Какое первое правило бойцовского клуба?", Arrays.asList(new AnswerItemDTO("test", true))),
            new QuestionsItemDTO("5", "Как звали наставника главного героя в фильме \"Матрица\"?", Arrays.asList(new AnswerItemDTO("test", true))),
            new QuestionsItemDTO("6", "Что пытался вернуть герой фильма \"Большой Лебовски\"?", Arrays.asList(new AnswerItemDTO("test", true))),
            new QuestionsItemDTO("7", "Какова температура горения бумаги? Такое же название носит роман Рэя Бредбери", Arrays.asList(new AnswerItemDTO("test", true))),
            new QuestionsItemDTO("8", "С каким русским царем Иван Васильевич поменялся профессией?", Arrays.asList(new AnswerItemDTO("test", true))),
            new QuestionsItemDTO("9", "Как звали главного злодея в оригинальной трилогии \"Звездные войны\"?", Arrays.asList(new AnswerItemDTO("test", true))),
            new QuestionsItemDTO("10", "Как назывался парк, в котором поселили клонированных динозавров?", Arrays.asList(new AnswerItemDTO("test", true)))
    );

    private final List<SessionItemDTO> sessions = Arrays.asList(
            new SessionItemDTO("1", "Иванов И.И.", LocalDateTime.now(), 0),
            new SessionItemDTO("2", "Сидоров А.А.", LocalDateTime.now(), 0)
    );

    @GetMapping("{id}")
    public JournalEntityDTO getJournalEntity(@PathVariable String id){
        return journals.stream().filter(dto -> dto.id.equals(id)).findFirst().get();
    }

    @PutMapping("{id}/rows")
    public JournalResultDTO getRows(@PathVariable String id,
                                    @RequestBody JournalRequestDTO req) {
        List<? extends JournalItemDTO> collection = Collections.emptyList();
        switch (id) {
            case QUESTIONS_JOURNAL_ID:
                collection = this.questions;
                break;
            case SESSIONS_JOURNAL_ID:
                collection = this.sessions;
                break;
        }

        List<? extends JournalItemDTO> collect = collection
                .stream()
                .filter(dto -> dto.name.contains(req.search))
                .collect(Collectors.toList());

        return new JournalResultDTO(collect.size(), collect);
    }
}
