package bank.application;

import java.util.ArrayList;
import java.util.List;

import bank.entities.Account;
import bank.entities.Bank;
import bank.entities.Client;
import bank.entities.CurrentAccount;
import bank.entities.SavingsAccount;
import bank.exceptions.InvalidCpfException;
import bank.exceptions.NobalanceExceptions;

public class Main {
    public static void main(String[] args) {
    	
        Bank bank = new Bank();
        bank.setBankName("Meu Banco");
        
        System.out.println("===================================");
        System.out.println(bank.getBankName());
        System.out.println("===================================\n");
   
        // Criando clientes
    	Client client1 = new Client();
    	Client client2 = new Client();
        try {
            client1.setName("Alice");
            client1.setCpf("12345678901");
        } catch (InvalidCpfException e) {
            System.out.println("Erro ao configurar CPF do cliente: " + e.getMessage());
        }
        
        try {
	        client2.setName("Bob");
	        client2.setCpf("10987654321");
        } catch (InvalidCpfException e) {
            System.out.println("Erro ao configurar CPF do cliente: " + e.getMessage());
        }
        
        //Criando contas
        Account savingsAccount = new SavingsAccount(client1);
        Account currentAccount = new CurrentAccount(client2);
        
        savingsAccount.operationTest(null);
        currentAccount.operationTest(null);

        // Adicionando contas ao banco
        List<Account> accounts = new ArrayList<>();
        accounts.add(savingsAccount);
        accounts.add(currentAccount);

        bank.setAccount(accounts);

        // Realizando depósitos
        savingsAccount.deposit(1000.0);
        currentAccount.deposit(500.0);

        // Exibindo saldo inicial
        System.out.println("Saldo inicial da conta poupança:");
        savingsAccount.printExtractInformation();
        
        System.out.println();
        System.out.println("Saldo inicial da conta corrente:");
        currentAccount.printExtractInformation();

        // Realizando transferência
        try {
            savingsAccount.transfer(savingsAccount, currentAccount, 200.0);
        } catch (NobalanceExceptions e) {
            System.out.println("Erro ao realizar transferência: " + e.getMessage());
        }

        // Exibindo saldo final
        System.out.println();
        System.out.println("Saldo final da conta poupança:");
        savingsAccount.printExtractInformation();
        
        System.out.println();
        System.out.println("Saldo final da conta corrente:");
        currentAccount.printExtractInformation();
    }
}
