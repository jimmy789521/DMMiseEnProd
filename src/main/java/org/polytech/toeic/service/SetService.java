package org.polytech.toeic.service;

import org.polytech.toeic.entity.Question;
import org.polytech.toeic.entity.Set;
import org.polytech.toeic.entity.Thread;
import org.polytech.toeic.repository.SetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetService {

    private final SetRepository setRepository;

    public SetService(SetRepository setRepository)
    {
        this.setRepository = setRepository;
    }

    public Set AddSet(Set set)
    {
        setRepository.save(set);
        return set;
    }
    public List<Set> findAll()
    {
        return setRepository.findAll();
    }


}
