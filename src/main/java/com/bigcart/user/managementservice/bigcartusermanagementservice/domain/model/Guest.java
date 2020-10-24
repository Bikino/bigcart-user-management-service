package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name="person_id")
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
