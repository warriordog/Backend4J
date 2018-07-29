package net.acomputerdog.b4j.ex;

public class HTTPServerException extends RuntimeException {
    public HTTPServerException() {
        super();
    }

    public HTTPServerException(String message) {
        super(message);
    }

    public HTTPServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public HTTPServerException(Throwable cause) {
        super(cause);
    }
}
