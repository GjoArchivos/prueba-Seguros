package validaciones.mso_ts_validaciones_v1.dto;

import java.util.List;

public class ResponseSeguroDTO {
	
	private String codigo;
    private String mensaje;
    private List<SeguroDTO> seguros;
    
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<SeguroDTO> getSeguros() {
		return seguros;
	}
	public void setSeguros(List<SeguroDTO> seguros) {
		this.seguros = seguros;
	}
    
    

}
