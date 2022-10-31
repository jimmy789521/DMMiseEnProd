package org.polytech.toeic.controller;


import org.polytech.toeic.entity.Question;
import org.polytech.toeic.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class QuestionController {

    private final QuestionService questionService;
    public QuestionController(QuestionService questionService)
    {
        this.questionService = questionService;
    }


    @GetMapping("/questions")
    public List<Question> getQuestionBySet(@RequestParam(required = false) int setId)
    {
        return questionService.getIdBySet(setId);
    }
    @GetMapping("/question")
    public Question getQuestionById(@RequestParam int id)
    {
        return questionService.getQuestionById(id);
    }


}
