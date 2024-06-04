package bank.exceptions;

public class InvalidCpfException extends Exception {

    public InvalidCpfException() {
        super("CPF inválido. Deve conter exatamente 11 dígitos.");
    }

    public InvalidCpfException(String message) {
        super(message);
    }

    public InvalidCpfException(String message, Throwable cause) {
        super(message, cause);
    }
}
