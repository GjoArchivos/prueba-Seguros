package validaciones.mso_ts_validaciones_v1.exception;

@SuppressWarnings("serial")
public class UnauthorizedException extends RuntimeException {


	public UnauthorizedException(String message) {
        super(message);
    }
}