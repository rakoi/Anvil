package com.anvil.rakoi.anvil.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Journal {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;


    public double credit;


    public double debit;

    public Journal() {
    }

    @ManyToOne
    @JoinColumn(name="parcel_id", nullable=false)
    private Parcel parcel;

    @ManyToOne
    @JoinColumn(name="expense_id", nullable=false)
    private Expense expense;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    @JsonIgnoreProperties("journals")
    private Accounts account;


    public Journal(int id, double debit, Parcel parcel) {
        this.id = id;
        this.debit = debit;
        this.parcel = parcel;
    }



    public Journal(int id, double credit, double debit, Parcel parcel) {
        this.id = id;
        this.credit = credit;
        this.debit = debit;
        this.parcel = parcel;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    /*  public Accounts account;

    public Parcel parcel;

    public Expense expense;*/

}
