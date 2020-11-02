package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


public class VendorDTO extends PersonDTO {

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    private String companyName;

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCompanyName() { return companyName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }
}
