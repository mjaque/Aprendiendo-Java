package aprendiendoJava.negocio;

import java.util.List;
import java.time.LocalDate;
import aprendiendoJava.datos.DAOEmpleado;

public class Empleado{
	private Integer id;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private Departamento departamento;
	private static DAOEmpleado dao = new DAOEmpleado();
	
	public Empleado(int id, String nombre, String apellidos, LocalDate fechaNacimiento, Departamento departamento){
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.departamento = departamento;
	}
	
	public Empleado(String nombre, String apellidos, LocalDate fechaNacimiento, Departamento departamento){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.departamento = departamento;
	}

	
	public Integer getId(){
		return this.id;
	}
	
	public String getNombre(){
		return this.nombre;
	}

	public String getApellidos(){
		return this.apellidos;
	}

	public LocalDate getFechaNacimiento(){
		return this.fechaNacimiento;
	}
	
	public Departamento getDepartamento(){
		return this.departamento;
	}
	
	public void guardar() throws Exception{
		if (this.id == null)
			this.id = Empleado.dao.buscarSiguienteId();
		Empleado.dao.guardar(this);
	}
	
	public static List<Empleado> listar() throws Exception{
		return Empleado.dao.listar();
	}
	
	@Override
	public String toString(){
		return this.id + ": " + this.nombre + " " + this.apellidos + " (" + this.fechaNacimiento + ") Dpto: " + this.departamento.getNombre();
	}

}