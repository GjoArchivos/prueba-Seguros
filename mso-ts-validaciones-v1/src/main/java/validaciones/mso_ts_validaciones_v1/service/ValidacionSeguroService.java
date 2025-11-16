package validaciones.mso_ts_validaciones_v1.service;

import java.time.LocalDate;
import java.time.Period;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import validaciones.mso_ts_validaciones_v1.client.SeguroFeignClient;
import validaciones.mso_ts_validaciones_v1.dto.RequestValidacionDTO;
import validaciones.mso_ts_validaciones_v1.dto.ResponseSeguroDTO;
import validaciones.mso_ts_validaciones_v1.dto.ResponseValidacionDTO;
import validaciones.mso_ts_validaciones_v1.dto.SeguroDTO;
import validaciones.mso_ts_validaciones_v1.exception.UnauthorizedException;

@Service
public class ValidacionSeguroService {

    private final SeguroFeignClient seguroFeignClient;

    public ValidacionSeguroService(SeguroFeignClient seguroFeignClient) {
        this.seguroFeignClient = seguroFeignClient;
    }

    public ResponseValidacionDTO validar(RequestValidacionDTO request) throws BadRequestException {

    	ResponseSeguroDTO responseSeguro = seguroFeignClient.consultarSeguros(request.getIdSeguro());

        if (responseSeguro.getSeguros() == null || responseSeguro.getSeguros().isEmpty()) {
            throw new BadRequestException("El seguro especificado no existe.");
        }

        SeguroDTO seguro = responseSeguro.getSeguros().get(0);

        int edad = calcularEdad(request.getFechaNacimiento(), LocalDate.now());

        if (edad < seguro.getEdadMinima() || edad > seguro.getEdadMaxima()) {
            throw new UnauthorizedException("No cumple con el rango de edad requerido para el seguro.");
        }

        if (seguro.getIdGeneroRequerido() != null &&
                !seguro.getIdGeneroRequerido().equals(request.getIdGenero())) {
            throw new UnauthorizedException("El seguro solo aplica para otro género.");
        }

        ResponseValidacionDTO respuesta = new ResponseValidacionDTO();
        respuesta.setCodigo("00");
        respuesta.setMensaje("El cliente cumple con los requisitos para contratar el seguro.");
        respuesta.setEsElegible(true);
        respuesta.setNombreSeguro(seguro.getNombre());
        respuesta.setCostoAnual(seguro.getCostoAnual());
        return respuesta;
    }

    private int calcularEdad(LocalDate fechaNac, LocalDate hoy) {
        return Period.between(fechaNac, hoy).getYears();
    }
}
