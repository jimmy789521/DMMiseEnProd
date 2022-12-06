package org.polytech.toeic.repository;

import org.polytech.toeic.entity.Set;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SetRepository extends CrudRepository<Set,Integer> {

    public List<Set> findAll();
}
