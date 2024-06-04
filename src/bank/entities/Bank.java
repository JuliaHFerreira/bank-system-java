package bank.entities;

import java.util.List;

public class Bank {
	
	private String bankName;
	private List<Account> accounts;
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public List<Account> getAccounts(){
		return accounts;
	}
	
	public void setAccount(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
