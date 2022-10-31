package org.polytech.toeic.repository;

import org.polytech.toeic.entity.Question;
import org.polytech.toeic.entity.ToeicUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question,Integer> {
    List<Question> findAll();
    Question findById(int id);


    List<Question> findBySetId(int setId);
}
