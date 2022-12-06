package org.polytech.toeic.controller.admin;


import org.polytech.toeic.entity.Question;
import org.polytech.toeic.entity.ToeicUser;
import org.polytech.toeic.service.QuestionService;
import org.polytech.toeic.service.ToeicUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/admin")

public class AdminQuestionController {
    QuestionService questionService;

    public AdminQuestionController(QuestionService questionService)
    {
        this.questionService = questionService;
    }

        @PostMapping("question")
        public void addQuestion(@RequestBody Question question)
        {
            questionService.addQuestion(question);
        }

        @DeleteMapping("deletequestion/{id}")
        public void deleteUser(@PathVariable int id)
        {
            Optional<Question> question = questionService.getQuestionById(id);
            questionService.deleteQuestion(question.get());
        }
}

