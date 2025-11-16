package consulta_seguros.mso_es_consulta_seguros_v1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import consulta_seguros.mso_es_consulta_seguros_v1.dto.SeguroDTO;

@Service
public class SeguroService {

    private final List<SeguroDTO> seguros = new ArrayList<>();

    public SeguroService() {
        // VIDA
        SeguroDTO vida = new SeguroDTO();
        vida.setIdSeguro(1);
        vida.setNombre("VIDA");
        vida.setDescripcion("Protección económica para tu familia en caso de fallecimiento natural o accidental.");
        vida.setBeneficios("Beneficio económico para tu familia (mayor en fallecimiento accidental). Servicio funerario sin costo.");
        vida.setCostoAnual(700.0);
        vida.setEdadMinima(18);
        vida.setEdadMaxima(75);
        vida.setIdGeneroRequerido(null);

        // INFARTO
        SeguroDTO infarto = new SeguroDTO();
        infarto.setIdSeguro(2);
        infarto.setNombre("INFARTO");
        infarto.setDescripcion("Protección económica de $50,000 por la primera ocurrencia de infarto al miocardio.");
        infarto.setBeneficios("Ambulancia, consultas médicas telefónicas ilimitadas, sin exámenes médicos.");
        infarto.setCostoAnual(300.0);
        infarto.setEdadMinima(15);
        infarto.setEdadMaxima(64);
        infarto.setIdGeneroRequerido(null);

        // MUJER
        SeguroDTO mujer = new SeguroDTO();
        mujer.setIdSeguro(3);
        mujer.setNombre("MUJER");
        mujer.setDescripcion("Protección económica de $50,000 por cáncer de mama o cervicouterino.");
        mujer.setBeneficios("20 consultas psicológicas a domicilio (si hay diagnóstico), consultas telefónicas ilimitadas, sin exámenes médicos.");
        mujer.setCostoAnual(300.0);
        mujer.setEdadMinima(15);
        mujer.setEdadMaxima(64);
        mujer.setIdGeneroRequerido(2); // Mujer

        seguros.add(vida);
        seguros.add(infarto);
        seguros.add(mujer);
    }

    public List<SeguroDTO> getAll() {
        return seguros;
    }

    public Optional<SeguroDTO> getById(Integer idSeguro) {
        return seguros.stream()
                .filter(s -> s.getIdSeguro().equals(idSeguro))
                .findFirst();
    }
}