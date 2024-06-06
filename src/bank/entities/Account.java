package bank.entities;

import bank.exceptions.NobalanceExceptions;

public abstract class Account{
	
	private static final int AGENCY_NUMBER = 202;
	private static int NUMBER_ACCOUNT_GENERATED = 1000001;
	
	private int agency;
	private int numberAccount;
	private String accountType;
	private int operation;
	private double balance;
	private Client client;
	
	public Account(Client client) {
		this.agency = Account.AGENCY_NUMBER;
		this.numberAccount = NUMBER_ACCOUNT_GENERATED++;
		this.operation = operationTest(accountType);
		this.client = client;
	}
			
	public int operationTest(String accountType) {
		this.accountType = accountType;
		if(accountType == "Savings Account") {
			return operation = 321;
		}
		else if(accountType == "Current Account"){
			return operation = 123;
		}
		return 0;
	}
	
	//operações de conta
	
	public void withdraw(double balanceWith) throws NobalanceExceptions {
		if (this.balance >= balanceWith) {
			this.balance -= balanceWith; 
		}
		else {
        	throw new NobalanceExceptions();
		}
	}
	
	public void deposit(double balanceDeposit) {
		this.balance += balanceDeposit; 
	}
 
	public void transfer(Account originAccount, Account destinyAccount, double value) throws NobalanceExceptions {
        if (originAccount.getBalance() >= value) {
        	originAccount.withdraw(value);
        	destinyAccount.deposit(value);
        	System.out.println();
            System.out.println("===Transferência realizada com sucesso!===");
        } else {
        	throw new NobalanceExceptions();
        }
    }
	
	//gets
	
	public Double getBalance() {
		return balance;
	}
	
	public static int getAgencyNumber() {
		return AGENCY_NUMBER;
	}

	public static int getNUMBER_ACCOUNT_GENERATED() {
		return NUMBER_ACCOUNT_GENERATED;
	}

	public int getAgency() {
		return agency;
	}

	public int getNumberAccount() {
		return numberAccount;
	}

	public int getOperation() {
		return operation;
	}

	public Client getClient() {
		return client;
	}
	
	public void printExtractInformation() {
		System.out.println(String.format("Titular: %s", this.client.getName()));
		System.out.println(String.format("CPF: %s", this.client.getCpf()));
		System.out.println(String.format("Operação: %d", this.operation));
		System.out.println(String.format("Agencia: %d", this.agency));
		System.out.println(String.format("Numero: %d", this.numberAccount));
		System.out.println(String.format("Saldo: %.2f", this.balance));
	}
}
