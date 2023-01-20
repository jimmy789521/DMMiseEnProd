package org.polytech.toeic.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "thread")
public class Thread {

    @Id
    @GeneratedValue
    @Column(name = "thread_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    //Utilisateur créateur du thread
    private ToeicUser userId;
    //Main subject of the thread main message
    public String content;

    public ToeicUser getUserId() {
        return userId;
    }

    public void setUserId(ToeicUser userId) {
        this.userId = userId;
    }

    @OneToMany
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}