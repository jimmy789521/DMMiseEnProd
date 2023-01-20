package org.polytech.toeic.entity;


import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue
    private int id;

    private String question;
    private String anwser;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Set set;

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAwnser() {
        return anwser;
    }

    public void setAwnser(String awnser) {
        this.anwser = awnser;
    }
}
