package bank.entities;

import bank.exceptions.NobalanceExceptions;

public class CurrentAccount extends Account{
	
	private static final double TAX = 0.025;
	
	private String accountType = "Current Account";
	
	@Override
	public int operationTest(String accountType) {
		accountType = this.accountType;
		return super.operationTest(accountType);
	}

	public CurrentAccount(Client client) {
		super(client);
	}
	
	@Override
	public void transfer(Account originAccount, Account destinyAccount, double value) throws NobalanceExceptions {
		originAccount.withdraw(value*TAX);
		super.transfer(originAccount, destinyAccount, value);
	}

	@Override
	public void printExtractInformation() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.printExtractInformation();
	}
		
}