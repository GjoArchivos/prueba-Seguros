package consulta_seguros.mso_es_consulta_seguros_v1.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -5703827690791495626L;

	public BadRequestException(String message) {
        super(message);
    }
}
