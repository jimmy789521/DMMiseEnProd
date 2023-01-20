package org.polytech.toeic.controller;


import org.polytech.toeic.entity.Message;
import org.polytech.toeic.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api")
public class MessageController {

    private final MessageService messageService;
    public MessageController(MessageService messageService)
    {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages()
    {
        return messageService.getAllMessage();
    }

    @GetMapping("/messages/{userId}")
    public List<Message> getAllMessagesFromUser(@PathVariable int userId)
    {
        return messageService.getMessageByUser(userId);
    }


    @GetMapping("/messages/thread/{threadId}")
    public List<Message> getAllMessagesFromThread(@PathVariable int threadId)
    {
        return messageService.getMessageByThread(threadId);
    }




}
