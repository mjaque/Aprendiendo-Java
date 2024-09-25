package aprendiendoJava.datos;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import aprendiendoJava.negocio.Departamento;
import aprendiendoJava.negocio.Empleado;
import aprendiendoJava.datos.BD;

public class DAOEmpleado{
	private static final String SQL_SIGUIENTE_ID = "SELECT MAX(id)+1 FROM empleados";
	private static final String SQL_GUARDAR = "INSERT INTO empleados VALUES";
	private static final String SQL_LISTAR = "SELECT empleados.id, empleados.nombre, empleados.apellidos, empleados.fecha_nacimiento, " +
		" departamentos.id, departamentos.nombre, departamentos.presupuesto " +
		" FROM empleados JOIN departamentos ON empleados.idDepartamento = departamentos.id " +
		" ORDER BY empleados.apellidos";

	private static BD bd = new BD();
	
	public Integer buscarSiguienteId() throws Exception{
		try{
			ResultSet resultado = DAOEmpleado.bd.getSentencia().executeQuery(SQL_SIGUIENTE_ID);
			if (resultado.next())
				return resultado.getInt(1);
			else
				throw new Exception("No ha podido obtenerse el siguiente id de empleados.");
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos.");
		}
	}

	public void guardar(Empleado empleado) throws Exception{
		String sql = SQL_GUARDAR + "(" + empleado.getId() + ", '" + empleado.getNombre() + "', '" + empleado.getApellidos() + "', " 
			+ "'" + empleado.getFechaNacimiento().format(DateTimeFormatter.ISO_LOCAL_DATE) + "', "
			+ empleado.getDepartamento().getId() + ")";
		try{
			DAOEmpleado.bd.getSentencia().execute(sql);
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos al guardar Empleado.");
		}
	}
	
	public List<Empleado> listar() throws Exception{
		List<Empleado> listaEmpleados = new ArrayList<>();
		try{
			ResultSet resultado = DAOEmpleado.bd.getSentencia().executeQuery(SQL_LISTAR);
			while (resultado.next()){
				int idEmpleado = resultado.getInt("empleados.id");
				String nombreEmpleado = resultado.getString("empleados.nombre");
				String apellidos = resultado.getString("empleados.apellidos");
				Date fechaNacimientoSQL = resultado.getDate("empleados.fecha_nacimiento");
				LocalDate fechaNacimiento = fechaNacimientoSQL.toLocalDate();
				int idDepartamento = resultado.getInt("departamentos.id");
				String nombreDepartamento = resultado.getString("departamentos.nombre");
				Float presupuesto = resultado.getFloat("departamentos.presupuesto");
				Departamento departamento = new Departamento(idDepartamento, nombreDepartamento, presupuesto);
				listaEmpleados.add(new Empleado(idEmpleado, nombreEmpleado, apellidos, fechaNacimiento, departamento));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
			throw new Exception("Error de Base de Datos.");
		}
		return listaEmpleados;
	}

}
 
