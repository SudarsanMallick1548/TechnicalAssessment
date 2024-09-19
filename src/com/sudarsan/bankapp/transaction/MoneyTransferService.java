package com.sudarsan.bankapp.transaction;

import com.sudarsan.bankapp.model.Account;

/**
 * @Sudarsan Mallick MoneyTransferService Class:- The MoneyTransferService class
 *           is responsible for transferring money between accounts. .
 */
public class MoneyTransferService {
	// Method to transfer funds
	public void transfer(Account from, Account to, int amount) {
		// Ensure amount is non-negative
		if (amount < 0) {
			throw new IllegalArgumentException("Transfer amount must be non-negative.");
		}

		// Check for sufficient balance in the 'from' account
		if (from.getBalance() < amount) {
			throw new IllegalArgumentException("Insufficient funds for transfer.");
		}

		// Ensure consistent locking order to avoid deadlock
		Account firstLock, secondLock;
		if (System.identityHashCode(from) < System.identityHashCode(to)) {
			firstLock = from;
			secondLock = to;
		} else {
			firstLock = to;
			secondLock = from;
		}

		// Lock accounts and perform the transfer
		synchronized (firstLock) {
			synchronized (secondLock) {
				from.debit(amount);
				to.credit(amount);
			}
		}
	}
}
