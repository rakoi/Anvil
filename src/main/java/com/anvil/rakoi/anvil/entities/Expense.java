package com.anvil.rakoi.anvil.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String name;
	public String description;


	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "Expense")

	public Set<Expenses> expenses=new HashSet<>();


	@OneToMany(mappedBy="expense")
	@JsonIgnoreProperties("journalEntry")
	private Set<Journal> journalEntry;


	public Expense(int id, String name, String description, Set<Expenses> expenses) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.expenses = expenses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Expense(String description, Set<Expenses> expenses) {
		this.description = description;


		this.expenses = expenses;
	}

	public Expense(int id, String description, Set<Expenses> expenses) {
		this.id = id;
		this.description = description;


		this.expenses = expenses;
	}

	public Expense() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}




	public Set<Expenses> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expenses> expenses) {
		this.expenses = expenses;
	}

	public Set<Journal> getJournalEntry() {
		return journalEntry;
	}

	public void setJournalEntry(Set<Journal> journalEntry) {
		this.journalEntry = journalEntry;
	}
}
