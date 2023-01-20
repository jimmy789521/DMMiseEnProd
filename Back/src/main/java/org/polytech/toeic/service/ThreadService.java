package org.polytech.toeic.service;

import org.polytech.toeic.entity.Thread;
import org.polytech.toeic.entity.ToeicUser;
import org.polytech.toeic.repository.ThreadRepository;
import org.polytech.toeic.repository.ToeicUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThreadService {

    private final ThreadRepository threadRepository;
    private final ToeicUserRepository toeicUserRepository;

    public ThreadService(ThreadRepository threadRepository , ToeicUserRepository toeicUserRepository)
    {
        this.threadRepository = threadRepository;
        this.toeicUserRepository = toeicUserRepository;
    }

    //Retourne tous les topics d'un utilisateur
    public List<Thread> AllUserThreads(Integer userId)
    {
        if(userId != null)
        {
            Optional<ToeicUser> user = toeicUserRepository.findById(userId);
            if(user.get() ==null)
            {
                return threadRepository.findAll();
            }
            else
            {
                return threadRepository.findByUserId(user);
            }

        }
        else {
            return  threadRepository.findAll();

        }

    }
    public List<Thread> ThreadByKeyword(String keyword)
    {
        return threadRepository.findByContentContains(keyword);
    }


    public Thread ThreadById(int id)
    {
        return threadRepository.findById(id);
    }

    public Thread AddThread(Thread t)
    {
        threadRepository.save(t);
        return t;
    }

    public void UpdateThread(Thread t )
    {
        threadRepository.save(t);
    }
    public void Delete(Thread t)
    {
        threadRepository.delete(t);
    }





}