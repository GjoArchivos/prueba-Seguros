package consulta_seguros.mso_es_consulta_seguros_v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import consulta_seguros.mso_es_consulta_seguros_v1.dto.ResponseSeguroDTO;

import java.util.Collections;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseSeguroDTO> handleBadRequest(BadRequestException ex) {
        ResponseSeguroDTO response = new ResponseSeguroDTO();
        response.setCodigo("01");
        response.setMensaje(ex.getMessage());
        response.setSeguros(Collections.emptyList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // 400
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseSeguroDTO> handleNotFound(NotFoundException ex) {
        ResponseSeguroDTO response = new ResponseSeguroDTO();
        response.setCodigo("04");
        response.setMensaje(ex.getMessage());
        response.setSeguros(Collections.emptyList());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // 404
    }
}