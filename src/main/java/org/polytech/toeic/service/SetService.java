package org.polytech.toeic.service;

import org.polytech.toeic.repository.SetRepository;
import org.springframework.stereotype.Service;

@Service
public class SetService {

    private final SetRepository setRepository;

    public SetService(SetRepository setRepository)
    {
        this.setRepository = setRepository;
    }
}
