package com.sudarsan.bankapp.transaction;

import com.sudarsan.bankapp.model.Account;

/**
 * @Sudarsan Mallick MoneyTransferMain Class:- The MoneyTransferMain class is
 *           responsible for testing transferring money between accounts. .
 */
public class MoneyTransferMain {
	public static void main(String[] args) {
		// Create two accounts
		Account account1 = new Account(1, 1000);
		Account account2 = new Account(2, 500);

		// Print initial balances
		System.out.println("Account 1 balance: " + account1.getBalance());
		System.out.println("Account 2 balance: " + account2.getBalance());

		// Transfer some money (using the MoneyTransferService from the earlier example)
		MoneyTransferService service = new MoneyTransferService();
		service.transfer(account1, account2, 300);

		// Print updated balances
		System.out.println("Account 1 balance after transfer: " + account1.getBalance());
		System.out.println("Account 2 balance after transfer: " + account2.getBalance());
	}
}
