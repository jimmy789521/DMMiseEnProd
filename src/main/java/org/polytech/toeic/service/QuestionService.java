package org.polytech.toeic.service;

import org.polytech.toeic.entity.Question;
import org.polytech.toeic.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService
{
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository)
    {
        this.questionRepository = questionRepository;
    }


    public Question getQuestionById(int id)
    {
        return questionRepository.findById(id);
    }

    //Toutes les questions d'un set de questions
    public List<Question> getIdBySet(int setId)
    {
        if(setId==0)
        {
            return questionRepository.findAll();
        }
        else
        {
            return questionRepository.findBySetId(setId);
        }
    }
}
