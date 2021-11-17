package com.anvil.rakoi.anvil.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vehicle")
public class VehicleView {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;
    public String reg_no;
    public String make;
    public String date_assigned;

    public VehicleView(int id, String reg_no, String make) {
        this.id = id;
        this.reg_no = reg_no;
        this.make = make;
    }


    public VehicleView(int id, String reg_no, String make, String date_assigned) {
        this.id = id;
        this.reg_no = reg_no;
        this.make = make;
        this.date_assigned = date_assigned;
    }

    public VehicleView() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getDate_assigned() {
        return date_assigned;
    }

    public void setDate_assigned(String date_assigned) {
        this.date_assigned = date_assigned;
    }
}
