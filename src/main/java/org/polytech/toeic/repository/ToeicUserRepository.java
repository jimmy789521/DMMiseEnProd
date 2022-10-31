package org.polytech.toeic.repository;

import org.polytech.toeic.entity.ToeicUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToeicUserRepository extends CrudRepository<ToeicUser,Integer> {

    List<ToeicUser> findAll();

}
