import java.time.LocalDate;

//Esta clase representa una fila del TableView
public class FilaTabla {
	private String idVivienda;
	private String direccion;
	private String localidad;	//Debería ser población. Error del enunciado
	private LocalDate fecha;
	private Double importe;
	private String concepto;
	
	public FilaTabla(String idVivienda, String direccion, String localidad, LocalDate fecha, Double importe,
			String concepto) {
		super();
		this.idVivienda = idVivienda;
		this.direccion = direccion;
		this.localidad = localidad;
		this.fecha = fecha;
		this.importe = importe;
		this.concepto = concepto;
	}
	
	public String getIdVivienda() {
		return idVivienda;
	}
	public void setIdVivienda(String idVivienda) {
		this.idVivienda = idVivienda;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	
}
