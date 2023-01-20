package org.polytech.toeic.controller.accessible;


import org.polytech.toeic.entity.Question;
import org.polytech.toeic.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class QuestionController {

    private final QuestionService questionService;
    public QuestionController(QuestionService questionService)
    {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<Question> getAllQurstions()
    {
        return questionService.findAll();
    }
    @GetMapping("/question/set/{setId}")
    public List<Question> getQuestionBySet(@PathVariable int setId)
    {
        return questionService.getIdBySet(setId);
    }
    @GetMapping("/question/{id}")
    public Optional<Question> getQuestionById(@PathVariable int id)
    {
        return questionService.getQuestionById(id);
    }




}
