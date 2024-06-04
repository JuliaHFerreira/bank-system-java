package bank.entities;

import bank.exceptions.NobalanceExceptions;

public class SavingsAccount extends Account{
	
	private String accountType = "Savings Account";
	
	@Override
	public int operationTest(String accountType) {
		accountType = this.accountType;
		return super.operationTest(accountType);
	}
	
	public SavingsAccount(Client client) {
		super(client);
	}
	
	@Override
	public void transfer(Account originAccount, Account destinyAccount, double value) throws NobalanceExceptions {
		value = value + (value*0.015); //tax
		super.transfer(originAccount, destinyAccount, value);
	}

	@Override
	public void printExtractInformation() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.printExtractInformation();
	}
}
