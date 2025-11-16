package validaciones.mso_ts_validaciones_v1.dto;

public class ResponseValidacionDTO {

	private String codigo;      
    private String mensaje;    
    private Boolean esElegible; 
    private String nombreSeguro;
    private Double costoAnual;
    
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
	public Boolean getEsElegible() {
		return esElegible;
	}
	public void setEsElegible(Boolean esElegible) {
		this.esElegible = esElegible;
	}
	public String getNombreSeguro() {
		return nombreSeguro;
	}
	public void setNombreSeguro(String nombreSeguro) {
		this.nombreSeguro = nombreSeguro;
	}
	public Double getCostoAnual() {
		return costoAnual;
	}
	public void setCostoAnual(Double costoAnual) {
		this.costoAnual = costoAnual;
	}
    
    
}
