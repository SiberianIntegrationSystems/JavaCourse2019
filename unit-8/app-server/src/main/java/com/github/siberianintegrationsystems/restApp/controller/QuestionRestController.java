package com.github.siberianintegrationsystems.restApp.controller;

import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsItemDTO;
import com.github.siberianintegrationsystems.restApp.service.QuestionService;
import javax.transaction.SystemException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/question")
public class QuestionRestController {

    private final QuestionService questionService;

    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PutMapping("edit/{id}")
    public QuestionsItemDTO editQuestion(@PathVariable String id, @RequestBody QuestionsItemDTO dto)
        throws SystemException {
        return this.questionService.editQuestion(dto);
    }

    @PostMapping("create")
    public QuestionsItemDTO createQuestion(@RequestBody QuestionsItemDTO dto) {
        return this.questionService.createQuestion(dto);
    }
}
