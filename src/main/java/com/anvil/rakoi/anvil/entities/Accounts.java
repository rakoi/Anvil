package com.anvil.rakoi.anvil.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Accounts {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;
    public String name;
    public String acc;





    @OneToMany(mappedBy="account")
    private Set<Journal> journals;

    public Accounts() {
    }

    public Accounts(int id, String name, String acc, Set<Journal> journals) {
        this.id = id;
        this.name = name;
        this.acc = acc;
        this.journals = journals;
    }

    public Accounts(String name, String acc) {
        this.name = name;
        this.acc = acc;
    }

    public Accounts(int id, String name, String acc) {
        this.id = id;
        this.name = name;
        this.acc = acc;
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

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public Set<Journal> getJournals() {
        return journals;
    }

    public void setJournals(Set<Journal> journals) {
        this.journals = journals;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", acc='" + acc + '\'' +
                '}';
    }
}
