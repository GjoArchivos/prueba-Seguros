package validaciones.mso_ts_validaciones_v1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import validaciones.mso_ts_validaciones_v1.dto.ResponseSeguroDTO;

@FeignClient(
        name = "mso-es-consulta-seguros-v1",
        url = "${SEGURO_SERVICE_URL}"
)
public interface SeguroFeignClient {

    @GetMapping("/api/v1/seguros")
    ResponseSeguroDTO consultarSeguros(@RequestParam("idSeguro") Integer idSeguro);
}
