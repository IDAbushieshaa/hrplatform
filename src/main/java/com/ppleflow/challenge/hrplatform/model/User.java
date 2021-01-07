package com.ppleflow.challenge.hrplatform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private String contractDetails;
    private State state;

    public User(String name, String contractDetails, State state) {
        this.name = name;
        this.contractDetails = contractDetails;
        this.state = state;
    }

    public User() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContractDetails() {
        return contractDetails;
    }
    public void setContractDetails(String contractDetails) {
        this.contractDetails = contractDetails;
    }

    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
}
