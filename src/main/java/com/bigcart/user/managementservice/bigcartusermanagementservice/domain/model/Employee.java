package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
public class Employee extends Person{

    private String userName;

    private String password;

    private String payrollNumber;

    private boolean isApproved;

    private boolean isAdmin;

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

    public String getPayrollNumber() {
        return payrollNumber;
    }

    public void setPayrollNumber(String payrollNumber) {
        this.payrollNumber = payrollNumber;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
