package Exceptions;

public class BadPosition extends RuntimeException {
    public BadPosition(String msg) {
        super(msg);
    }
}
