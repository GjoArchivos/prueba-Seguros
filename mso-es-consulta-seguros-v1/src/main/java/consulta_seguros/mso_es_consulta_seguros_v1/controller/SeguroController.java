package consulta_seguros.mso_es_consulta_seguros_v1.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import consulta_seguros.mso_es_consulta_seguros_v1.dto.ResponseSeguroDTO;
import consulta_seguros.mso_es_consulta_seguros_v1.dto.SeguroDTO;
import consulta_seguros.mso_es_consulta_seguros_v1.exception.BadRequestException;
import consulta_seguros.mso_es_consulta_seguros_v1.exception.NotFoundException;
import consulta_seguros.mso_es_consulta_seguros_v1.service.SeguroService;

@RestController
@RequestMapping("/api/v1/seguros")
public class SeguroController {

    private final SeguroService seguroService;

    public SeguroController(SeguroService seguroService) {
        this.seguroService = seguroService;
    }

    // GET /api/v1/seguros?idSeguro=1  (query param)
    @GetMapping
    public ResponseEntity<ResponseSeguroDTO> consultarSeguros(
            @RequestParam(value = "idSeguro", required = false) Integer idSeguro) {

        ResponseSeguroDTO response = new ResponseSeguroDTO();

        if (idSeguro == null) {
            List<SeguroDTO> lista = seguroService.getAll();
            response.setCodigo("00");
            response.setMensaje("Consulta exitosa");
            response.setSeguros(lista);
            return ResponseEntity.ok(response);
        } else if (idSeguro <= 0) {
            throw new BadRequestException("El idSeguro debe ser mayor a cero.");
        } else {
            SeguroDTO seguro = seguroService.getById(idSeguro)
                    .orElseThrow(() -> new NotFoundException("No se encontró el seguro con id " + idSeguro));

            response.setCodigo("00");
            response.setMensaje("Consulta exitosa");
            response.setSeguros(Collections.singletonList(seguro));
            return ResponseEntity.ok(response);
        }
    }
}
