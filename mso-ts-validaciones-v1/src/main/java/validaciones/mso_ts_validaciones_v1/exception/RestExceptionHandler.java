package validaciones.mso_ts_validaciones_v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import validaciones.mso_ts_validaciones_v1.dto.ResponseValidacionDTO;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ResponseValidacionDTO> handleUnauthorized(UnauthorizedException ex) {
        ResponseValidacionDTO resp = new ResponseValidacionDTO();
        resp.setCodigo("01");
        resp.setMensaje(ex.getMessage());
        resp.setEsElegible(false);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resp); // 401
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseValidacionDTO> handleBadRequest(BadRequestException ex) {
        ResponseValidacionDTO resp = new ResponseValidacionDTO();
        resp.setCodigo("02");
        resp.setMensaje(ex.getMessage());
        resp.setEsElegible(false);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp); // 400
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseValidacionDTO> handleValidation(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        ResponseValidacionDTO resp = new ResponseValidacionDTO();
        resp.setCodigo("03");
        resp.setMensaje(msg);
        resp.setEsElegible(false);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }
}
