package com.sudarsan.bankapp.model;

/**
 * @Sudarsan Mallick Account Class:- The Account Model class represents bank
 *           accounts. It includes fields for account balance and account ID. It
 *           provides methods for debiting and crediting money. Thread-safety
 *           must be ensured when modifying the balance
 */
public class Account {
	private int id; // Unique identifier for the account
	private int balance; // Account balance, assumed to be in cents for precision

	// Constructor to initialize account with ID and initial balance
	public Account(int id, int initialBalance) {
		this.id = id;
		this.balance = initialBalance;
	}

	// Getter for account ID
	public int getId() {
		return id;
	}

	// Getter for account balance
	public int getBalance() {
		return balance;
	}

	// Method to debit (withdraw) money from the account
	// Assumes the caller has already verified that the balance is sufficient
	public void debit(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount to debit cannot be negative.");
		}
		balance -= amount;
	}

	// Method to credit (deposit) money to the account
	public void credit(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount to credit cannot be negative.");
		}
		balance += amount;
	}
}
