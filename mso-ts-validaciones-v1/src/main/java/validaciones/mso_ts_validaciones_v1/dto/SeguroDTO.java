package validaciones.mso_ts_validaciones_v1.dto;

public class SeguroDTO {
	private Integer idSeguro;
    private String nombre;
    private String descripcion;
    private String beneficios;
    private Double costoAnual;
    private Integer edadMinima;
    private Integer edadMaxima;
    private Integer idGeneroRequerido;
    
    
	public Integer getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(Integer idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}
	public Double getCostoAnual() {
		return costoAnual;
	}
	public void setCostoAnual(Double costoAnual) {
		this.costoAnual = costoAnual;
	}
	public Integer getEdadMinima() {
		return edadMinima;
	}
	public void setEdadMinima(Integer edadMinima) {
		this.edadMinima = edadMinima;
	}
	public Integer getEdadMaxima() {
		return edadMaxima;
	}
	public void setEdadMaxima(Integer edadMaxima) {
		this.edadMaxima = edadMaxima;
	}
	public Integer getIdGeneroRequerido() {
		return idGeneroRequerido;
	}
	public void setIdGeneroRequerido(Integer idGeneroRequerido) {
		this.idGeneroRequerido = idGeneroRequerido;
	}
    
    

}
