package org.polytech.toeic.repository;

import org.polytech.toeic.entity.Message;
import org.polytech.toeic.entity.Thread;
import org.polytech.toeic.entity.ToeicUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends CrudRepository<Message,Integer> {

    List<Message> findAll();
    //retourne tous les messages d'un post

    List<Message> findByThreadId(Thread thread);

    //retourne tous les messages d'un utilisateur
    List<Message> findAllByUserId(Optional<ToeicUser> user);
}
