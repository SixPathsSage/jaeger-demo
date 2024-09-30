package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String holderName;

    public Account() {
    }

    public Account(Long id, String holderName) {
        this.id = id;
        this.holderName = holderName;
    }

    public Long getId() {
        return id;
    }

    public Account setId(Long id) {
        this.id = id;
        return this;
    }

    public String getHolderName() {
        return holderName;
    }

    public Account setHolderName(String holderName) {
        this.holderName = holderName;
        return this;
    }
}
