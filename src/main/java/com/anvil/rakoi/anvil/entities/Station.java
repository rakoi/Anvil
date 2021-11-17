package com.anvil.rakoi.anvil.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Station {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @OneToMany(mappedBy="station")
    private Set<User> User;



    @JsonIgnore
    @OneToMany(mappedBy= "origin",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<Parcel> parcel=new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy= "destination",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<Parcel> destination=new HashSet<>();


    public Station() {
    }

   





    public void setId(int id) {
        this.id = id;
    }

 
 
 

  
  
  

    public void setName(String name) {
        this.name = name;
    }

    public Station(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String name;


}
