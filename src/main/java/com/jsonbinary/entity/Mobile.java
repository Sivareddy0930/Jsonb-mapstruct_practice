package com.jsonbinary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Mobile {
    private Long personalNumber;
    private Long workNumber;

    public Mobile(Long personalNumber, Long workNumber) {
        this.personalNumber = personalNumber;
        this.workNumber = workNumber;
    }

    public Long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Long getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(Long workNumber) {
        this.workNumber = workNumber;
    }
}
