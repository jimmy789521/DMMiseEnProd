package org.polytech.toeic.service;

import org.polytech.toeic.entity.ToeicUser;
import org.polytech.toeic.repository.ToeicUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToeicUserService {

    private final ToeicUserRepository toeicUserRepository;

    public ToeicUserService(ToeicUserRepository toeicUserRepository)
    {
        this.toeicUserRepository = toeicUserRepository;
    }

    public List<ToeicUser> getUsers()
    {
        return toeicUserRepository.findAll();
    }

    public ToeicUser addUser(ToeicUser newUser)
    {
        toeicUserRepository.save(newUser);
        return newUser;
    }
    public void updateUser(ToeicUser user)
    {
        toeicUserRepository.save(user);
    }

    public Optional<ToeicUser> getUserById(int id) {

        return  toeicUserRepository.findById(id);
    }
}
