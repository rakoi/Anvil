package com.anvil.rakoi.anvil.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity
@Table(name = "expenses")
@JsonIgnoreProperties({"trip","Expense"})
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;



    @ManyToOne
    @JoinColumn(name="trip_id")
    public Trip trip;


    public String description;
    public String cost;
    public String timestamp;

    @JoinColumn(name="expense_id")
    @ManyToOne
    public Expense Expense;

    public Expenses() {
    }

    public Expenses(int id, Trip trip, String description, String cost, String timestamp) {
        this.id = id;
        this.trip = trip;
        this.description = description;
        this.cost = cost;
        this.timestamp = timestamp;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public com.anvil.rakoi.anvil.entities.Expense getExpense() {
        return Expense;
    }

    public void setExpense(com.anvil.rakoi.anvil.entities.Expense expense) {
        Expense = expense;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", trip=" + trip +
                ", description='" + description + '\'' +
                ", cost='" + cost + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", Expense=" + Expense +
                '}';
    }
}
