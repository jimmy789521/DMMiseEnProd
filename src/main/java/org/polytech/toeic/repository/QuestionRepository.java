package org.polytech.toeic.repository;

import org.polytech.toeic.entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends CrudRepository<Question,Integer> {
    List<Question> findAll();
    Optional<Question> findById(int id);

    List<Question> findAllBySet(int setId);

}
