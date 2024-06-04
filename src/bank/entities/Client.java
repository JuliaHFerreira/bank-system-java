package bank.entities;

import bank.exceptions.InvalidCpfException;

public class Client {

	private String name;
	private String cpf;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws InvalidCpfException {
		int length = cpf.length();
		if (length != 11) {
			throw new InvalidCpfException();
		} else {
			this.cpf = cpf;
		}
	}
}