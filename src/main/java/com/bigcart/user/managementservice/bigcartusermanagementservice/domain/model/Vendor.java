package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String userName;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    private boolean isApproved;

    @OneToOne
    @JoinColumn(name="person_id")
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
