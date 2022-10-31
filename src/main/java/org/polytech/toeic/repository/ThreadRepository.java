package org.polytech.toeic.repository;

import org.polytech.toeic.entity.Thread;
import org.polytech.toeic.entity.ToeicUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ThreadRepository extends CrudRepository<Thread,Integer> {

    public List<Thread> findAll();

    public Thread findById(int id);

    public List<Thread> findByUserId(Optional<ToeicUser> user);

    //retourne tous les threads dont le titre contient le mot recherché dans la barre de recherche
    public List<Thread> findByContentContains(String keyword);

}
