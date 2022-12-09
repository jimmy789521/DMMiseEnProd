package org.polytech.toeic.controller.accessible;


import org.polytech.toeic.entity.Message;
import org.polytech.toeic.service.MessageService;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/addMessage")
    public Message addMessage(@RequestBody Message message)
    {
        return messageService.addMessage(message);
    }
    @PutMapping("/message")
    public void updateMessage(@RequestBody Message message)
    {
        messageService.UpdateMessage(message);
    }
    @DeleteMapping("/deleteMessage/{id}")
    public void deleteMessage(@PathVariable int id)
    {
        messageService.DeleteById(id);
    }




}
