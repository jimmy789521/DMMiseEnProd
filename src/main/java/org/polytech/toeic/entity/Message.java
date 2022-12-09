package org.polytech.toeic.entity;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue
    private int id;

    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private ToeicUser userId;
    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Thread threadId;

    public Thread getThreadId() {
        return threadId;
    }

    public void setThreadId(Thread threadId) {
        this.threadId = threadId;
    }

    public ToeicUser getUserId() {
        return userId;
    }

    public void setUserId(ToeicUser userId) {
        this.userId = userId;
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
