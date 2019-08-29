package com.github.siberianintegrationsystems.restApp.controller;

import com.github.siberianintegrationsystems.restApp.controller.dto.JournalEntityDTO;
import com.github.siberianintegrationsystems.restApp.controller.dto.JournalRequestDTO;
import com.github.siberianintegrationsystems.restApp.controller.dto.JournalResultDTO;
import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsItemDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/journal")
public class JournalRestController {

    private final String QUESTIONS_JOURNAL_ID = "questions";

    private final List<JournalEntityDTO> journals = Arrays.asList(
            new JournalEntityDTO(QUESTIONS_JOURNAL_ID, "Вопросы", 15)
    );

    private final List<QuestionsItemDTO> questions = Arrays.asList(
            new QuestionsItemDTO("1", "Сколько было назгулов?", 5),
            new QuestionsItemDTO("2", "Какой ответ на вопрос жизни вселенной и всего остального?", 4),
            new QuestionsItemDTO("3", "Кто написал картину \"Мона Лиза\"?", 4),
            new QuestionsItemDTO("4", "Какое первое правило бойцовского клуба?", 2),
            new QuestionsItemDTO("5", "Как звали наставника главного героя в фильме \"Матрица\"?", 2),
            new QuestionsItemDTO("6", "Что пытался вернуть герой фильма \"Большой Лебовски\"?", 3),
            new QuestionsItemDTO("7", "Какова температура горения бумаги? Такое же название носит роман Рэя Бредбери", 4),
            new QuestionsItemDTO("8", "С каким русским царем Иван Васильевич поменялся профессией?", 3),
            new QuestionsItemDTO("9", "Как звали главного злодея в оригинальной трилогии \"Звездные войны\"?", 2),
            new QuestionsItemDTO("10", "Как назывался парк, в котором поселили клонированных динозавров?", 2)
    );

    @GetMapping("{id}")
    public JournalEntityDTO getJournalEntity(@PathVariable String id){
        System.out.println("Журнал = " + id);
        return journals.get(0);
    }

    @PutMapping("{id}/rows")
    public JournalResultDTO getRows(@PathVariable String id,
                                    @RequestBody JournalRequestDTO req) {
        List<QuestionsItemDTO> collect = this.questions
                .stream()
                .filter(dto -> dto.name.contains(req.search))
                .collect(Collectors.toList());

        return new JournalResultDTO(collect.size(), collect);
    }
}
