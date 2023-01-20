package org.polytech.toeic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "set")
public class Set {

    @Id
    @GeneratedValue
    private int set_id;

    public int getId() {
        return set_id;
    }

    public void setId(int id) {
        this.set_id = id;
    }
}
