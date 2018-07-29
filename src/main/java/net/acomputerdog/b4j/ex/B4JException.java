package net.acomputerdog.b4j.ex;

public class B4JException extends RuntimeException {
    public B4JException() {
        super();
    }

    public B4JException(String message) {
        super(message);
    }

    public B4JException(String message, Throwable cause) {
        super(message, cause);
    }

    public B4JException(Throwable cause) {
        super(cause);
    }
}
