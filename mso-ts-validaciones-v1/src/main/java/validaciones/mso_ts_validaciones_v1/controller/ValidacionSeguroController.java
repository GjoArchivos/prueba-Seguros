package validaciones.mso_ts_validaciones_v1.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import validaciones.mso_ts_validaciones_v1.dto.RequestValidacionDTO;
import validaciones.mso_ts_validaciones_v1.dto.ResponseValidacionDTO;
import validaciones.mso_ts_validaciones_v1.service.ValidacionSeguroService;

@RestController
@RequestMapping("/api/v1/validaciones")
public class ValidacionSeguroController {

	private final ValidacionSeguroService service;

    public ValidacionSeguroController(ValidacionSeguroService service) {
        this.service = service;
    }

    @PostMapping("/seguros")
    public ResponseEntity<ResponseValidacionDTO> validarSeguro(
            @Valid @RequestBody RequestValidacionDTO request) throws BadRequestException {

        ResponseValidacionDTO resp = service.validar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}