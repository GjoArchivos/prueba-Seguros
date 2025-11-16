package validaciones.mso_ts_validaciones_v1.exception;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
