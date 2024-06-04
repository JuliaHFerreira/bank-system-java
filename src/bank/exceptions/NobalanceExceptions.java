package bank.exceptions;

public class NobalanceExceptions extends Exception {

    public NobalanceExceptions() {
        super("Saldo insuficiente para realizar a operação.");
    }

    public NobalanceExceptions(String message) {
        super(message);
    }

    public NobalanceExceptions(String message, Throwable cause) {
        super(message, cause);
    }

}
