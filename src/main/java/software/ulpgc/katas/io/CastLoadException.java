package software.ulpgc.katas.io;

public class CastLoadException extends RuntimeException {
    public CastLoadException(String message) {
        super(message);
    }

    public CastLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}