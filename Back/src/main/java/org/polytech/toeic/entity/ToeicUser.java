package org.polytech.toeic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="toeicuser")
public class ToeicUser {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;

    private String name;
    private String password;
    private boolean admin;

    public ToeicUser()
    {
        name = "";
        password = "";
        admin = false;
    }

    public ToeicUser(String name, String password)
    {
        this.name=name;
        this.password = password;
        admin = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
