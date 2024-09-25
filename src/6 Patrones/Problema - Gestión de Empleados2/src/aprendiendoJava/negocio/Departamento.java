package aprendiendoJava.negocio;

import aprendiendoJava.datos.DAODepartamento;

public class Departamento{
	private Integer id;
	private String nombre;
	private Float presupuesto;
	private static DAODepartamento dao = new DAODepartamento();
	
	public Departamento(int id, String nombre, float presupuesto){
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}
	
	public Departamento(String nombre, float presupuesto){
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}
	
	public Integer getId(){
		return this.id;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public Float getPresupuesto(){
		return this.presupuesto;
	}
	
	public void guardar() throws Exception{
		if (this.id == null)
			this.id = Departamento.dao.buscarSiguienteId();
		Departamento.dao.guardar(this);
	}
	
	public static Departamento buscarPorId(int id) throws Exception{
		return Departamento.dao.buscarPorId(id);
	}

}
